/**
* Combat.java
* Handles combat and fighting, contains all combat related methods.
*
* by Justin Zeng and James Kim
*
*/

package alphamech;

import java.io.IOException;

public class Combat extends AlphaMech
{
	public int getLevel()
	{
		//int orig = (int) Math.sqrt(exp);
		//int lv = (int) (orig / 5) + (int) (60 / Math.pow(2, orig));
		//return (int) Math.sqrt(exp) - (int) (1/2 * Math.sqrt(exp));
		//return (int) level + (int) ((5*(Math.pow(level, 3)))/5);
		for (int i = 0; i < 219; i++)
		{
			int requirement = getXPByLevel(i);
			if (exp < requirement)
			{
				return i;
			}
		}
		return -231;
	}
	
	private static String enemyName = "null";
	private static int enemyLevel = -1;
	private static int enemyHP = -1;
	private static int enemyAttack = -1;
	private static int xpGranted = -1;
	private static int enemyReward = -1;
	private static boolean poisonous = false;
	
	private static String enemyPetName = "null";
	
	
	private void generateEnemy()
	{
		int levelofnpc = 0;
		if (getLevel() > 200)
			levelofnpc = 214;
		else if (getLevel() > 180)
			levelofnpc = 192;
		else if (getLevel() > 160)
			levelofnpc = 168;
		else if (getLevel() > 140)
			levelofnpc = 138;
		else if (getLevel() > 120)
			levelofnpc = 126;
		else if (getLevel() > 100)
			levelofnpc = 102;
		else if (getLevel() > 80)
			levelofnpc = 87;
		else if (getLevel() > 60)
			levelofnpc = 62;
		else if (getLevel() > 40)
			levelofnpc = 45;
		else if (getLevel() > 20)
			levelofnpc = 24;
		else
			levelofnpc = 7;
		levelofnpc += ((location + random(5)) * 2);
		
		String name = getNpcName(location);
		
		int npchealth = npcHealth(levelofnpc);

		int xp = npchealth/4;
		if (exp < 900)
			xp = npchealth * 2;
		else
			xp = npchealth * 20;
		int atk = calculateNPCMaxHit(levelofnpc);
		int reward = random(npchealth * 9);
		
		enemyName = name;
		enemyLevel = levelofnpc;
		enemyHP = npcHealth(levelofnpc);
		enemyAttack = 1;
		xpGranted = xp;
		enemyReward = reward;
	}
	
	private boolean pet = false;
	
	private boolean generateEnemyPet()
	{
		int i = random(3);
		if (i == 1)
		{
			String name = getNpcName(location);
			xpGranted = xpGranted + (1/4 * xpGranted);
			enemyReward = enemyReward + (1/4 * enemyReward);
			enemyPetName = name;
			pet = true;
			return true;
		}
		else
		{
			pet = false;
			return false;
		}
	}
	
