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
		helloWorld = FaceGetter.getSkin("Reiclag");
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(helloWorld, null, 10, 10);
	}
}
