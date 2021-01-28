package testTask;

import java.awt.*;
import java.util.*;
import javax.swing.JPanel;

public abstract class Shape extends JPanel
{
	Random rand = new Random();
	int color;
	double perimeter;
	public abstract double getPerimeter();
	public abstract String getInfo();
	public Color getColor()
	{
		Color res;
		switch (color)
		{
			case 0:
				res=Color.YELLOW;
				break;
			case 1:
				res=Color.GREEN;
				break;
			case 2:
				res=Color.BLUE;
				break;
			case 3:
				res=Color.WHITE;
				break;
			case 4:
				res=Color.RED;
				break;
			default:
				res=Color.BLACK;
		}		
		return res;
	}
	public String getColorName()
	{
		String res="";
		switch (color)
		{
			case 0:
				res="Yellow";
				break;
			case 1:
				res="Green";
				break;
			case 2:
				res="Blue";
				break;
			case 3:
				res="White";
				break;
			case 4:
				res="Red";
				break;
		}
		return res;
	}
}
