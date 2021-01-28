package testTask;

import java.awt.*;

public class Trapezoid extends Shape
{
	int x[][] = new int[2][2];
	int y[][] = new int[2][2];
	int base[] = new int[2];
	double sides[] = new double[2];
	public Trapezoid()
	{
		color = rand.nextInt(5);
		int tmpLowHeight = rand.nextInt(50)+100;
		int tmpMaxHeight = tmpLowHeight+rand.nextInt(100)+50;
		for(int i=0;i<2;i++)
		{
			base[i] = rand.nextInt(100)+50+50*(i*6);
			x[i][0] = rand.nextInt(100)+50*(4-(i*4));
			x[i][1] = x[i][0]+base[i];
			y[0][i] = tmpLowHeight;
			y[1][i] = tmpMaxHeight;
		}		
		sides[0] = Math.sqrt(Math.pow(x[0][0]-x[1][0], 2)+Math.pow(y[0][0]-y[1][0], 2));
		sides[1] = Math.sqrt(Math.pow(x[0][1]-x[1][1], 2)+Math.pow(y[0][1]-y[1][1], 2));
	}
	public double getPerimeter() 
	{
		double res=0;
		for(int i=0;i<2;i++)
		{
			res+=base[i]+sides[i];
		}
		return res;
	}
	public String getInfo() 
	{
		String res;
		res = "Trapezoid with perimeter equal: " + getPerimeter() +
			"; And Base 1 =  " + base[0] + " Base 2 =  " + base[1] +
			" Side 1 =  " + sides[0] + " Side 2 = " + sides[1]+
			" have a "+ getColorName()+" color" +"\n";;
		for (int i = 0; i<2;i++)
		{
			for (int j = 0; j<2;j++)
			{
				res += "(" +x[i][j] + ";" + y[i][j] + ")		";
			}
			res += "\n";
		}
		return res;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int gX[] = new int [] {x[0][0],x[0][1],x[1][1],x[1][0]};
		int gY[] = new int [] {y[0][0],y[0][1],y[1][1],y[1][0]};
		Graphics2D g2 = (Graphics2D) g;
		Color col = getColor();
		g2.setColor(col);
		g2.fillPolygon(gX, gY, 4);
	}
}
