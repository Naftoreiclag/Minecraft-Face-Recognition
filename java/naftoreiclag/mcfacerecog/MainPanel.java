package naftoreiclag.mcfacerecog;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainPanel extends JPanel
{
	BufferedImage helloWorld;
	
	public MainPanel()
	{
		this.setSize(300, 200);
		
		helloWorld = FaceGetter.getSkin("Reiclag");
		
		System.out.println(ColorCompare.similarity(helloWorld.getRGB(0, 0), helloWorld.getRGB(0, 1)));
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(helloWorld, 10, 10, 64, 64, null);
	}
}
