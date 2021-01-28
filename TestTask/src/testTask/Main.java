package testTask;

import java.awt.*;
import javax.swing.JFrame;

import java.util.Random;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		Random rnd = new Random();
		Scanner keyboard = new Scanner(System.in);
		int inptInt;
  
		JFrame f = new JFrame();
		Container c = f.getContentPane();
		
		Shape[] myShapes = new Shape[rnd.nextInt(5)+3];
		for (int i=0;i<myShapes.length;i++)
		{
			switch(rnd.nextInt(4))
			{
			case 0:
				myShapes[i] = new Circle();
				break;
			case 1:
				myShapes[i] = new Triangle();
				break;
			case 2:
				myShapes[i] = new Square();
				break;
			case 3:
				myShapes[i] = new Trapezoid();
				break;
			}
			System.out.print(myShapes[i].getInfo());
		}
		do {
			System.out.print("What shape to draw (specify the number). For exit type 99");
			inptInt = keyboard.nextInt();
			//drawing shapes		
			//f = new JFrame();
			c.removeAll();
			c = f.getContentPane();
			c.setLayout(new BorderLayout());
			c.add(myShapes[inptInt]);
			f.setSize(800,800);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//drawing shapes
		}while(inptInt!=99);
    }
}
