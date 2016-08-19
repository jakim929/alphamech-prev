/**
* Bullet.java

* Handles the sprites
*
* by Justin Zeng and James Kim
*
*/

package alphamech;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.math.*;
import java.awt.geom.*;
import java.awt.Image;

public class Bullet
{
	public int x, dx, y, dy, increase, decrease;
	
	Image pSprite;
	ImageHandler imageHandler;
	String spriteFile;
	boolean hidden = false;
	public static final int highestX = 0;
	public static final int lowestX = 470;
	public static final int highestY = 80;
	public static final int lowestY = 470;
	
	public Bullet(int x, int y)
	{
		imageHandler = new ImageHandler();
		pSprite = imageHandler.loadImageFromPath("bullet.png");
		this.spriteFile = "bullet.png";
		this.x = x;
		this.y = y;
		increase = 5;
		decrease = -5;
		this.pSprite = pSprite;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getWidth()
	{
		return getImage().getWidth(null);
	}
	
	public int getHeight()
	{
		return getImage().getHeight(null);
	}
	
	public int getVelocityX()
	{
		return dx;
	}
	
	public int getVelocityY()
	{
		return dy;
	}
	
	public void setVelocityX(int dx)
	{
		this.dx = dx;
	}
	
	public void setVelocityY(int dy)
	{
		this.dy = dy;
	}
	
	public Image getImage()
	{
		if (Map.space)
			return pSprite;
		else
			return null;
	}
	
	public Object clone()
	{
		return new Bullet(getX(), getY());
	}
	
	public static String direction = "DOWN";
	
	public void setVel()
	{
		if (Map.direction.equalsIgnoreCase("UP"))
			dy = decrease;
		if (Map.direction.equalsIgnoreCase("DOWN"))
			dy = increase;
		if (Map.direction.equalsIgnoreCase("RIGHT"))
			dx = increase;
		if (Map.direction.equalsIgnoreCase("LEFT"))
			dx = decrease;
	}
	
	//
			
	public void move()
	{
		if (!Map.running)
			return;
		if (!Map.space)
			return;
		setVel();
	    if (dx == increase)
		{
		    if (x != lowestX)
			{
			    if (dx + x > lowestX) 
				{
				    x = lowestX;
					Map.space = false;
				} else
				{
	                x = x + dx;
				}
			}
		}
	    if (dx == decrease)
		{
		    if (x != highestX) 
			{
			    if (dx + x < highestX)
				{
				    x = highestX;
					Map.space = false;
				} else
				{
	                x = x + dx;
				}
			}
		}
	    if (dy == increase)
		{
		    if (y != lowestY)
			{
			    if (dy + y > lowestY)
				{
				    y = lowestY;
					Map.space = false;
				} else
				{
	                y = y + dy;
				}
			}
		}
	    if (dy == decrease)
		{
		    if (y != highestY)
			{
			    if (dy + y < highestY)
				{
				    y = highestY;
					Map.space = false;
				} else 
				{
	                y = y + dy;
				}
			}
		}
	}
	
	public void hide()
	{
		hidden = true;
	}
	
	public void show()
	{
		hidden = false;
	}
}