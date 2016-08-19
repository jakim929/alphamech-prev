/**
* Minigames.java
* Handling for the minigame process is done here.
*
* by Justin Zeng and James Kim
*
*/
package alphamech;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Minigames extends AlphaMech
{

	public void start()
	{
		println("=============================");
		println("Welcome to our minigame room!");
		println("We hope you have fun playing!");
		println("=============================");
		println("");
		int bet = 0;
		try
		{
			bet = Integer.parseInt(input("How many coins do you want to bet? "));
			if (coins < bet)
			{
				println("You don't have that many. You only have " + coins);
				return;
			}
			if (bet < 0)
			{
				println("Abusing glitches eh? -5 coins!");
				coins -= 5;
				return;
			}
		}
		catch (Exception e)
		{
			println("Type in a valid number next time!");
			return;
		}
		
		println("");
		println("1. Rock Paper Scissors (rps)");
		println("2. James Writer (jawriter)");
		println("3. Coordinate Game (coords)");
		println("4. Coin Toss (cointoss)");
		println("5. Guessing Game (guess)");
		println("6. Popcorn Machine (popcorn)");
		println("7. Music Man (musicman)");
		println("");
		
		String choice = input("Which minigame would you like to play?\nType the word in parenthesis to make your selection: ");
		println("\n\n");
		if (choice.equalsIgnoreCase("rps"))
		{
			//0 = rock, 1 = paper, 2 = scissors
			int plr = 0;
			int cpu = 0;
			String tmp = input("Rock Paper Scissors! (type rock, paper, or scissors) ");
			if (tmp.equalsIgnoreCase("rock"))
				plr = 0;
			else if (tmp.equalsIgnoreCase("paper"))
				plr = 1;
			else if (tmp.equalsIgnoreCase("scissors"))
				plr = 2;
			else
			{
				println("Invalid.");
				return;
			}
			cpu = random(2);
			String plrS = "";
			String cpuS = "";
			switch (plr)
			{
				case 0:
					plrS = "rock";
					break;
				case 1:
					plrS = "paper";
					break;
				case 2:
					plrS = "scissors";
			}
			switch (cpu)
			{
				case 0:
					cpuS = "rock";
					break;
				case 1:
					cpuS = "paper";
					break;
				case 2:
					cpuS = "scissors";
			}
			if (plr == cpu)
				println("Aww, the CPU also played " + cpuS + ". You tie.");
			if ((plr == 0 && cpu == 2) || (plr == 1 && cpu == 0) || (plr == 2 && cpu == 1))
			{
				println("The CPU played " + cpuS + ". You win!");
				coins += bet;
				println("You now have " + coins + " coins.");
			}
			if ((plr == 2 && cpu == 0) || (plr == 0 && cpu == 1) || (plr == 1 && cpu == 2))
			{
				println("The CPU played " + cpuS + ". You lose!");	
				coins -= bet;
				println("You now have " + coins + " coins.");
			}
		}
		if (choice.equalsIgnoreCase("jawriter"))
		{
			println("Welcome to jaWriter!");
			String filename = input("What is the name of the file you want to write to? ");
			int times = inputInt("How many lines do you want to write into " + filename + ".txt? ");
			int fail = 0;
			
			for (int counter = 0; counter < times; counter++)
			{
				String text = input("Write: ");
				BufferedWriter bw = null; //makes a new bufferedwriter called br
				try
				{
					bw = new BufferedWriter(new FileWriter(filename + ".txt", true)); //the file used the filwriter class and opens a file,
					bw.write(text);													  //the true part is "add on", false means overwrite file (wipe it)
					bw.newLine(); //write is write a bunch of text, self explanatory, new line makes a new line, duh
					bw.flush(); //to close out
				}
				catch (Exception e)
				{
					println("Error writing to " + filename + ".txt!");
					fail = 1;
				}
			}
			String success = "";
			switch(fail)
			{
				case 0:
					success = "(success!)";
					break;
				case 1:
					success = "(failed!)";
					break;
				default:
					break;
			}
			println("Finished! " + success);
		}
		if (choice.equalsIgnoreCase("coords")) 
		{
			int x, y, enemyX, enemyY, distanceX, distanceY, directionX, directionY;
			double distance;
			String directionXX = null;
			String directionYY = null;
			String coords = input("Enter your ship's coordinates (x, y): ");
			try
			{
				String[] COORDS = coords.split(", ");
				x = Integer.parseInt(COORDS[0]);
				y = Integer.parseInt(COORDS[1]);
				println("Your ship's coordinates are at (" + x + ", " + y + ") c:\n");
				
				enemyX = random(50);
				enemyX -= random(50);
				enemyY = random(50);
				enemyY -= random(50);
				println("Oh noes!\nThe enemy's coordinates are at (" + enemyX + ", " + enemyY + ")\nOMG what do we do??? :O\n");
				
				distanceX = Math.abs(x - enemyX);
				distanceY = Math.abs(y - enemyY);
				double totalDistance = Math.pow(distanceX, 2) + Math.pow(distanceY, 2);
				distance = Math.sqrt(totalDistance);
				double niceLookingDistance = roundDouble(distance, 2);
				//println("Distance X is " + distanceX + "\nDistance Y is " + distanceY);
				println("Captain, the distance between you and the enemy's ship is " + niceLookingDistance);
				while (x != enemyX && y != enemyY)
				{
					directionX = Integer.parseInt(input("How many X coordinate(s) would you like to travel? "));
					directionY = Integer.parseInt(input("How many Y coordinate(s) would you like to travel? "));
					if (directionX > 0)
						directionXX = "east";
					if (directionX < 0)
						directionXX = "west";
					if (directionX == 0)
						directionXX = "nowhere";
					if (directionY > 0)
						directionYY = "north";
					if (directionY < 0)
						directionYY = "south";
					if (directionY == 0)
						directionYY = "nowhere";
					if (directionX < 11 && directionY < 11 && directionX > -11 && directionY > -11)
					{
						println("OK that's cool. We're moving " + directionX + " coord(s) " + directionXX + " and " + directionY + " coord(s) " + directionYY);
						x += directionX;
						y += directionY;
						int eX = random(3);
						int eY = random(3);
						eX -= random(3);
						eY -= random(3);
						enemyX += eX;
						enemyY += eY;
						distanceX = Math.abs(x - enemyX);
						distanceY = Math.abs(y - enemyY);
						totalDistance = Math.pow(distanceX, 2) + Math.pow(distanceY, 2);
						distance = Math.sqrt(totalDistance);
						niceLookingDistance = roundDouble(distance, 2);
						println("Your ship's coordinates are at (" + x + ", " + y + ")\n");
						println("Uh oh. The enemy has also moved! The enemy is now at (" + enemyX + ", " + enemyY + ")");
						println("The distance between you and the enemy is " + niceLookingDistance + "\n\n");
					}
					else
					{
						println("User your ship isn't THAT great you can only ride 10 squares at a time..\n");
					}
				}
				sleep(1000);
				println("\nGood job you're now on top of the enemy's ship\nBut oh NO! It's attacking you!");
				int hit = random(5);
				while (hit != 0)
				{
					println("\nYou faild to bang and sink the ship\nTry again!");
					hit = random(5);
					sleep(1000);
				}
				sleep(1000);
				println("\nOh yes, the ship is dead now!\nYou did a gr8 job captain! :D\n");
				coins += 20;
				println("You gain 20 coins.");
				println("You now have " + coins + " coins.");
			} 
			catch (Exception e)
			{
				println("Sir, your syntax faild! You lose.");
			}
		}

		if (choice.equalsIgnoreCase("cointoss"))
		{
			int flips = inputInt("How many coins do you want to flip? ");
			int flipped = 0;
			int headtotal = 0;
			int tailtotal = 0;
			//int c = random(2);
			
			while (flips > flipped)
			{
				int c = random(1);
				
				if (c == 0)
				{
					println("Tails. " + c);
					saveLog("Tails. " + c);
					tailtotal++;
				}
				else
				{
					println("Heads. " + c);
					saveLog("Heads. " + c);
					headtotal++;
				}
				
				try
				{
					Thread.sleep(10);
				}
				catch (Exception e)
				{
					println("Error. ");
				}
				
				flipped++;
			}
			
			println("");
			println("Heads Total: " + headtotal);
			println("Tails Total: " + tailtotal);

			saveLog("Heads Total: " + headtotal);
			saveLog("Tails Total: " + tailtotal);
		}

		if (choice.equalsIgnoreCase("guess"))
		{
			long l = random(219);
			println("Welcome to the guessing game!");
			println("The range is from 0 to 219.");
			long guess = (long) inputInt("What's your guess? ");
			println("\n");
			long guesses = 0;
			while (guess != l)
			{
				println("Wrong, guess again!");
				guesses++;
				if (guess > l)
				{
					println("Your guess is greater than the number. \n");
				}
				else
				{
					println("Your guess is less than the number. \n");
				}
				guess = (long) inputInt("What's your guess? ");
			}
			guesses++;
			println("You guessed right! The number was " + l + "!");
			println("You took " + guesses + " guesses to get it right!");
			if (guesses > 20)
			{
				println("Better luck next time!");
				coins -= bet;
				println("You now have " + coins + " coins.");
			}
			else if (guesses < 4)
			{
				println("Bravo! You are a pure genius!");
				coins += (bet * 4);
				println("You get " + (bet*4) + " coins.");
				println("You now have " + coins + " coins.");
			}
			else if (guesses > 3 && guesses < 8)
			{
				println("Nicely done! You're a good guesser!");
				coins += (bet);
				println("You get " + (bet) + " coins.");
				println("You now have " + coins + " coins.");
			}
			else if (guesses > 7 && guesses < 12)
			{
				println("Fairly good job, I guess!");
				coins += (bet/3);
				println("You get " + (bet/3) + " coins.");
				println("You now have " + coins + " coins.");
			}
			else if (guesses > 13 && guesses < 21)
			{
				println("That was an alright job!");
				coins += (bet/8);
				println("You get " + (bet/8) + " coins.");
				println("You now have " + coins + " coins.");
			}
			println("");
		}
		
		if (choice.equalsIgnoreCase("musicman"))
		{
			String opt = input("Key in E or G? ");
			opt.toUpperCase();
			if (opt.equals("E"))
			{
				println("Solo is in E blues:\n\n");
				keyInE();
			}
			else if (opt.equals("G"))
			{
				println("Solo is in G! :D\n\n");
				keyInG();
			}
			else
			{
				println("Fail! Setting back to E");
				keyInE();
			}
			//E, G, G#,A, Bb, B, D, E, G, G#, A, B, D, E
			//16th, 8th, quarter
			
			for (int i = 0; i < 64; i++)
			{
				String text = "";
				text = text + getNote();
				int timee = getTime();
				switch (timee)
				{
					case 16:
						int rr = random(20);
						if (rr == 7)
							doATrill();
						if (rr == 8)
						{
							for (int nt = 0; nt < 3;  nt++)
							{
								print(text);
								sleep(1000);
							}
						}
						sleep(200);
						break;
					case 8:
						int rrrr = random(2);
						if (rrrr == 1)
							text = text + "^ ";
						text = text + " ";
						sleep(400);
						break;
					case 4:
						int rrr = random(7);
						if (rrr == 0)
							text = text + "~";
						if (rrr == 1)
							text = text + "/";
						text = text + "  ";
						sleep(800);
						break;
				}
				print(text);
			}
			sleep(1600);
			println("\n\nWow! Nice guitar solo! Now let's play it IRL! :D");
			coins += 10;
		}

		if (choice.equalsIgnoreCase("popcorn"))
		{
			String D34THKN1GHT = null;
			//int element = inputInt("Enter Popcorn: ");
			for (int element : popcorn)
			{
				int aRandom = random(50);
				aRandom += (60 - 1);
				println("Popcorn: " + popcorn + "] " + aRandom);
				sleep(250);
				switch (aRandom)
				{
					case 69:
						println("LOL Popcorn 69!");
						break;
					case 70:
						println("Null Popcorn 70!");
						break;
					case 76:
						println("Nice Popcorn 76!");
						break;
					case 77:
						println("Cool Popcorn 77!");
						break;
					case 84:
						println("Old Popcorn 84!");
						break;
					default:
						//println(D34THKN1GHT);
						break;
				}
				sleep(250);
			}
			println("Finished Popping! \n");
			for (int i = 0; i < 8; i++)
			{
				println("[] [] [] [] [] [] [] []\n");
			}
			println("\n\n\n");
			for (int i = 0; i < 45; i++)
			{
				String butter = "";
				String salt = "*";
				int r = random(4);
				if (r == 3)
					butter = "\n*!POP!*";
				int s = random(3);
				if (s == 1)
					salt = salt + "*";
				if (s == 2)
					salt = salt + "**";
				print(salt + " " + butter + "\n");
				sleep(100);
			}
			for (int i = 0; i < 45; i++)
			{
				String butter = "";
				for (int c = 0; c < 4; c++)
				{
					butter = "";
					if (c == 0)
						println("*");
					if (c == 1)
						println("**");
					if (c == 2)
						println("***");
					if (c == 3)
						println("**");
					int r = random(10);
					if (r == 3)
						butter = "\n*!POP!*";
					print(butter);
					sleep(100);
				}
			}
			sleep(1000);
			coins += 10;
			println("You now have " + coins + " coins.");
		}		
	}
	
	public void keyInE()
	{
		key = "E";
	}
	
	public void keyInG()
	{
		key = "G";
	}
	
	public String key = "E";
	
	public String getNote()
	{
		if (key.equals("E"))
		{
			int note = random(6);
			switch (note)
			{
				case 0:
					return "E";
				case 1:
					return "G";
				case 2:
					return "G#";
				case 3:
					return "A";
				case 4:
					return "Bb";
				case 5:
					return "B";
				case 6:
					return "D";
			}
		}
		if (key.equals("G"))
		{
			int note = random(10);
			switch (note)
			{
				case 0:
					return "G";
				case 1:
					return "A";
				case 2:
					return "Bb";
				case 3:
					return "B";
				case 4:
					return "C";
				case 5:
					return "C#";
				case 6:
					return "D";
				case 7:
					return "E";
				case 8:
					return "F";
				case 9:
					return "F#";
				case 10:
					return "G";
			}
		}
		return null;
	}
	
	public void doATrill()
	{
		String notes = getNote();
		String other = getNote();
		if (notes.equals(other))
			other = getNote();
		for (int ii = 0; ii < 4; ii++)
		{
			print(notes);
			print(other);
			sleep(100);
		}
	}
	
	public int getTime()
	{
		int time = random(2);
		switch (time)
		{
			case 0:
				return 16;
			case 1:
				return 8;
			case 2:
				return 8;
			case 3:
				return 4;
		}
		return -1;
	}
				
			
}