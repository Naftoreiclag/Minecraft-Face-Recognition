package naftoreiclag.mcfacerecog;

import java.awt.Color;

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
        
        float[] nat1 = Color.RGBtoHSB(r1, g1, b1, null);
        float[] nat2 = Color.RGBtoHSB(r2, g2, b2, null);
        
        /*
        for(float f : nat1)
        {
        	System.out.println(f);
        }
        for(float f : nat2)
        {
        	System.out.println(f);
        }
        */
        
        return (float) Math.sqrt(Math.pow(nat1[0] - nat2[0], 2d) + Math.pow(nat1[1] - nat2[1], 2d) + Math.pow(nat1[2] - nat2[2], 2d));
	}
}
