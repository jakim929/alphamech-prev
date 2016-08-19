/**
* Map.java

* Handles the frame of the game
*
* By mostly Justin Zeng and James Kim
*
*/

package alphamech;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.math.*;
import java.awt.geom.*;

public class Map extends JPanel implements ActionListener 
{
	//Creating instances of the other classes
	ImageHandler imageHandler;
    Sprite p;
	Sprite p2;
	Creep c;
	Bullet bullet;
    Image img;
	Timer time;
    Font font;
	double mils = 0;
	int flip = -1;
	static boolean space = false;
	
	int chaser = 1;
	
	public Map() 
	{
		//Initialize all variables here
		imageHandler = new ImageHandler();
	    p = new Sprite("guy.png", 20, 100);
		p2 = new Sprite("guy2.png", 450, 100);
		c = new Creep();
		setFocusable(true);
		addKeyListener(new keyListener());
		font = new Font("Times New Roman", Font.BOLD, 16);
		time = new Timer(20, this);
		time.start();
	}
	
	public void actionPerformed(ActionEvent e)
	{
		p.move();
		p2.move();
		if (bullet != null)
			bullet.move();
		//c.move();
		repaint();
	}
	
	//Set these to the number of pixels of the block guys.
	public static final int DISTANCE = 32;
	public static final int DISTANCE2 = -32;
	
	public static boolean running = true;
	
	public void resetPositions(boolean fixed)
	{
		if (fixed)
		{
			p.x = 20;
			p.y = 100;
			p2.x = 450;
			p2.y = 100;
			c.x = 0;
			c.y = 450;
		}
		else
		{
			p.x = AlphaMech.random(430) + 20;
			p.y = AlphaMech.random(350) + 100;
			p2.x = AlphaMech.random(430) + 20;
			p2.y = AlphaMech.random(350) + 100;
		}
	}

	public void paint(Graphics g) //Constant repainting here, be careful with the coding. It doesn't take much to create hardtofix nullpointers.
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		ImageIcon i = new ImageIcon("backgrounds/" + Player.location + ".png");
		img = i.getImage();
		g2d.drawImage(img, 0, 0, null);
		final int height = g.getFontMetrics().getAscent();
		g2d.setColor(Color.black);
		g2d.setFont(font);
		mils++; //a timer

		g2d.drawString("" + AlphaMech.capName(), 0, height);
		g2d.drawString("Coins: " + Player.coins, 0, height + 20);
		g2d.drawString("Health: " + Player.health, 0, height + 40);
		g2d.drawString("Location: " + AlphaMech.getLocationName(Player.location), 0, height + 60);
		Image coin = null;
		if (flip == 1)
			coin = imageHandler.loadImageFromPath("coin.png");
		if (flip == 0)
			coin = imageHandler.loadImageFromPath("coin2.png");
		g2d.drawString("P1 Score: " + p.score, 300, height);
		g2d.drawString("P2 Score: " + p2.score, 300, height + 20);
		g2d.drawImage(coin, 470, height, null);
		
		if (chaser == 1)
		{
			g2d.drawString("Player 1 Chases Player 2!", 300, height + 60);
			if ((p.getX() - p2.getX() < DISTANCE && p.getX() - p2.getX() > DISTANCE2)
				&& (p2.getX() - p.getX() < DISTANCE && p2.getX() - p.getX() > DISTANCE2)
				&& (p.getY() - p2.getY() < DISTANCE && p.getY() - p2.getY() > DISTANCE2) 
				&& (p2.getY() - p.getY() < DISTANCE &&  p2.getY() - p.getY() > DISTANCE2))
			{
				//running = false;
				resetPositions(false);
				p2.score += mils;
				mils = 0;
				chaser = 2;
			}
		}
		
		if (chaser == 2)
		{
			g2d.drawString("Player 2 Chases Player 1!", 300, height + 60);
			if ((p.getX() - p2.getX() < DISTANCE && p.getX() - p2.getX() > DISTANCE2)
				&& (p2.getX() - p.getX() < DISTANCE && p2.getX() - p.getX() > DISTANCE2)
				&& (p.getY() - p2.getY() < DISTANCE && p.getY() - p2.getY() > DISTANCE2) 
				&& (p2.getY() - p.getY() < DISTANCE &&  p2.getY() - p.getY() > DISTANCE2))
			{
				//running = false;
				resetPositions(false);
				p.score += mils;
				mils = 0;
				chaser = 1;
			}
		}
		
		//g2d.drawImage(c.getImage(), c.getX(), c.getY(), null);
		g2d.drawImage(p2.getImage(), p2.getX(), p2.getY(), null); //The user should be drawn LAST.
		g2d.drawImage(p.getImage(), p.getX(), p.getY(), null); //The user should be drawn LAST.
		
		
		if (space == true)
		{
			///g2d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), null);
		}
		/*
		Rectangle2D.Double rect = new Rectangle2D.Double(p.getX() + 15, p.getY() + 5, 5, 20);
		g2d.setColor(Color.gray);
		g2d.fill(rect);
		*/
		
		/*
		if ((User.getX() - Creep.getX() < DISTANCE && User.getX() - Creep.getX() > DISTANCE2)
			&& (Creep.getX() - User.getX() < DISTANCE && Creep.getX() - User.getX() > DISTANCE2)
			&& (User.getY() - Creep.getY() < DISTANCE && User.getY() - Creep.getY() > DISTANCE2) 
			&& (Creep.getY() - User.getY() < DISTANCE &&  Creep.getY() - User.getY() > DISTANCE2))
		{
			//running = false;
			resetPositions();
			User2.score += 10;
		}
		if ((User2.getX() - Creep.getX() < DISTANCE && User2.getX() - Creep.getX() > DISTANCE2)
			&& (Creep.getX() - User2.getX() < DISTANCE && Creep.getX() - User2.getX() > DISTANCE2)
			&& (User2.getY() - Creep.getY() < DISTANCE && User2.getY() - Creep.getY() > DISTANCE2) 
			&& (Creep.getY() - User2.getY() < DISTANCE &&  Creep.getY() - User2.getY() > DISTANCE2))
		{
			//running = false;
			resetPositions();
			User.score += 10;
		}
		*/
	}
	
	public static String direction = "DOWN";
	
	public class keyListener extends KeyAdapter
	{
	    public void keyReleased(KeyEvent e)
		{
			int key = e.getKeyCode();
		    p.keyReleased(e);
			p2.keyReleased(e);
		}
	    public void keyPressed(KeyEvent e)
		{
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_ESCAPE) 
			{
				flip = coinFlip();
			}
			if (key == KeyEvent.VK_SPACE)
			{
				bullet = new Bullet(p.getX(), p.getY());
				space = true;
			}
		    p.keyPressed(e);
			p2.keyPressed(e);
		}
	}
	
	public int coinFlip()
	{
		int i = AlphaMech.random(1);
		if (i == 0)
			System.out.println("\nYou flipped a coin. The result was tails.");
		else
			System.out.println("\nYou flipped a coin. The result was heads.");
		return i;
	}

}