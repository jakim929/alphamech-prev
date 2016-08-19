/*
 * This file acts as the main item handler, and contains getters for all item properties

 * 
 * By James Kim, Justin Zeng
 * 
 * BTW i know this is the old, traditional way, but just keep it this way, as it is separate from the AlphaMech.java 
 */
 
package alphamech;
import java.io.*;

public class ItemFinder
{
	public static BufferedReader iR = null;
		
	public static String getName(int itemId) throws IOException
	{
		iR = new BufferedReader(new FileReader("./items/"+itemId+".txt"));
		iR.readLine();
		String name = iR.readLine();
		return name;
		
	}

/**
* Documented Item List
*
* 0. Dwarf Head
* 1. Noob
* 2. Potion
* 3. Stick
* 4. Steel Sword
* 5. Arcane Destroyer
* 6. Liquid Hally
* 7. Dragon Claws
* 8. Rainbow Claws
* 9. Fluorine Blade
*
*/
	public static int getType(int itemId) throws IOException
	{
		/*
		type 0 - object ( no use)
		type 1 - weapon
		type 2 - armor
		type 3 - food
		*/
		iR = new BufferedReader(new FileReader("./items/"+itemId+".txt"));
		for(int i = 0; i<2; i++)
			iR.readLine();
		int type = Integer.parseInt(iR.readLine());
		iR.close();
		return type;
		
	}
	
	public static int getPrice(int itemId) throws IOException
	{
		iR = new BufferedReader(new FileReader("./items/"+itemId+".txt"));
		for(int i = 0; i<3; i++)
			iR.readLine();
		int price = Integer.parseInt(iR.readLine());
		iR.close();
		return price;
		
	}
	
	public static int getWeight(int itemId) throws IOException
	{
		/*
		0 - nothing (money, cards, paper, etc)
		1 - light objects (food, small weapons, clothes)
		2 - light-medium
		3 - medium (regular weapons)
		4 - medium heavy (regular weapons)
		5 - heavy (heavy weapons)
		*/
		iR = new BufferedReader(new FileReader("./items/"+itemId+".txt"));
		for(int i = 0; i<4; i++)
			iR.readLine();
		int weight = Integer.parseInt(iR.readLine());
		iR.close();
		return weight;
		
	}
	
	public static int getWbonus(int itemId) throws IOException
	{
		/*
		0 - disabilities
		5 - equiv to unnarmed
		10 - weak weps
		25 - medium weps
		50 - strong weps
		*/
		iR = new BufferedReader(new FileReader("./items/"+itemId+".txt"));
		for(int i = 0; i<5; i++)
			iR.readLine();
		int wbonus = Integer.parseInt(iR.readLine());
		iR.close();
		return wbonus;
		
	}
	
}

