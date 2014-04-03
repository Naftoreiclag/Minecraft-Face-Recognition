package naftoreiclag.mcfacerecog;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Main extends JFrame
{
	public Main()
	{
		super("fjieoawretryuoragjioaewf");
		this.setSize(100, 100);
		this.setLocationRelativeTo(null);
		
		FaceGetter.loadErrorFace();
		
		MainPanel m = new MainPanel();
		
		this.add(m);
	}

	public static void main(String[] args)
	{
		Main m = new Main();
		m.setVisible(true);
	}
}
