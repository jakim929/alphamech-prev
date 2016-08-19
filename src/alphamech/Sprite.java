/**
* Sprite.java

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

public class Sprite
{
	public int x, dx, y, dy, increase, decrease, score;
	
	Image pSprite;
	ImageHandler imageHandler;
	String spriteFile;
	boolean hidden = false;
	public static final int highestX = 20;
	public static final int lowestX = 450;
	public static final int highestY = 100;
	public static final int lowestY = 450;
	
	public Sprite(String spriteFile, int x, int y)
	{
		score = 0;
		imageHandler = new ImageHandler();
		pSprite = imageHandler.loadImageFromPath(spriteFile);
		this.spriteFile = spriteFile;
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
		return pSprite;
	}
	
	public Object clone()
	{
		return new Sprite(spriteFile, getX(), getY());
	}
	
	public void move()
	{
		if (!Map.running)
			return;
	    if (dx == increase)
		{
		    if (x != lowestX)
			{
			    if (dx + x > lowestX) 
				{
				    x = lowestX;
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
				} else 
				{
	                y = y + dy;
				}
			}
		}
	}
	
	public void keyPressed(KeyEvent e)
	{
	    int key = e.getKeyCode();
		if (spriteFile.equalsIgnoreCase("guy.png"))
		{
			switch (key) 
			{
				case KeyEvent.VK_LEFT:
					dx = decrease;
					if (!Map.space)
					Map.direction = "LEFT";
				break;
				
				case KeyEvent.VK_RIGHT:
					dx = increase;
					if (!Map.space)
					Map.direction = "RIGHT";
				break;
			
				case KeyEvent.VK_UP:
					dy = decrease;
					if (!Map.space)
					Map.direction = "UP";
				break;
				
				case KeyEvent.VK_DOWN:
					dy = increase;
					if (!Map.space)
					Map.direction = "DOWN";
				break;
			}
		}
		if (spriteFile.equalsIgnoreCase("guy2.png"))
		{
			switch (key) 
			{
				case KeyEvent.VK_A:
					dx = decrease;
					if (!Map.space)
					Map.direction = "LEFT";
				break;
				
				case KeyEvent.VK_D:
					dx = increase;
					if (!Map.space)
					Map.direction = "RIGHT";
				break;
			
				case KeyEvent.VK_W:
					dy = decrease;
					if (!Map.space)
					Map.direction = "UP";
				break;
				
				case KeyEvent.VK_S:
					dy = increase;
					if (!Map.space)
					Map.direction = "DOWN";
				break;
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
	
	public void keyReleased(KeyEvent e)
	{
	    int key = e.getKeyCode();
		if (spriteFile.equalsIgnoreCase("guy.png"))
		{
			switch (key) 
			{
				case KeyEvent.VK_LEFT:
				case KeyEvent.VK_RIGHT:
					dx = 0;
				break;
				
				case KeyEvent.VK_UP:
				case KeyEvent.VK_DOWN:
					dy = 0;
				break;
			}
		}
		if (spriteFile.equalsIgnoreCase("guy2.png"))
		{
			switch (key) 
			{
				case KeyEvent.VK_A:
				case KeyEvent.VK_D:
					dx = 0;
				break;
				
				case KeyEvent.VK_W:
				case KeyEvent.VK_S:
					dy = 0;
				break;
			}
		}
	}
}