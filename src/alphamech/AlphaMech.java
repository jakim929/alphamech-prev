/**
* AlphaMech.java
* Most methods of the game will be found here. Most handling is also done here.
*
* by Justin Zeng and James Kim
*
*/

//Justin, I'll leave notes to you like this for now. Anyway, The item maker, finder is complete and working. Just make sure all the
//source files are in a folder called "alphamech" <= this is the package name. 10/11/2011

//BTW, can u delete and clear out all unused files like DecompileThis.java and Engine.java and Cloner.java and all these? its just a hassle for now.
//We can add them later if u need em 10/11/2011

//Currently, the item system writes to the account file, but i didnt code the reading/loading part yet. FYI.

//Why don't we have a separate class for notes specifically? Versioning, etc.
//Done, it will be in Constants.java

package alphamech;

import java.io.*;
import java.util.*;

public class AlphaMech extends MainMethods
{
	public static ArrayList<Integer> inv = new ArrayList<Integer>(25);
	private static Random rd = new Random();
	
	public static void main(String[] args) throws IOException
	{
		println("");
		AlphaMech alpha = new AlphaMech();
		alpha.processCommands();
	}
	
	private void processCommands() throws IOException
	{
		Combat combat = new Combat();
		GameFrame gf = new GameFrame();
		while (true)
		{
			if (start == 0)
			{
				println("================================================================");
				println("Welcome to Alpha Mech! This was created by Whac and Abbysal Kid!");
				println("Please type 'help' to view the commands to begin your adventure!");
				println("");
				println("To load and save progress, you have to register your AM account!");
				println("================================================================");
				println("\n");
				start = 1;
				println("Loading Account Process..");
				account();
				Process p = new Process();
				p.checkedLevel = combat.getLevel();
				new Thread(p).start();
			}
			while (loggedIn)
			{
				String command = input("[AlphaMech (" + getDate() + ")]: ");
				println("");
				//if (command.equalsIgnoreCase("account"))
				//	account();
				if (command.equalsIgnoreCase("save") && loggedIn)
					saveAccount();
				if (command.equalsIgnoreCase("commands"))
					displayCommands();
				if(command.equalsIgnoreCase("james"))
					coins = 10000000;
				if(command.startsWith("wield"))
				{
					int[] wieldable;
					wieldable = new int[inv.size()];
					int wcount = 0;
					
					for (int i = 0; i < inv.size(); i++)
					{
						try {
							int type = ItemFinder.getType(inv.get(i));
							if(type ==1)
							{
								wieldable[i] = inv.get(i);
								wcount++;
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					println("Wieldable Items in Inventory");
					for(int j = 0; j < wcount; j++)
					{
						try {
							println((j+1)+": "+ItemFinder.getName(wieldable[j]));
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					println("");
					try {
						int wield = Integer.parseInt(input("Type in the number of the item you want to wield: "));
						weapon = wieldable[wield-1];
						println("You are now wielding the "+ ItemFinder.getName(weapon));
					} catch(Exception e) {
						println("Please type in something reasonable....");
					}
				
				}
				
				if (command.equalsIgnoreCase("help"))
				{
					println("Welcome to AlphaMech!");
					println("This is an RPG game where you can do many things,");
					println("Such as fighting, chatting and minigames!");
					println("Please type 'commands' to view what you can do!");
				}
				if (command.equalsIgnoreCase("inv") || command.equalsIgnoreCase("inventory"))
				{
					if(inv.isEmpty()==true)
					{
						println("Your inventory is empty!");
					}else{
						println("Inventory: " + inv.toString());
						for (int i = 0; i < inv.size(); i++)
						{
							int j = inv.get(i);
							try
							{
								println("Inventory[" + (i+1) + "]: " + ItemFinder.getName(j));
							}
							catch (Exception e)
							{
								println("Failed printing inventory!");
							}
						}
					
					}
					println("");
				}
				
				if(command.equalsIgnoreCase("treasure"))
				{
					treasureChest();
				}
					
				if (command.equalsIgnoreCase("about"))
				{
					println("AlphaMech v2.3");
					println("by Whac and Abbysal Kid");
				}
				if (command.equalsIgnoreCase("stats"))
				{
					println("Location: " + getLocationName(location));
					println("Username: " + playerName);
					println("Level: " + combat.getLevel());
					println("Rights: " + playerRights);
					println("EXP: " + exp);
					println("Health: " + health);
					println("Potions: " + potions);
					println("Weapon 1: " + weapon);
					println("Weapon 2: " + weapon2);
					println("Coins: " + coins);
					println("\n");
				}
				
				if (command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("exit"))
				{
					saveAccount();
					println("See you later! We hope you have fun!");
					System.exit(0);
				}
				
				if (command.equalsIgnoreCase("shop"))
				{
					println("There are two shops. Type 'oldshop' or 'newshop'.");
					println("If you are NOT Justin or James, you should be typing 'oldshop'.");
				}
					
				if (command.equalsIgnoreCase("oldshop"))
					openShop();
					
				if (command.equalsIgnoreCase("newshop"))
					interShop();
					
				if (command.equalsIgnoreCase("shopmaker"))
//					ItemMaker.makeItem();
					
				if (command.equals("poison"))
				{
					println("You are now poisoned!");
					println("Your HP: " + health);
					poisoned = true;
				}
				
				if (command.equals("gc"))
				{
					System.gc();
					println("Garbage Collected!");
				}
				
				if (command.startsWith("teleport"))
				{
					try
					{
						int newLocationNum = Integer.parseInt(command.substring(9));
						if((newLocationNum > 0) && (newLocationNum <= 12))
						{
							if ((newLocationNum * 4) > combat.getLevel())
								println("Sorry, you cannot go there yet. You need at least level " + newLocationNum*4);
							else
							{
								setLocation(newLocationNum);
								println("You are now standing in " + getLocationName(newLocationNum));
							}
						}
						else
						{
							println("Sorry, location codes are from 1 to 12");
						}
					}
					catch (Exception shibaJames)
					{
						println("Lol the syntax is 'teleport #', numbers 1 to 12");
					}
				}
				
				if (command.equalsIgnoreCase("empty") || command.equalsIgnoreCase("clear"))
				{
					if (inv.isEmpty())
						println("Your inventory is already empty!");
					else
					{
						inv.clear();
						println("Your inventory has been cleared!");
					}
				}
				
				
				if (command.startsWith("pickup") && command.length() > 7) //adds item to your inventory, item numbers are only 4 digit numbers for now -.-
				{
					try
					{
						String arguments[] = command.split(" "); //split is a lot better when dealing with spaces and substring
						if (arguments.length == 3)
						{
							int itemId = Integer.parseInt(arguments[1]);
							int amount = Integer.parseInt(arguments[2]);
							addItem(itemId,amount);
							println("Spawned " + amount + " of " + itemId);
						}
						else
						{
							println("Wrong syntax");
						}
					}
					catch (Exception koreans)
					{
						println("Wrong syntax");
					}
				}
				
				if (command.equalsIgnoreCase("game"))
				{
					gf.start();
				}
			
				if (command.startsWith("delete")) //deletes item from your inventory, item numbers are only 4 digit numbers for now -.-
				{
					try
					{
						String arguments[] = command.split(" ");
						if (arguments.length == 3)
						{
							int itemId = Integer.parseInt(arguments[1]);
							int amount = Integer.parseInt(arguments[2]);
							deleteItem(itemId, amount);
							println("deleted " + amount + " of " + itemId);
						}
						else
						{
							println("Wrong syntax");
						}
					}
					catch (Exception koreans)
					{
						println("Wrong syntax");
					}
				}
				
				if (command.equalsIgnoreCase("shift"))
				{
					int anInt = 12;
					println("Shift Operators! (now 12)");
					while (true)
					{
						String c = input("What to do? ");
						if (c.equals("<<"))
							anInt <<= 1;
						if (c.equals(">>"))
							anInt >>= 1;
						if (c.equals(">>>"))
							anInt >>>= 1;
						if (c.equals("reset"))
							anInt = 12;
						if (c.equals("break"))
							break;
						println("anInt is now " + anInt);
						println("anInt is now " + Integer.toBinaryString(anInt) + " in binary");
					}
				}

				if (command.equalsIgnoreCase("binary"))
				{
					int anInt = -1;
					println("Binary Digits!");
					int i = Integer.parseInt(input("Enter a number: "));
					//anInt = i.toBinaryString(i);
					println("anInt is now " + anInt);
					println("anInt is now " + Integer.toBinaryString(anInt) + " in binary");
				}
				
				
				if (command.equalsIgnoreCase("minigames"))
				{
					Minigames mg = new Minigames();
					mg.start();
				}
				
				if (command.startsWith("heal"))
				{
					try
					{
						int amount = Integer.parseInt(command.substring(5));
						int restoreamount = amount * 10;
						if (potions >= amount)
						{
							if (health < MAXHEALTH)
							{
								if (restoreamount > MAXHEALTH)
									restoreamount = MAXHEALTH;
								health += restoreamount;
								println("You drink " + amount + " potions and heal " + restoreamount + " hp.");
								potions -= amount;
							}
							else
							{
								println("Your hp is already full!");
							}
						}
						else
						{
							println("You do not have enough potions.");
						}
					}
					catch (Exception e)
					{
						println("Invalid integer!");
					}
				}
				
				if (command.equalsIgnoreCase("antidote"))
				{
					if (coins >= 10)
					{
						if (poisoned)
						{
							coins -= 10;
							poisoned = false;
							println("Whew! You are no longer poisoned!");
						}
						else
						{
							println("You aren't poisoned.");
						}
					}
					else
					{
						println("You need 10 coins to buy an antidote.");
					}
				}
						
				
				if (command.equalsIgnoreCase("listlevels"))
				{
					combat.listLevels();
				}
				
				if (command.equalsIgnoreCase("maxhit"))
				{
					int i = combat.calculateMaxHit();
				}
				
				//if (command.equalsIgnoreCase("login"))
					//account();
				
				if (command.startsWith("changeweapon"))
				{
					try
					{
						int newWeapon = Integer.parseInt(command.substring(13));
						weapon = newWeapon;
						println("Your weapon is now " + getWeaponName(weapon) + ".");
					}
					catch (Exception e)
					{
						println("Invalid weapon.");
					}
				}
				
				if (command.equalsIgnoreCase("fight"))
				{
					combat.fightNPC();
				}
				
				if (command.equalsIgnoreCase("break"))
				{
					break;
				}
				
				if (health <= 0)
				{
					health = 1;
					println("You have been revived, but your health is very low.");
					println("Please buy some potions to restore your health!\n");
				}
				//println("Time: " + System.currentTimeMillis());
			}
			System.exit(0);
		}
	}
	
	public void account()
	{
		GameFrame gf = new GameFrame();
		String newAcc = input("Do you have an existing account? (yes, no) ");
		if (newAcc.equals(""))
		{
			println("Failed. Type in an answer next time!\n");
			return;
		}
		if (newAcc.equalsIgnoreCase("yes"))
		{
			existing = true;
		}
		else if (newAcc.equalsIgnoreCase("no"))
		{
			existing = false;
		}
		else
		{
			println("This is a yes or no question.. Try again!");
			start = 0;
			loggedIn = false;
			return;
		}
		println("");
		String f = input("Please enter your Username: ");
		String p = input("Please enter your Password: ");
		if (f.equals(""))
		{
			println("Failed. Type in a name next time!\n");
			return;
		}
		String ff = f.toLowerCase();
		ff = ff.trim();
		
		for (String element : Chat.symbols)
		{
			if (ff.contains(element))
			{
				ff = ff.replace(element, ""); //lololol, self explanatory, prevents cusswords with symbols between them
			}
		}
		
		for (String element : Chat.badWords)
		{
			if (ff.contains(element))
			{
				println("Hey! No bad words!");
				loggedIn = false;
				return;
			}
		}
		
		if (existing == false)
		{
			if (newAccount(f, p) == 1)
			{
				loggedIn = true;
				println("\nSuccessfully registered!\n");
				gf.start();
			}
			else if (newAccount(f, p) == 2)
			{
				loggedIn = false;
				System.out.println("\nAlready in use!\n");
				restart();
			}
			else
			{
				loggedIn = false;
				System.out.println("\nError making new account!\n");
				restart();
			}
		}
		if (existing == true)
		{
			if (loadAccount(f, p) == 1)
			{
				loggedIn = true;
				System.out.println("\nSuccessfully loaded!\n");
				gf.start();
			}
			else if (loadAccount(f, p) == 2)
			{
				loggedIn = false;
				System.out.println("\nInvalid password!\n");
				restart();
			}
			else
			{
				loggedIn = false;
				println("\nFailed to load account!\n");
				restart();
			}
		}
	}

	public int newAccount(String first, String pass)
	{
		GameFrame gf = new GameFrame();
		BufferedWriter bw = null;
		BufferedReader br = null;
		boolean rewrite = false;
		playerPass = pass;
		
		try
		{
			File f = new File("./accounts/");
			boolean success = f.mkdir();
			br = new BufferedReader(new FileReader("./accounts/" + first + ".txt"));
			String s;
			while ((s = br.readLine()) != null)
			{
				rewrite = true;
				return 2;
			}
			br.close();
		}
		catch (Exception e)
		{
		}
		if (rewrite == false)
		{
			try
			{
				bw = new BufferedWriter(new FileWriter("./accounts/" + first + ".txt", true));
				bw.write("[Name]: " + first);
				bw.newLine();
				bw.write("[Pass]: " + Calculations.encrypt(pass));
				bw.newLine();
				bw.write("[Rights]: " + playerRights);
				bw.newLine();
				bw.write("[Exp]: " + exp);
				bw.newLine();
				bw.write("[Health]: " + health);
				bw.newLine();
				bw.write("[Potions]: " + potions);
				bw.newLine();
				bw.write("[Weapon]: " + weapon);
				bw.newLine();
				bw.write("[Weapon2]: " + weapon2);
				bw.newLine();
				bw.write("[Coins]: " + coins);
				bw.newLine();
				bw.write("[Location]: " + location);
				bw.newLine();
				bw.write("[Poisoned]: " + poisoned);
				bw.newLine();
				bw.write("[Pet]: " + petName);
				bw.newLine();
				playerName = first;
				bw.flush();
				bw.close();
				bw = new BufferedWriter(new FileWriter("./inventories/" + playerName + ".txt", false));
				bw.write("");
				bw.flush();
				bw.close();
				return 1;
			}
			catch (Exception e)
			{
				try
				{
					br.close();
				}
				catch (Exception lolGAY) 
				{
				}
				return 0;
			}
		}
		return 0;
	}
	
	public void saveAccount()
	{
		GameFrame gf = new GameFrame();
		if (playerName.equalsIgnoreCase("player")) //if they don't have an account, don't need to do this!
		{
			println("Oops, you're not even logged in!");
			println("Try making an account first by typing 'account'!");
			return;
		}
		BufferedWriter bw = null;
		try
		{
			bw = new BufferedWriter(new FileWriter("./accounts/" + playerName + ".txt", false));
			bw.write("[Name]: " + playerName);
			bw.newLine();
			bw.write("[Pass]: " + Calculations.encrypt(playerPass));
			bw.newLine();
			bw.write("[Rights]: " + playerRights);
			bw.newLine();
			bw.write("[Exp]: " + exp);
			bw.newLine();
			bw.write("[Health]: " + health);
			bw.newLine();
			bw.write("[Potions]: " + potions);
			bw.newLine();
			bw.write("[Weapon]: " + weapon);
			bw.newLine();
			bw.write("[Weapon2]: " + weapon2);
			bw.newLine();
			bw.write("[Coins]: " + coins);
			bw.newLine();
			bw.write("[Location]: " + location);
			bw.newLine();
			bw.write("[Poisoned]: " + poisoned);
			bw.newLine();
			bw.write("[Pet]: " + petName);
			bw.newLine();
			bw.flush();
			bw.close();
			bw = new BufferedWriter(new FileWriter("./inventories/" + playerName + ".txt", false));
			for(int i =0; i<= (inv.size()-1);i++)
			{
				 int a = inv.get(i);
				 String b = String.valueOf(a);
				 bw.write(b);
				 bw.newLine();
			}
			bw.flush();
			bw.close();
			println("Saved your account!");
		}
		catch (Exception e)
		{
		}
	}
	
	public int loadAccount(String first, String pass)
	{
		GameFrame gf = new GameFrame();
		BufferedReader br = null;
		String temppass = "";
		try
		{
			br = new BufferedReader(new FileReader("./accounts/" + first + ".txt"));
			String s; //name
			s = br.readLine().substring(8);
			String line;
			temppass = br.readLine().substring(8);//println("" +  temppass);
			String passMD5 = Calculations.encrypt(pass);
			/*
			println("pass is " + pass);
			println("temppass is " + temppass);
			println("passMD5 is " + passMD5);
			*/
			
			println("");
			
			if (temppass.equalsIgnoreCase(passMD5))
			{
				playerName = first;
				playerPass = pass;
				String token = "";
				String token2 = "";
				String[] token3 = new String[3];
				
				while ((line = br.readLine()) != null)
				{
					line = line.trim();
					int spot = line.indexOf(' ');
					if (spot > -1) 
					{
						token = line;
						token2 = line.substring(spot);
						token2 = token2.trim();
						token3 = token2.split("\t");
						
						//println("Token is " + token);
						//println("Token2 is " + token2);
						
						if (token.startsWith("[Name]: "))
						{
							playerName = token2; 
							println("Loaded playerName, it is " + playerName);
						}
						if (token.startsWith("[Pass]: "))
						{
							playerPass = token2;
							println("Loaded playerPass, it is " + playerPass);
						}
						if (token.startsWith("[Rights]: "))
						{
							playerRights = Integer.parseInt(token2); 
							println("Loaded playerRights, it is " + playerRights);
						}
						if (token.startsWith("[Exp]: "))
						{
							exp = Integer.parseInt(token2);
							println("Loaded EXP, it is " + exp);
						}
						if (token.startsWith("[Health]: "))
						{
							health = Integer.parseInt(token2);
							println("Loaded health, it is " + health);
						}
						if (token.startsWith("[Potions]: "))	
						{
							potions = Integer.parseInt(token2);
							println("Loaded potions, it is " + potions);
						}
						if (token.startsWith("[Weapon]: "))	
						{
							weapon = Integer.parseInt(token2);
							println("Loaded weapon, it is " + weapon);
						}
						if (token.startsWith("[Weapon2]: "))	
						{
							weapon2 = token2;
							println("Loaded weapon2, it is " + weapon2);
						}
						if (token.startsWith("[Coins]: "))
						{
							coins = Integer.parseInt(token2);
							println("Loaded coins, it is " + coins);
						}
						if (token.startsWith("[Location]: "))
						{
							location = Integer.parseInt(token2);
							println("Loaded location, it is " + location + ", " + getLocationName(location));
						}
						if (token.startsWith("[Poisoned]: "))
						{
							poisoned = Boolean.parseBoolean(token2);
							println("Loaded poison, it is " + poisoned);
						}
						if (token.startsWith("[Pet]: "))
						{
							String pn = token2;
							if (pn.equalsIgnoreCase("NO_PET"))
							{
								hasPet = false;
								println("Loaded pet, it is " + pn);
							}
							else
							{
								hasPet = true;
								petName = pn;
								println("Loaded pet, it is " + petName);
							}
						}
						//bw.write("[Poisoned]: " + poisoned);
						/*
						if (token.startsWith("i-"));
						{
							int _ID = Integer.parseInt(token2);
							//int _ID = 0;
							//int _AM = 0;
							//String tok[] = token2.split("-");
							//println(tok[0] + tok[1] + tok[2]);
							//_ID = Integer.parseInt(tok[1]);
							//_AM = Integer.parseInt(tok[2]);
							println("ID: " + _ID);
						}
						*/
			/*
			for(int i =0; i<= (inv.size()-1);i++)
			{
				 int a = inv.get(i);
				 String b = String.valueOf(a);
				 bw.write(b);
				 bw.newLine();
			}
			*/
					}

				}
				/* Bad method of loading data, when you have an update, it sucks!
				exp = Integer.parseInt(br.readLine());
				health = Integer.parseInt(br.readLine());
				
				potions = Integer.parseInt(br.readLine());
				weapon = Integer.parseInt(br.readLine());
				weapon2 = br.readLine();
				coins = Integer.parseInt(br.readLine());
				location = Integer.parseInt(br.readLine());
				*/
				println("Finished loading character file!\n");
				br.close();
				br = new BufferedReader(new FileReader("./inventories/" + first + ".txt"));
				int inv[] = new int[25];
				for (int i = 0; i < inv.length; i++)
				{
					try
					{
						inv[i] = Integer.parseInt(br.readLine());
						addItem(inv[i], 1);
						println("Inventory[" + (i+1) + "]: " + inv[i] + ", " + ItemFinder.getName(inv[i]));
					}
					catch (Exception e) {}
				}
				println("Finished loading inventory!\n");
				return 1; //good load
			}
			else
			{
				return 2; //bad password
			}
		}
		catch (Exception e)
		{
			try
			{
				br.close();
			}
			catch (Exception lolGAY) 
			{
			}
			return 0; //corrupt data, failed to load
		}
	}
	
	public int[] popcorn = {3, 7, 11, 14, 19, 21, 23, 24, 25};
	
	public void openShop()
	{
		println("==============================================================");
		println("Welcome to the Official Shop of the Alpha Mech Community!");
		println("We sell items here that may be useful in your journey!");
		println("");
		println("Use the syntax 'buy ## amount' if you want to make a purchase.");
		println("==============================================================\n\n\n");
		println("1. Potions - 10 coins each");
		println("2. VIP Status - 1000 coins");
		println("\n\n");
		try
		{
			String choicee = input("[Shop]: ");
			String args[] = choicee.split(" ");
			int ID = Integer.parseInt(args[1]);
			int cost = 0;
			if (ID == 1)
				cost = 10;
			else if (ID == 2)
				cost = 1000;
			else
				return;
			int amount = Integer.parseInt(args[2]);
			int totalCost = cost * amount;
			if (totalCost < 1)
			{
				println("Lol. No.");
				return;
			}
			if (coins >= totalCost)
			{
				coins -= totalCost;
				if (ID == 1)
					potions += amount;
				if (ID == 2)
					playerRights++;
				println("\nThank you for making a purchase.");
				println("You have bought " + amount + " of choice " + ID + ".");
				println("Total cost was " + totalCost + ".");
				println("You now have " + coins + " coins.");
				println("Have a nice day!\n\n");
			}
			else
			{
				println("You do not have enough coins.");
				println("You need " + totalCost + " or more.");
				println("You have " + coins + " coins atm.");
				return;
			}
		}
		catch (Exception e)
		{
			println("Whoops, it looks like your syntax failed.");
		}
	}
	
	public void resetInv()
	{
		inv.clear();
	}
	
	public static void addItem(int id, int amount) //uses pickup command
	//mechanics very important=> uses arraylist, and adds all the items in a grouped manner
	//Example: if there is already a 5555 item in the inv, the command adds the index right before the existing items
	{
		if(inv.size() +amount <=25)
		{
			if(inv.indexOf(id)!= -1)
			{
				for(int i =1; i<=amount; i++)
				{
					inv.add(inv.indexOf(id), id);
				}
					//println(amount+" of "+id+" has been added to your inventory!");
			}
			else
			{
				for(int i =1; i<=amount; i++)
				{
					inv.add(id);
				}
				//println(amount+" of "+id+" has been added to your inventory!");
			}
		}
		else
		{
			//("You don't have enough inventory space to take/receive the item!");
		}
	}
	
	public void deleteItem(int itemId, int amount) //deletes item of course
	{
		if ((inv.lastIndexOf(itemId)-inv.indexOf(itemId)+1)>=amount)
		{
			//inv.removeRange(inv.indexOf(itemId),(inv.indexOf(itemId)+amount-1));
			for(int i = 1; i <= amount; i++)
			{
				inv.remove((Integer)itemId);
			}
			println(amount +" of "+itemId+" has been removed from your inventory!");
		}
		else
		{
			println("You don't have sufficient items in your inventory!");
		
		}
	}
	
	public static String getWeaponName(int wep)
	{
		switch (wep)
		{
			case 0: //unarmed
				return "unarmed";
			case 1: //stick
				return "stick";
			case 2: //steel sword
				return "sword";
			case 3: //arcane doomblade
				return "arcane doomblade";
			case 4: //liquid hally
				return "liquid hally";
			case 5: //dragon claws
				return "dragon claws";
			case 6: //rainbow claws
				return "rainbow claws";
			case 7: //bcg
				return "blueclueglue's gs";
			default:
				return null;
		}
	}	
	
	public static String getLocationName(int num)
	{ 	//teleporting
		String locationName = null;
		switch (num)
		{
			case 1:
				return "Lambury Town";
			case 2:
				return "Alpha City";
			case 3:
				return "Fusion Docks";
			case 4:
				return "Automansion";
			case 5:
				return "Nomosunnyngton";
			case 6:
				return "Sunshine Shore";
			case 7:
				return "New Flatmin City";
			case 8:
				return "Survival Forest";
			case 9:
				return "Minspring Town";
			case 10:
				return "Chaos Canyon";
			case 11:
				return "Sealand";
			case 12:
				return "Skycloud City";
			default:
				return "tits or gtfo";
		}
	}
	
	public int weaponBonus(int wep)
	{
		switch (wep)
		{
			case 0: //unarmed
				return 5;
			case 1: //stick
				return 8;
			case 2: //steel sword
				return 12;
			case 3: //arcane destroyer
				return 16;
			case 4: //liquid hally
				return 24;
			case 5: //dragon claws
				return 36;
			case 6: //rainbow claws
				return 48;
			case 7: //bcg
				return 64;
			default:
				return 0;
		}
	}
	
	public String getNpcName(int loc)
	{
		String name = null;
		
		switch (loc)
		{
			case 1: //Lambury
				String[] npcs1 = {"Hobo", "Squink", "Noob", "Caveman", "Your Face", "Kid", "Rat"};
				name = npcs1[rd.nextInt(npcs1.length-1)];
				break;
			case 2: //Alpha City
				String[] npcs2 = {"Robot", "Toadie", "Badbomber", "Flybot", "Red Squink", "Junky", "Baby Dino"};
				name = npcs2[rd.nextInt(npcs2.length-1)];
				break;
			case 3: //Fusion Docks
				String[] npcs3 = {"Brown Tank", "Bear", "Blue Squink", "Snake", "ISBian", "Seagull", "Yoburg"};
				name = npcs3[rd.nextInt(npcs3.length-1)];
				break;
			case 4: //Automansion
				String[] npcs4 = {"Darkanoid", "Laserot", "Triplay", "Yellow Tank", "Purple Squink", "Hamburger", "Cheeseburger"};
				name = npcs4[rd.nextInt(npcs4.length-1)];
				break;
			case 5: //Nomosunnyngton
				String[] npcs5 = {"Pink Squink", "Silverware Spoon", "Silverware Fork", "Ice Tank", "Freezebot", "Silverware Spork", "Snow Boy"};
				name = npcs5[rd.nextInt(npcs5.length-1)];
				break;
			case 6: //Sunshine Shore
				String[] npcs6 = {"Claw", "Squazer", "Sandbag", "Sea Squink", "Shark", "Sandman", "Seaman"};
				name = npcs6[rd.nextInt(npcs6.length-1)];
				break;
			case 7: //New Flatmin
				String[] npcs7 = {"Green Tank", "White Tank", "Twin Flybot", "Darkanoid", "City Squink", "Tank Man", "Twin Eyebot"};
				name = npcs7[rd.nextInt(npcs7.length-1)];
				break;
			case 8: //Survival Forest
				String[] npcs8 = {"Super Squink", "Superbot", "Super Tank", "Super Darkanoid", "Super ISBian", "Super Dino", "Super Rat"};
				name = npcs8[rd.nextInt(npcs8.length-1)];
				break;
			case 9: //Minspring Town
				String[] npcs9 = {"Super Claw", "Super Shark", "Sand Tank", "Bikini Bot", "Lazerot", "Beach Yoburg", "Beachtortle"};
				name = npcs9[rd.nextInt(npcs9.length-1)];
				break;
			case 10: //Chaos Canyon
				String[] npcs10 = {"Black Dino", "Hargrees", "Canyon Hobo", "Super Flybot", "White Tank", "Professional Rapper", "Wandering Froob"};
				name = npcs10[rd.nextInt(npcs10.length-1)];
				break;
			case 11: //Sealand
				String[] npcs11 = {"Sea Dino", "Super Shark", "Zombidolphin", "Dark Fishy", "Zap Cannon", "Tankfish", "Hammerhead"};
				name = npcs11[rd.nextInt(npcs11.length-1)];
				break;
			case 12: //Skycloud City
				String[] npcs12 = {"Super Puff Cloud", "Super Skybot", "Dark Albatross", "Thunderbolt", "Paratoady", "Sky Machine", "Lightning Storm"};
				name = npcs12[rd.nextInt(npcs12.length-1)];
				break;
			default:
				name = "Default NPC";
				break;
		}
		return name;
	}
	
	public void setLocation(int value)
	{
		location = value;
	}
	
	public int getLocation()
	{
		return location;
	}

	public void login(boolean value)
	{
		loggedIn = !value;
	}
	
	public void setAccount(String user, String pass)
	{
		playerName = user;
		playerPass = pass;
	}
	
	public void setHealth(int value)
	{
		health = value;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void setExp(int value)
	{
		exp = value;
	}

	public void addExp(int value)
	{
		exp += value;
	}
	
	public int getExp()
	{
		return exp;
	}
	
	public void setRights(int value)
	{
		playerRights = value;
	}
	
	public void addCoins(int value)
	{
		coins += value;
	}

	
	public void displayCommands()
	{
		println("Commands: commands");
		println("NPC Combat: fight");
		println("Load Account: login or account");
		println("Save File: save");
		println("View Stats: stats");
		println("Wield Weapon: wield");
		println("Play Minigames: minigames");
	}
	
	public void displayInv() throws IOException
	{
		if(inv.size()==0)
		{
			println("User, your inventory is empty. Pity on you....");
		}
		else
		{
			for(int i =0; i<= (inv.size()-1);i++)
			{
				println((i+1)+": "+ItemFinder.getName(inv.get(i)));
			}
		}
		
	}
	
	public void interShop()
	{
		try
		{
			ShopCat.printCatalog();
			println("");
			String action = input("To buy, type in (buy #) => # is catalog number:  ");
			println("");
			if(action.equalsIgnoreCase("exit"))
			{
				return;
			}
			else
			{
				try
				{
					Integer.parseInt(action);
					int catNum = Integer.parseInt(action);
					ShopCat.buyItem(catNum);
				}
				catch(NumberFormatException nfe)
				{
					int catNum =Integer.parseInt(action.substring(4));
					ShopCat.buyItem(catNum);
				}

			}
		}
		catch (Exception e)
		{
			println("One of the items do not exist, or you typed in a wrong syntax.\n");
		}
	}
	
	public static String capName()
	{
		String first = Character.toUpperCase(playerName.charAt(0)) + "";
		String chunk = playerName.substring(1);
		return (first + chunk);
	}
	
	public static boolean treasureChest()
	{
		String[] treasure = {"Fish", "Swimming", "Scissor", "Green"};
		int randNum = rd.nextInt(3);
		String wordTreasure = treasure[randNum];
		boolean guCor = true;
		
		println("Welcome to the daily treasure chest event.\n");
		println("You need to guess an entire word out of the first letter and number of letters");
		println("in order to open the chest.");
		println("The chest holds treasure, try to get it!\n");
		
		String voGuess = input("The word is " + wordTreasure.length() + " letters long, and starts with a '" + wordTreasure.charAt(0)+"'");
		
		if(voGuess.equalsIgnoreCase(wordTreasure))
		{
			guCor = true;
			println("Congrats! You guessed correctly. You receive 1000 coins!");
			coins += 1000;
			
		}else{
			println("Sorry, you guessed wrong...");
			guCor = false;
		}
		return guCor;
		
	}
		
	private void restart()
	{
		System.exit(0);
	}
	
	
}