package testTask;

import java.awt.*;

public class Square extends Shape 
{
	int x[][] = new int[2][2];
	int y[][] = new int[2][2];
	int side;
	public Square()
	{
		color = rand.nextInt(5);
		side = rand.nextInt(200)+100;
		x[0][0] = rand.nextInt(90)+10;
		y[0][0] = rand.nextInt(90)+10;
		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				if (i==0&&j==0)
				{
					continue;
				}
				if (j%2==1)
				{
					x[i][j] = x[0][0]+side;					
				}
				else
				{
					x[i][j] = x[0][0];
					
				}
				if (i%2==1)
				{
					y[i][j] = y[0][0]+side;
				}
				else
				{
					y[i][j] = y[0][0];
				}
				
			}
		}
	}
	public double getPerimeter() 
	{
		return 4*side;
	}
	public int getSide()
	{
		return side;
	}
	public String getInfo() 
	{
		String res;
		res = "Square with perimeter equal: " + getPerimeter() +"; And side = " + side +
				" have a "+ getColorName()+" color" +"\n";
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
		 Graphics2D g2 = (Graphics2D) g;
		 Color col = getColor();
		 g2.setColor(col);
		 g2.fillRect(x[0][0], y[0][0], side, side);
	}
}
