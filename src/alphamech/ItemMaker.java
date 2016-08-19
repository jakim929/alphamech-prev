/*
 * By James Kim, Justin Zeng
 *
 * This file makes all the items, and runs by itself, not in correlation.
 * The type for an item will be determined later
 * For now, weapons are type 1
 * 
 */
 
package alphamech;

import java.io.*;

public class ItemMaker extends AlphaMech
{
	public static void main(String args[])
	{
		try
		{
			File f = new File("./items");
			f.mkdir();
			BufferedWriter bwin = null;
			BufferedReader keyboard = null;
			try
			{
				keyboard = new BufferedReader(new InputStreamReader(System.in));
				System.out.print("Type in the Item Number(ID) of the item: ");
				String itemId = keyboard.readLine();
				
				bwin = new BufferedWriter(new FileWriter(("./items/"+ itemId + ".txt"), false)); //false = overwrites
				
				bwin.write(itemId);
				bwin.newLine();
				
				System.out.print("Type in the item name (word): ");
				String itemName = keyboard.readLine();
				bwin.write(itemName);
				bwin.newLine(); //newLine() is better than \n as we can read it easier in regular notepad.exe :D
				System.out.print("Type in the kind of the item (number): ");
				String type = keyboard.readLine();
				bwin.write(type);
				bwin.newLine();
				System.out.print("Type in the price (number): ");
				String price = keyboard.readLine();
				bwin.write(price);
				bwin.newLine();
				System.out.print("Type in the weight (number): ");
				String weight = keyboard.readLine();
				bwin.write(weight);
				bwin.newLine();
				System.out.print("Type in the weapon bonus (number): ");
				String wbonus = keyboard.readLine();
				bwin.write(wbonus);
				bwin.newLine();
				bwin.flush();
				bwin.close(); //think this is needed too
			}
			catch(IOException e)
			{
				System.out.println("Something happened and its not good");
				if (DEBUG)
				{
					e.printStackTrace();
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Something happened and its not good");
			if (DEBUG)
			{
				e.printStackTrace();
			}
		}
		
	}
	
}
