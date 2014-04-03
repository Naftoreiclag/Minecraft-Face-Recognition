package naftoreiclag.mcfacerecog;

import java.awt.image.BufferedImage;

public class ShapeDetector
{
	public static BufferedImage detectShape(BufferedImage img, int x, int y)
	{
		// Stores which have been checked
		boolean[][] checkedPixels = new boolean[8][8];
		boolean[][] goodPixels = new boolean[8][8];
		
		compare(img, checkedPixels, goodPixels, img.getRGB(x, y), x, y);
		
		BufferedImage returnVal = new BufferedImage(8, 8, BufferedImage.TYPE_INT_ARGB);
		
		for(int xp = 0; xp < 8; xp ++)
		{
			for(int yp = 0; yp < 8; yp ++)
			{
				if(goodPixels[xp][yp])
				{
					img.setRGB(xp, yp, 0xFF000000);
				}
				else
				{
					img.setRGB(xp, yp, 0x00000000);
				}
			}
		}
		
		return returnVal;
	}
	
	public static void compare(BufferedImage img, boolean[][] checkedPixels, boolean[][] goodPixels, int baseColor, int x, int y)
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
		if(ColorCompare.similarity(baseColor, otherColor) < 0.3f)
		{
			// Then yes
			goodPixels[x][y] = true;
			
			// Compare neighbor pixels
			compare(img, checkedPixels, goodPixels, otherColor, x + 1, y);
			compare(img, checkedPixels, goodPixels, otherColor, x, y + 1);
			compare(img, checkedPixels, goodPixels, otherColor, x - 1, y);
			compare(img, checkedPixels, goodPixels, otherColor, x, y - 1);
		}
	}
}
