package testTask;

import java.awt.*;

public class Triangle extends Shape 
{
	int x[] = new int [3];
	int y[] = new int [3];
	double hypotenuse;
	double sides[] = new double[2];
	public Triangle()
	{
		color = rand.nextInt(5);
		for (int i= 0; i<3;i++)
		{
			x[i] = rand.nextInt(290)+10;
			y[i] = rand.nextInt(290)+10;
		}
		hypotenuse = Math.sqrt(Math.pow(x[2]-x[0], 2)+Math.pow(y[2]-y[0], 2));
		int counter = 0;
		for(int i= 1; i<3;i++)
		{
			double tmp = Math.sqrt(Math.pow(x[i]-x[i-1], 2)+Math.pow(y[i]-y[i-1], 2));

			if(tmp>hypotenuse)
			{
				sides[counter]=hypotenuse;
				hypotenuse=tmp;
				counter++;
			}
			else
			{
				sides[counter]=tmp;
				counter++;
			}
		}
	}	
	public double getPerimeter() 
	{
		return hypotenuse+sides[0]+sides[1];
	}
	public double getHypotenuse()
	{
		return hypotenuse;
	}
	public String getInfo() {
		String res;
		res = "Triangle with perimeter equal: " + getPerimeter() +
			"; And hypotenuse =  " + hypotenuse + " Side 1 =  " + sides[0] + 
				" Side 2 = " + sides[1]+" have a "+ getColorName()+" color" +"\n";
		for (int i=0;i<3;i++)
		{
			res += "(" +x[i] + ";" + y[i]+ ")\n";
		}
		return res;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D) g;
		 Color col = getColor();
		 g2.setColor(col);
		 g2.fillPolygon(x, y, 3);
	}
}
