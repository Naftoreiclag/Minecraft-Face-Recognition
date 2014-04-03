package naftoreiclag.mcfacerecog;

public class ColorCompare
{
	public static float similarity(int c1, int c2)
	{
		int r1 = (c1 >> 16) & 0xff;
        int g1 = (c1 >>  8) & 0xff;
        int b1 = (c1      ) & 0xff;
        int r2 = (c2 >> 16) & 0xff;
        int g2 = (c2 >>  8) & 0xff;
        int b2 = (c2      ) & 0xff;
	}
}
