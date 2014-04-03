package naftoreiclag.mcfacerecog;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ShapeDetector
{
	public static final float tolerance = 0.2f;
	
	public static BufferedImage[] detectShapes(BufferedImage img)
	{
		List<BufferedImage> returnVal = new ArrayList<BufferedImage>();
		
		boolean[][] claimedPixels = new boolean[8][8];
		
		for(int xp = 0; xp < 8; xp ++)
		{
			for(int yp = 0; yp < 8; yp ++)
			{
				if(!claimedPixels[xp][yp])
				{
					boolean[][] result = detectShape(img, xp, yp);
					
					claimedPixels = orArray(claimedPixels, result);
					returnVal.add(convertToImage(result));
				}
			}
		}
		
		BufferedImage[] two = new BufferedImage[returnVal.size()];
		
		for(int i = 0; i < two.length; ++ i)
		{
			two[i] = returnVal.get(i);
		}
		
		return two;
	}
	
	public static boolean[][] orArray(boolean[][] a, boolean[][] b)
	{
		boolean[][] returnVal = new boolean[8][8];
		
		for(int xp = 0; xp < 8; xp ++)
		{
			for(int yp = 0; yp < 8; yp ++)
			{
				returnVal[xp][yp] = a[xp][yp] || b[xp][yp];
			}
		}
		
		return returnVal;
	}
	
	public static boolean[][] detectShape(BufferedImage img, int x, int y)
	{
		return detectShape(img, x, y, new boolean[8][8]);
	}
	
	public static boolean[][] detectShape(BufferedImage img, int x, int y, boolean[][] checkedPixels)
	{
		// Stores which have been checked
		boolean[][] goodPixels = new boolean[8][8];
		
		// Begin the stack calculation
		stackCompare(img, checkedPixels, goodPixels, img.getRGB(x, y), x, y);
		
		return goodPixels;
	}
	
	public static BufferedImage convertToImage(boolean[][] goodPixels)
	{
		// Convert this into an image
		BufferedImage returnVal = new BufferedImage(8, 8, BufferedImage.TYPE_INT_ARGB);
		for(int xp = 0; xp < 8; xp ++)
		{
			for(int yp = 0; yp < 8; yp ++)
			{
				if(goodPixels[xp][yp])
				{
					returnVal.setRGB(xp, yp, 0xFF000000);
				}
				else
				{
					returnVal.setRGB(xp, yp, 0x00000000);
				}
			}
		}
		
		return returnVal;
	}
	
	// Stack-based flood fill with two arrays: One to keep track of who has been checked, and one as a carry. Other params are self-explanitory.
	public static void stackCompare(BufferedImage img, boolean[][] checkedPixels, boolean[][] goodPixels, int baseColor, int x, int y)
	{
		// Bounds check
		if(x < 0 || x >= 8 || y < 0 || y >= 8) { return; }
		
		// If this has already been checked, then don't care
		if(checkedPixels[x][y]) { return; }
		
		// We are about to check this one
		checkedPixels[x][y] = true;
		
		// Get the other color
		int otherColor = img.getRGB(x, y);
		
		// If the two colors are similar
		if(ColorCompare.similarity(baseColor, otherColor) < tolerance)
		{
			// Then yes
			goodPixels[x][y] = true;
			
			// Compare neighbor pixels
			stackCompare(img, checkedPixels, goodPixels, otherColor, x + 1, y);
			stackCompare(img, checkedPixels, goodPixels, otherColor, x, y + 1);
			stackCompare(img, checkedPixels, goodPixels, otherColor, x - 1, y);
			stackCompare(img, checkedPixels, goodPixels, otherColor, x, y - 1);
		}
	}
}