	public void fightNPC() throws IOException
	{
		generateEnemy();
		int psn = random(9);
		if (psn == 4)
			poisonous = true;
		boolean npcIsAlive = true;
		boolean playerIsAlive = true;
		//int lv = enemyLevel;
		//println("Lv is " + lv);
		if (DEBUG)
		{
			System.out.println("Enemy Generated!");
			System.out.println("Name: " + enemyName);
			System.out.println("Level: " + enemyLevel);
			System.out.println("Health: " + enemyHP);
			System.out.println("Attack: " + enemyAttack);
			System.out.println("Earned XP: " + xpGranted);
			System.out.println("Reward: " + enemyReward);
		}
		
		println("\nOh no! It's a level " + enemyLevel + " " + enemyName + "!");
		if (generateEnemyPet())
		{
			println("Uh oh! The " + enemyName + " is accompanied by a " + enemyPetName + "!");
		}
		if (poisonous)
			println("Warning! The enemies are poisonous!");
		
		while (npcIsAlive && playerIsAlive)
		{
			println("What would you like to do?");
			String action = input("Options: (heal, fight, escape) ");
			println("");
			
			if (action.startsWith("heal"))
			{
				try
				{
					int amount = Integer.parseInt(action.substring(5));
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
			
			if (action.equalsIgnoreCase("fight"))
			{
				int w = random(6);
				String word = "";
				switch (w)
				{
					case 0:
						word = "Bam";
					case 1:
						word = "Smash";
					case 2:
						word = "Smoosh";
					case 3:
						word = "Slash";
					case 4:
						word = "Pow";
					case 5:
						word = "Kerplooey";
					case 6:
						word = "Slam";
				}
				int hit = calculateMaxHit();
				println(word + ", you attack the NPC!");
				if (hit > 0)
				{
					println("You hit a " + hit + " on the " + enemyName);
					enemyHP -= hit;
				}
				else
				{
					println("You missed!");
				}
				println("");
				if (hasPet)
				{
					w = random(6);
					word = "";
					switch (w)
					{
						case 0:
							word = "Bam";
						case 1:
							word = "Smash";
						case 2:
							word = "Smoosh";
						case 3:
							word = "Slash";
						case 4:
							word = "Pow";
						case 5:
							word = "Kerplooey";
						case 6:
							word = "Slam";
					}
					hit = (calculateMaxHit() / 4);
					println(word + ", your pet " + petName + " also attacks the NPC!");
					if (hit > 0)
					{
						println("Your pet " + petName + " hits a " + hit + " on the " + enemyName);
						enemyHP -= hit;
					}
					else
					{
						println("Your pet missed!");
					}
				}
				println("");
				println("The NPC now has " + enemyHP + "hp.\n");
			}
			
			if (action.equalsIgnoreCase("escape"))
			{
				int runAway = random(4);
				if (enemyHP < health)
					runAway++;
				if (enemyHP > health)
					runAway--;
				if (runAway > 3)
				{
					println("You successfully escape!\n");
					break;
				}
				else
				{
					println("You're too slow!\n");
				}
			}
			
			int npchit = calculateNPCMaxHit(enemyLevel);
			if (npchit > 0)
			{
				println("The " + enemyName + " hits a " + npchit + " on you.");
				health -= npchit;
				if (poisonous)
				{
					int psnLuck = random(9);
					if (psnLuck == 3)
					{
						poisoned = true;
						println("You are now badly poisoned.");
					}
				}
			}
			else
			{
				println("The " + enemyName + " missed!");
			}
			if (pet)
			{
				int npcPetHit = calculateNPCMaxHit(enemyLevel);
				npcPetHit /= 4;
				if (npchit > 0)
				{
					println("The pet " + enemyPetName + " hits a " + npcPetHit + " on you.");
					health -= npcPetHit;
				}
				else
				{
					println("The " + enemyPetName + " missed!");
				}
			}
			
			println("You now have " + health + " hp.");
			if (poisoned)
				println("You are poisoned! End the battle and type 'antidote'!");
			
			if (health < 1)
			{
				health = 0;
				playerIsAlive = false;
			}
			
			if (enemyHP < 1)
			{
				npcIsAlive = false;
			}
			println("");
		}
		if (npcIsAlive == false)
		{
			if (pet)
				println("Congrats! You have defeated the " + enemyName + " and the "  + enemyPetName + "!");
			else
				println("Congrats! You have defeated the " + enemyName + "!");
			exp += xpGranted;
			println("You gain " + xpGranted + " EXP. You now have " + exp + " EXP.");
			coins += enemyReward;
			if (pet)
				println("The enemies dropped " + enemyReward + " coins.\n\n");
			else
				println("The enemy dropped " + enemyReward + " coins.\n\n");
			if (pet)
			{
				int getPet = random(4);
				if (getPet == 1)
				{
					println("Oh my gosh! The " + enemyPetName + " wants to join your party!");
					String opt = input("Should you take him with you? (yes, no): ");
					opt = opt.toLowerCase();
					if (opt.startsWith("y"))
					{
						hasPet = true;
						petName = enemyPetName;
						println("Congrats! The " + petName + " now belongs to you!");
						println("\n");
					}
					else
					{
						println("Aww.. I think the " + enemyPetName + " is crying! :'[\n");
					}
				}
			}
		}
		if (playerIsAlive == false)
		{
			println("Oh dear, you died!");
			int takeout = 1/9 * exp;
			println("You lose " + takeout + " EXP.\n");
			exp -= takeout;
		}
	}
	
	
	public int getXPByLevel(int level)
	{
		//double exp = Math.pow(level, 4);
		//int i = (int) Math.round(exp / 77);
		//return (int) Math.floor(i);
		//return (int) Math.pow(level, 2);
		//return (int) getLevel() - (int) (1/2 * Math.sqrt(exp));
		return (int) level + (int) ((5*(Math.pow(level, 3)))/5);
	}
	
	public void listLevels()
	{
		for (int i = 0; i < 220; i++)
		{
			println("Level " + i + ": " + getXPByLevel(i));
		}
	}
	
	public int calculateMaxHit() throws IOException
	{
		int minLevel = getLevel()-2;
		if (minLevel < 1)
		minLevel = 1;
		int randGen = (minLevel) + (int) (Math.random() * (((getLevel()+3) - minLevel) + 1));
		double wepBon = Math.log(ItemFinder.getWbonus(weapon))/Math.log(10);
		int maxHit = (int)(wepBon * randGen);
		maxHit++;
		if (randGen % 7 == 0)
			return 0;
		else
			return maxHit;
	}
	
	private int calculateNPCMaxHit(int level)
	{
		int hit = level/2;
		int actualhit = random(hit);
		if (actualhit > -1)
			return actualhit;
		else
			return 0;
	}
	
	private int npcHealth(int level)
	{
		return (4 * level) + (2 *(random(getLevel()))); //+ level
	}

}