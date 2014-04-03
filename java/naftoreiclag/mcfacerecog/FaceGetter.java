package naftoreiclag.mcfacerecog;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class FaceGetter
{
	public static BufferedImage errorFace;
	
	public static void loadErrorFace()
	{
		errorFace = new BufferedImage(8, 8, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D painter = (Graphics2D) errorFace.getGraphics();
		
		painter.setColor(Color.WHITE);
		painter.drawRect(0, 0, 8, 8);
		
		errorFace.setRGB(2, 1, 0);
		errorFace.setRGB(3, 1, 0);
		errorFace.setRGB(4, 1, 0);
		errorFace.setRGB(5, 1, 0);
		errorFace.setRGB(2, 2, 0);
		errorFace.setRGB(5, 2, 0);
		errorFace.setRGB(5, 3, 0);
		errorFace.setRGB(3, 4, 0);
		errorFace.setRGB(4, 4, 0);
		errorFace.setRGB(3, 6, 0);
	}
	
	public static BufferedImage getSkin(String username)
	{
		BufferedImage returnVal;
		
		try
		{
			returnVal = ImageIO.read(new URL("http://skins.minecraft.net/MinecraftSkins/" + username + ".png"));
			returnVal = returnVal.getSubimage(8, 8, 8, 8);
			
			System.out.println("Successfully got face from " + username);
		}
		catch (IOException e)
		{
			returnVal = errorFace;
			
			System.out.println("Failed to get face from " + username);
		}
		
		return returnVal;
	}
}
