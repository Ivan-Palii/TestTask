package testTask;

import java.awt.*;

public class Circle extends Shape
{
	int centerX, centerY, radius;
	public Circle()
	{
		color = rand.nextInt(5);
		centerX = rand.nextInt(50)+150;
		centerY = rand.nextInt(50)+150;
		radius = rand.nextInt(100)+40;
	}	
	public double getPerimeter() 
	{
		return 2*radius*Math.PI;
	}
	public int getRadius()
	{
		return radius;
		}
	public String getInfo() 
	{
		String res;
		res = "Circle with perimeter equal: " + getPerimeter() +
			"; And radius = " + radius + "\n" + 
			"Center - (" +centerX + ";" + centerY+ ")" +
			" have a "+ getColorName()+" color" +"\n";
		return res;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		 Graphics2D g2 = (Graphics2D) g;
		 Color col = getColor();
		 g2.setColor(col);
		 g2.fillOval(centerX,centerY,radius,radius);
	}
}
