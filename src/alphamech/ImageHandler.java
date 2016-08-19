package alphamech;

import java.awt.*;
import javax.swing.*;

public class ImageHandler 
{
	
	public Image loadImageFromPath(String path)
	{
	    try 
		{
	       ImageIcon image = new ImageIcon(path);
	       return image.getImage();
	    } 
		catch (Exception e)
		{
	    	e.printStackTrace();
			System.out.println("Image " + path + "was not found!");
	    	return null;
	    }
	}
	
	public Image loadImageFromJar(String path) 
	{
		try 
		{
			ImageIcon image = (new ImageIcon(getClass().getResource(path)));
			return image.getImage();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Image " + path + "was not found!");
			return null;
		}
	}
}
