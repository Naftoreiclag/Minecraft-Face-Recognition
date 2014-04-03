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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 200);
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
