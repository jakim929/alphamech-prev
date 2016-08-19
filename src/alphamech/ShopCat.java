/*
 * This is the file that takes care of all shops
 * 
 * By James Kim and Justin Zeng
 */
package alphamech;

import java.io.IOException;

public class ShopCat extends AlphaMech
{
	public static int locationId = AlphaMech.location;
	//in the first bracket {{Here},{}} put the itemId's of the items in the shop. 
	//in the second bracket {{},{Here}} put the price (in coins) of the items according manner, order.
	public static int[] shopIq = null;
	public static int[] shop1 = {2,3,4,6,7,8,9,1508}; //Shop at locationnumber 1=> in this case Lambury Town
	public static int[] shop2 = {}; //Shop at locationnumber 2
	public static int[] shop3 = {}; //Shop at locationnumber 3
	public static int[] shop4 = {}; // etc...........
	public static int[] shop5 = {};
	public static int[] shop6 = {};
	public static int[] shop7 = {};
	public static int[] shop8 = {};
	public static int[] shop9 = {};
	public static int[] shop10 = {};
	public static int[] shop11 = {};
	public static int[] shop12 = {};
	
	/*
	* Shop Documentation
	*
	* Inside brackets are for each items, even if ONE item isn't loaded it crashes (technically catched, but wtv)
	*
	*/
	
	public static void printCatalog() throws IOException
	{
		
		if(locationId ==1)
			shopIq = shop1;
		if(locationId ==2)
			shopIq = shop2;
		if(locationId ==3)
			shopIq = shop3;
		if(locationId ==4)
			shopIq = shop4;
		if(locationId ==5)
			shopIq = shop5;
		if(locationId ==6)
			shopIq = shop6;
		if(locationId ==7)
			shopIq = shop7;
		if(locationId ==8)
			shopIq = shop8;
		if(locationId ==9)
			shopIq = shop9;
		if(locationId ==10)
			shopIq = shop10;
		if(locationId ==11)
			shopIq = shop11;
		if(locationId ==12)
			shopIq = shop12;
		
		println("Welcome to the "+getLocationName(locationId)+" " +"Shops!\nWe will try our best to rip you off!" );
		System.out.println("\n\tItem/Price");
		for(int i =0; i <shopIq.length; i++)
		{
			System.out.println((i+1)+". "+ItemFinder.getName(shopIq[i])+"\t\t: "+ItemFinder.getPrice(shopIq[i])+" coins");
		}
		
	}
	
	public static void buyItem(int catNum) throws IOException
	{
		int itemId = shopIq[catNum -1];
		int price = ItemFinder.getPrice(itemId);
		
		if (coins - price < 0)
		{
			System.out.println("You don't have enough fucking coins. Go beg for coins dude.");
		}
		else
		{
			System.out.println("You bought a "+ItemFinder.getName(itemId));
			addItem(itemId,1);
			coins -= price;
		}
	}
	
}
