/**
* Creep.java
* Handles the 2D enemy
*
* by Justin Zeng and James Kim
*
*/

package alphamech;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Creep
{
    Image pSprite;
	static int x, dx, y, dy, increase, decrease, highestX, lowestX, highestY, lowestY;
	ImageHandler imageHandler;
	
	public Creep() 
	{
		imageHandler = new ImageHandler();
		pSprite = imageHandler.loadImageFromPath("creep.png");
		//x = AlphaMech.random(500);
		//y = AlphaMech.random(500);
		x = 0;
		y = 450;
		lowestX = 450;
		highestX = 20;
		lowestY = 450;
		highestY = 100;
	}
	
	public static int getX() 
	{
	    return x;
	}
	
	public static int getY()
	{
	    return y;
	}
	
	public void reset()
	{
	    x = 250;
		y = 260;
	}
	/**
	public static void move()
	{
		if (!Map.running)
			return;
		int rand = MainMethods.random(3);
		/*
		switch (rand)
		{
			case 0:
				dx = increase;
				break;
			case 1:
				dx = decrease;
				break;
			case 2:
				dy = increase;
				break;
			case 3:
				dy = decrease;
				break;
		}
		
		
		
		int distance1X = 0;
		int distance1Y = 0;
		int distance2X = 0;
		int distance2Y = 0;
		int totalDistanceX = 0;
		int totalDistanceY = 0;
		String direction1X = "";
		String direction1Y = "";
		String direction2X = "";
		String direction2Y = "";
		/*
		///calculates distance from user1
		if (User.getX() > Creep.getX())
		{
			direction1X = "RIGHT";
			distance1X = User.getX() - Creep.getX();
		}
		if (User.getX() < Creep.getX())
		{
			direction1X = "LEFT";
			distance1X = Creep.getX() - User.getX();
		}
		if (User.getY() > Creep.getY())
		{
			direction1Y = "DOWN";
			distance1Y = User.getY() - Creep.getY();
		}
		if (User.getY() < Creep.getY())
		{
			direction1Y = "UP";
			distance1Y = Creep.getY() - User.getY();
		}
		
		///calculates distance from user2
		if (User2.getX() > Creep.getX())
		{
			direction2X = "RIGHT";
			distance2X = User2.getX() - Creep.getX();
		}
		if (User2.getX() < Creep.getX())
		{
			direction2X = "LEFT";
			distance2X = Creep.getX() - User2.getX();
		}
		if (User2.getY() > Creep.getY())
		{
			direction2Y = "DOWN";
			distance2Y = User2.getY() - Creep.getY();
		}
		if (User2.getY() < Creep.getY())
		{
			direction2Y = "UP";
			distance2Y = Creep.getY() - User2.getY();
		}
		
		if (distance1X < distance2X)
		{
			if (direction1X.equals("LEFT"))
				x -= 1;
			if (direction1X.equals("RIGHT"))
				x += 1;
		}
		else if (distance2X > distance2Y)
		{
			if (direction2X.equals("LEFT"))
				x -= 1;
			if (direction2X.equals("RIGHT"))
				x += 1;
		}
		else
		{
			x += AlphaMech.random(2) - 2;
			y += AlphaMech.random(2) - 2;
		}
		if (distance1Y < distance2Y)
		{
			if (direction1Y.equals("UP"))
				y -= 1;
			if (direction1Y.equals("DOWN"))
				y += 1;
		}
		else if (distance2Y > distance1Y)
		{
			if (direction2Y.equals("UP"))
				y -= 1;
			if (direction2Y.equals("DOWN"))
				y += 1;		
		}
		else
		{
			x += AlphaMech.random(2) - 2;
			y += AlphaMech.random(2) - 2;
		}
		//ONE = 0, 0. TWO = 500, 500.
		//ENEMY = 10, 10.
		
	}
	*/
	public Image getImage() 
	{
	    return pSprite;
	}
	
}