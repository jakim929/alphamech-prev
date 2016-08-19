/**
* Calculations.java

* Sandbox for learning, contains lots of snippets.
* This is currently in archive, please do not modify any code in this.
*
* by Justin Zeng and James Kim
*
*/
package alphamech;
import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.*;
import java.util.*;
import java.util.zip.*;
import javax.swing.JApplet;
import java.awt.Graphics;

//http://www.koonsolo.com/news/dewitters-gameloop/
//http://gamedev.moparscape.org/smf/index.php/topic,512597.0.html

public class Calculations extends MainMethods
{
	private static enum Type {Warrior, Ranger, Mage, Gunner};
	private static enum Color {Red, Orange, Yellow, Green, Blue, Purple, Pink};

	private static void main(String[] args)
	{
		try
		{
			if (args[0].equalsIgnoreCase("whacmode"))
			{
				whac = true;
			}
		}
		catch (Exception e)
		{
			
		}
		
		println("");
		Calculations calcs = new Calculations();
		//String title = "Calculations in Java";
		//setTitle(title);
		String command = input("Console: ");
		wc = command;

		
		if (command.equalsIgnoreCase("2.5"))
		{
			String name = input("Hello! What is your name? ");
			println("Nice to meet you, " + name + "! \n");
			int distance = inputInt("How far did you travel today? ");
			int cost = 0;
		
			if (distance < 100)
			{
				cost = 20 * distance;
				println("You have to pay $" + cost + ". \n");
			}
		
			else
			{
				cost = 25 * distance;
				println("You have to pay $" + cost + ". \n");
			}
		}
		
		if (command.equalsIgnoreCase("writecode"))
		{
			BufferedWriter bw = null;
			try
			{
				bw = new BufferedWriter(new FileWriter("Hybrid0819.java", true));
				bw.write("private class Hybrid0819 {");
				bw.newLine();
				int j;
				for (int i = 0; i < 1000; i++)
				{
					j = i * 2;
					bw.write("private int zachsavage" + i + " = " + j + ";");
					bw.newLine();
				}
				System.out.println("Finished!");
			}
			catch (Exception e)
			{
			}
				
		}
		
		if (command.equalsIgnoreCase("sava"))
		{
			for (Type aType : Type.values())
			{
				for (Color aColor : Color.values())
				{
					println("A " + aColor + " " + aType + " Frog.");
				}
			}
		}
		
		if (command.equalsIgnoreCase("exams"))
		{
			double finalgrade = inputDouble("What do you want your final grade to be? ");
			println("");
			double semestergrade = inputDouble("What is your semester average? ");
			println("");
			semestergrade = semestergrade * 0.8;
			double examgrade = finalgrade - semestergrade;
			examgrade = examgrade / 0.2;
			//println("You need an exam grade of " + examgrade + " to get a " + finalgrade + " as your final grade.");
			System.out.print("You need an exam grade of ");
			System.out.printf("%.2f", examgrade);
			System.out.print(" to get a ");
			System.out.printf("%.2f", finalgrade);
			System.out.println(" as your final grade.");
		}
		
		if (command.equalsIgnoreCase("dir"))
		{
			String sys = System.getProperty("user.dir");
			println("Home Directory: " + sys);
		}
		
		if (command.equalsIgnoreCase("dirtest"))
		{
			File f = new File("C:" + File.separator + "HelloJack" + File.separator + "noob.txt");
			BufferedWriter bw = null;
			try
			{
				bw = new BufferedWriter(new FileWriter(f, true));
				bw.write("Line 1");
				bw.newLine();
				bw.write("Line 2");
				bw.newLine();
				bw.write("Complete!");
			}
			catch (Exception e){}
		}
			
		
		if (command.equalsIgnoreCase("newfolder"))
		{
			String s = input("Please type the location of your new folder: ");
			File f = new File(s);
			if (f.mkdir())
				println("Success! Folder created at " + s);
			else
				println("Something Failed! Could not create folder!");
		}
		
		if (command.equalsIgnoreCase("rps"))
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
				println("The CPU played " + cpuS + ". You win!");
			if ((plr == 2 && cpu == 0) || (plr == 0 && cpu == 1) || (plr == 1 && cpu == 2))
				println("The CPU played " + cpuS + ". You lose!");	
		}
		
		if (command.equalsIgnoreCase("resethallies"))
		{
			BufferedReader br = null;
			BufferedWriter bw = null;
			try
			{
				br = new BufferedReader(new FileReader("./characters/gay.txt"));
				bw = new BufferedWriter(new FileWriter("./characters/gay.txt", true));
				String s;
				while ((s = br.readLine()) != null)
				{
					s.toLowerCase();
					if (s.contains("hello"))
					{
					}
				}
			}
			catch (Exception thisWasGay)
			{
			}
		}
						
		
		if (command.equalsIgnoreCase("load"))
		{ //http://www.mediafire.com/?6b8m90ofyc9mbce
			//account();
		}
		
		
		if (command.equals("[][]"))
		{
			int[][] multi = new int[2][2];
		}
				
		if (command.equalsIgnoreCase("jawriter"))
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
		
		if (command.equalsIgnoreCase("gzip"))
		{
			try
			{
				String file = input("File to GZIP? ");
				BufferedReader in = new BufferedReader(new FileReader(file));
				file.toLowerCase();
				if (file.contains("."))
				{
					int i = file.indexOf(".");
					String excess = file.substring(i);
					file = file.replaceAll(excess, "");
				}
				file = capitalize(file);
				BufferedOutputStream out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(file + ".gz")));
				println("Writing file " + file + ".gz...");
				int i;
				while ((i = in.read()) != -1)
					out.write(i);
				in.close();
				out.close();
				println("Reading file...");
				println("Nvm. Finished!");
			}
			catch (IOException ioe)
			{
				println("Failed!");
				ioe.printStackTrace();
			}
		}
		
		if (command.equalsIgnoreCase("pow"))
		{
			long firstnum = 0;
			long secondnum = 0;
			firstnum = inputInt("Input the first number. ");
			secondnum = inputInt("Input the second number. ");
			long result = (long) Math.pow(firstnum, secondnum);
			println("The first number to the power of the second number is " + result + ".");
		}
		
		if (command.equalsIgnoreCase("reverse"))
		{
			String string = input("String: ");
			string = reverse(string);
			println("Reversed: " + string);
		}
		
		if (command.equalsIgnoreCase("gpa"))
		{
			double gradeAmount = 0;
			double classNumber = 1;
			double grades = 0;
			double averageGrade = 0;
			double tempGrade = 0;
			double GPA = 0;
			
			gradeAmount = inputInt("How many classes do you take? ");
			double constClass = gradeAmount;
			println("");
    
			while (classNumber <= gradeAmount)
			{
				tempGrade = inputInt("What is your grade for class number " + classNumber + "? ");
				grades += tempGrade;
				classNumber += 1;
				println("");
			}

			averageGrade = grades/gradeAmount;
    
			println("Your Average Grade is: " + averageGrade + ". \n");
			GPA = averageGrade/24;
			println("Your GPA is: " + GPA + ". \n");
			
		}
		
		if (command.equalsIgnoreCase("coords")) 
		{
			int x, y, enemyX, enemyY, distanceX, distanceY, directionX, directionY;
			double distance;
			String directionXX = "hotgirls";
			String directionYY = "aresexy!";
			String coords = input("Enter your ship's coordinates (x, y): ");
			try
			{
				String[] COORDS = coords.split(", ");
				x = Integer.parseInt(COORDS[0]);
				y = Integer.parseInt(COORDS[1]);
				println("Your ship's coordinates are at (" + x + ", " + y + ") c:\n");
				
				enemyX = random(100);
				enemyX -= random(100);
				enemyY = random(100);
				enemyY -= random(100);
				
				/*
				String enemycoords = input("Enter your enemy's ship's coordinates (x, y): ");
				String[] enemyCOORDS = enemycoords.split(", ");
				enemyX = Integer.parseInt(enemyCOORDS[0]);
				enemyY = Integer.parseInt(enemyCOORDS[1]);
				*/
				println("Oh noes!\nThe enemy's coordinates are at (" + enemyX + ", " + enemyY + ")\nOMG what do we do??? :O\n");
				
				distanceX = Math.abs(x - enemyX);
				distanceY = Math.abs(y - enemyY);
				double distance2 = Math.pow(distanceX, 2) + Math.pow(distanceY, 2);
				distance = Math.sqrt(distance2);
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
						directionXX = "stationary";
					if (directionY > 0)
						directionYY = "north";
					if (directionY < 0)
						directionYY = "south";
					if (directionY == 0)
						directionYY = "stationary";
					if (directionX < 11 && directionY < 11 && directionX > -11 && directionY > -11)
					{
						println("OK that's cool. We are now going to move " + directionX + " coord(s) " + directionXX + " and " + directionY + " coord(s) " + directionYY);
						x += directionX;
						y += directionY;
						println("Your ship's coordinates are at (" + x + ", " + y + ") c:\n");
					}
					else
					{
						println("User your ship isn't that great you can only ride 10 squares at a time..\n");
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
			} 
			catch (Exception e)
			{
				println("Sir, your syntax faild! You lose.");
			}
		}
		
		if (command.equalsIgnoreCase("x10"))
		{
			for (long i = 1; i < Math.pow(2, (32 - 1)); i++)
			{
				long j = 10;
				
				while (i % j == 0)
				{
					println("" + i);
					j++;
				}
			}
		}
		
		if (command.equalsIgnoreCase("sleep"))
		{
			int sleeptime = inputInt("How long should I sleep? (seconds) ");
			sleeptime *= 1000;
			sleep(sleeptime);
			sleeptime /= 1000;
			println("Slept for " + sleeptime + " seconds.");
		}
		
		if ((command.equalsIgnoreCase("null")) || (command.equalsIgnoreCase("flood")) || (command.equalsIgnoreCase("crash")))
		{
			for (;;)
			{
				println("null");
				sleep(700);
			}
		}
		
		if (command.equalsIgnoreCase("settimer"))
		{
			int i = inputInt("What would you like the timer to be? ");
		}
			
		
		if ((command.equalsIgnoreCase("cointoss")) || command.equalsIgnoreCase("coinflip"))
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
		
		if (command.equalsIgnoreCase("javaio"))
		{
			String s = input("BufferedReader or BufferedWriter? (br, bw): ");
			println("");

			if (s.equals("br"))
			{
				BufferedReader br = null;
				try
				{
					br = new BufferedReader(new FileReader("read.txt"));
					String read;
					int counter = 0;
					while ((read = br.readLine()) != null)
					{
						counter++;
						if (counter > 9)
							println(counter + ": " + read);
						else
							println("0" + counter + ": " + read);
					}
				}
				catch (Exception e)
				{
					println("Error reading.");
				}
				finally
				{
					if (br != null)
					{
						try
						{
							br.close();
						}
						catch (Exception e)
						{
							println("Error closing.");
						}
					}
				}
			}
			
			if (s.equals("bw"))
			{
				String text = input("What would you like to write to the file? ");
				BufferedReader br = null;
				BufferedWriter bw = null;
				
				if (wipe == true)
				{
					try
					{
						br = new BufferedReader(new FileReader("write.txt"));
						bw = new BufferedWriter(new FileWriter("write.txt", true));		
						if (br != null)
						{
							bw.write("");
						}
						bw.close();
					}
					catch (Exception e)
					{
						println("Error wiping file!");
					}
				}
				try
				{
					br = new BufferedReader(new FileReader("write.txt"));
					bw = new BufferedWriter(new FileWriter("write.txt", true));		
					bw.write("" + text);
					bw.newLine();
					bw.flush();
					bw.close();
				}
				catch (Exception e)
				{
					println("Error writing to file!");
				}
				finally
				{
					if (bw != null)
					{
						try
						{
							bw.close();
						}
						catch (Exception e)
						{
							println("Error closing.");
						}
					}
				}
			}
		}
		
		if (command.startsWith("write"))
		{
			String str = command.substring(6);
			BufferedWriter bw = null;
			try
			{
				bw = new BufferedWriter(new FileWriter("write.txt", true));
				bw.write(str);
				bw.newLine();
				bw.flush();
				bw.close();
			}
			catch (Exception e)
			{
				println("Error writing!");
			}
		}
		
		if (command.equalsIgnoreCase("chat"))
		{
			yourName = input("Hi, what's your name? ");
			if (yourName.length() > 20)
			{
				println("WTF what kind of name is that..");
				return;
			}
			println("Nice to you meet you!\nOne second, loading up chatroom..");
			sleep(1000);
			Chat chat = new Chat();
			chat.main(null);
		}
		
		if (command.startsWith("wipefile"))
		{
			String d = command.substring(9);
			wipeFile(d);
		}
		
		if (command.equalsIgnoreCase("date"))
		{
			println(getDate());
		}
		
		if (command.equalsIgnoreCase("types"))
		{
			short aShort = Short.MAX_VALUE;
			int anInt = Integer.MAX_VALUE;
			long aLong = Long.MAX_VALUE;
			float aFloat = Float.MAX_VALUE;
			byte aByte = Byte.MAX_VALUE;
			char aChar = Character.MAX_VALUE;
			double aDouble = Double.MAX_VALUE;
			println("Short.MAX_VALUE = " + aShort);
			println("Integer.MAX_VALUE = " + anInt);
			println("Long.MAX_VALUE = " + aLong);
			println("Float.MAX_VALUE = " + aFloat);
			println("Byte.MAX_VALUE = " + aByte);
			println("Character.MAX_VALUE = " + aChar);
			println("Double.MAX_VALUE = " + aDouble);
		}

	/**
		Advanced Math for Java

		double, float, long, int abs(double d)
		double ceil(double d) 	Returns the smallest integer that is greater than or equal to the argument. Returned as a double.
		double floor(double d) 	Returns the largest integer that is less than or equal to the argument. Returned as a double.
		double rint(double d) 	Returns the integer that is closest in value to the argument. Returned as a double.
		long round(double d)
		int round(float f) 	Returns the closest long or int, as indicated by the method's return type, to the argument.
		long min(long arg1, long arg2) 	Returns the smaller of the two arguments.
		long max(long arg1, long arg2) 	Returns the larger of the two arguments. 
	*/
		
		if ((command.equalsIgnoreCase("bigger")) || (command.equalsIgnoreCase("smaller")))
		{
			int i = inputInt("Enter an integer. ");
			int j = inputInt("Enter another integer. ");
			int k = Math.max(i, j);
			if (k == i)
			{
				println("The first number is biggest.");
			}
			else
			{
				println("The second number is biggest.");
			}
		}
		
		if (command.equalsIgnoreCase("guess"))
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
				println("Better luck next time!");
			else if (guesses < 4)
				println("Bravo! You are a pure genius!");
			else if (guesses > 3 && guesses < 8)
				println("Nicely done! You're a good guesser!");
			else if (guesses > 7 && guesses < 12)
				println("Fairly good job, I guess!");
			else if (guesses > 13 && guesses < 21)
				println("That was an alright job!");
		}
		
		if (command.equalsIgnoreCase("dupecash"))
		{
			int c = cash;
			cash *= 2;
			println("You dupe your cash! Before you had " + c + ", now you have " + cash);
		}
		
		if (command.startsWith("addcash"))
		{
			int cc = inputInt("How much cash would you like to add? ");
			//addCash(cc);
		}
		
		if (command.equalsIgnoreCase("intro"))
		{
			println("We hope you enjoy this game!");
			name = input("What is your name? ");
			println("That's cool!");
			try
			{
				Thread.sleep(1000);
			}
			catch (Exception e)
			{
				println("ERROR SLEEPING.");
			}
			println("I'm going to take a short break. I'll be back in thirty seconds.");
			long l = 1000 * 30;
			try
			{
				Thread.sleep(l);
			}
			catch (Exception e)
			{
				println("ERROR SLEEPING.");
			}
			println("I'm back!");
		}
		
		if (command.equalsIgnoreCase("dowhile"))
		{
			double d = 0;
			do
			{
				println("Double D is: " + d);
				d++;
				d += (8-(2/1));
			}
			while (d < 100);
		}
		
		if (command.startsWith("substring"))
		{
			try
			{
				String ss = command.substring(10);
				println("You entered " + ss + " as your substring.");
			}
			catch (Exception e)
			{
				println("Faild to enter a correct command.");
			}
		}
		
		if (command.startsWith("pickup"))
		{
			int i = Integer.parseInt(command.substring(7));
		}
		
		if (command.equalsIgnoreCase("finals"))
		{
			final String lol = "!";
			final char SPACE_BAR = ' ';
			println("'" + SPACE_BAR + "'");
			println(lol);
		}
		
		if (command.equalsIgnoreCase("luckynumbersnull"))
		{
			int i = inputInt("Enter a lucky number. ");
			println("You have entered " + i);
			
			if (i == luckyNumbers[i])
			{
				println("Yay, it's a lucky number!");
			}
			else
			{
				println("According to Whac it's not lucky.");
			}
		}
		
		if (command.equalsIgnoreCase("objects"))
		{
			randomMethod();
		}
		
		if (command.equalsIgnoreCase("abs"))
		{
			int i = inputInt("Enter a number. ");
			int j = Math.abs(i);
			println("The absolute value of " + i + " is " + j);
		}
		
		if (command.equalsIgnoreCase("array"))
		{
			int anArray[] = new int[6];
			int j = 0;
			for (int i = 0; i < 6; i++)
			{
				j = inputInt("Enter an integer. ");
				anArray[i] = j;
			}
			for (int x = 0; x < 6; x++)
			{
				println("Element at [" + x + "]: " + anArray[x]);
			}
		}
		
		if (command.equalsIgnoreCase("luckynumbers"))
		{
			for (int i = 0; i < 27; i++)
			{
				println("Element at " + i + ": " + luckyNumbers[i] + ".");
			}
		}
		
		if (command.startsWith("addluckynumber"))
		{
			int i = (int) Integer.parseInt(command.substring(15));
			
			luckyNumbers[luckyNumberPos] = i;
			
			println("You added " + i + " to the array list at index " + luckyNumberPos);
			luckyNumberPos += 1;
		}
		
		if (command.startsWith("aln"))
		{
			int i = (int) Integer.parseInt(command.substring(4));
			luckyNumbers[luckyNumberPos] = i;
			println("You added " + i + " to the array list at index " + luckyNumberPos);
			luckyNumberPos += 1;
		}
		
		if (command.equalsIgnoreCase("checknull"))
		{
			String aNull = input("Enter a null! ");
			if (aNull.equalsIgnoreCase(""))
				println("Those were blank string brackets.");
			if (aNull.equalsIgnoreCase("null"))
				println("That was a null in words.");
			if (aNull.equalsIgnoreCase(null))
				println("Pure null!");
				sleep(600);
		}
		
		if (command.equalsIgnoreCase("ipfail"))
		{
			try
			{
				java.net.URL URL = new java.net.URL("http://whatismyip.org");   
				java.net.HttpURLConnection Conn = (HttpURLConnection)URL.openConnection();   
				java.io.InputStream InStream = Conn.getInputStream();   
				java.io.InputStreamReader Isr = new java.io.InputStreamReader(InStream);   
				java.io.BufferedReader Br = new java.io.BufferedReader(Isr);   

				println("Your IP address is " + Br.readLine());  
			}
			catch (Exception e)
			{
				println("Failed to get IP.");
			}
		}
		
		if (command.equalsIgnoreCase("ip") || (command.equalsIgnoreCase("myip")))
		{
			try
			{
				URL url = new URL("http://projectrainbow.net/quickip.php");
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

				String inputLine;

				while ((inputLine = in.readLine()) != null)
					println("Your external IP: " + inputLine);

				in.close();
			}
			catch (Exception e)
			{
				println("Failed to get input from www.projectrainbow.net");
			}

		}
		
		if (command.startsWith("url"))
		{
			try
			{
				String s = command.substring(4);
				try
				{
					URL url = new URL(s);
					BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
					String inputLine;
					while ((inputLine = in.readLine()) != null)
					{
						println(inputLine);
					}
					in.close();
				}
				catch (Exception e)
				{
					println("Faild to open site.");
				}
			}
			catch (Exception e)
			{
				println("Syntax is url URLHERE");
			}
		}
		if (command.equalsIgnoreCase("passhash"))
		{
			String s = input("Enter a String. ");
			passHash(s);
			println(passHash(s));
		}
		
		if (command.equalsIgnoreCase("tri"))
		{
			String side = input("Which side are you looking for? (a, b, c) ");
			if (side.equalsIgnoreCase("c"))
			{
				double a = (double) inputInt("What is side A? ");
				double b = (double) inputInt("What is side B? ");
				double c2 = (double) Math.pow(a, 2) + (double) Math.pow(b, 2);
				double c = 0;
				c = (double) Math.sqrt(c2);
				println("If A is " + a + " and B is " + b + ", then C is " + c + ".");
			}
			else if (side.equalsIgnoreCase("a"))
			{
				double b = (double) inputInt("What is side B? ");
				double c = (double) inputInt("What is side C? ");
				double b2 = 0;
				b2 = (double) Math.pow(b, 2);
				double c2 = 0;
				c2 = (double) Math.pow(c, 2); //squaring c
				double a2 = c2 - b2;
				double a = Math.sqrt(a2);
				println("If B is " + b + " and C is " + c + ", then A is " + a + ".");
			}
		}
		
		if (command.equalsIgnoreCase("args"))
		{
			try
			{
				println("Args is: " + args[0] + ", " + args[1] + ", " + args[2] + ", and " + args[3] + ".");
				//-lolfail -godmode -cheater
			}
			catch (Exception e)
			{
				println("You are currently running Calculations without arguments!");
			}
		}
		
		if (command.equalsIgnoreCase("chartest"))
		{
			try
			{
				String s = input("Enter a character. ");
				char c;
				c = s.charAt(0);
				println("The char is " + c);
				//char d = (char) c + 1;
				//println("The new char D is " + d);
			}
			catch (Exception e)
			{
				println("Actually try to enter a char.");
			}
		}
		
		if (command.equalsIgnoreCase("prime71"))
		{
			for (double i = 1; i < Integer.MAX_VALUE; i++)
			{
				double j = 0;
						
				//if 71(prime) + 1 = square
				for (j = 2; j < i; j++)
				{
					double k = i % j;
					if (k == 0)
					{
						break;
					}
				}
				
				if (i == j)
				{
					double sq = 0;
					sq = Math.sqrt((i * 71) + 1);
					if (sq % i != 0)
					{
						println("#: " + i);
						sleep(10);
					}
				}
			}
		}
		
		if (command.equalsIgnoreCase("runelocus"))
			launchURL("http://www.runelocus.com/status/?action=details&id=9491");
		
		if (command.equalsIgnoreCase("failsqrt"))
		{
			double a = 0;
			double b = 0;
			double c = 0;
			double d = 0;
			
			for (a = 0; a < 500; a++)
			{
				for (b = 1; b < a; b++)
				{
					for (c = 2; c < b; c++)
					{
						if (a + b + c == 400)
						{
							d = Math.sqrt((double) (2 * a + c));
						}
					}
				}
			}
			println("" + d);
		}
		
		if (command.equalsIgnoreCase("reversal"))
		{
			int x = 0;
			int y = 0;
			int z = 0;
			int temp = 0;
			int number = 0;
			int reversal = 0;
			x = inputInt("Enter the hundred's place. ");
			y = inputInt("Enter the tens place. ");
			z = inputInt("Enter the ones place. ");
			number = (100 * x) + (10 * y) + z;
			println("The number is " + number + ".");
			reversal = (100 * z) + (10 * y) + x;
			println("The reversal is " + reversal + ".");
		}
		
		if (command.equalsIgnoreCase("gayclasses"))
		{
			boolean isGay = false;
			String aClass = "";
			println(aClass);
			String[] classes = {"Asian Studies", "Chinese", "English"};
			int c = inputInt("Which Class? (0, 1, 2) ");
			switch (c)
			{
				case 0:
					aClass = "very gay";
					break;
					
				case 1:
					aClass = "gay";
					break;
					
				case 2:
					aClass = "a bit gay";
					break;
					
				default:
					aClass = c + ""; //aClass = "not at all wrong, you just fail";
					break;
			}
			println("The class is " + classes[c] + ", and it is " + aClass + ".");
		}
		
		if (command.startsWith("thepass"))
		{
			try
			{
				String pass = command.substring(8);
				if (!pass.equalsIgnoreCase(""))
				{
					println("Wrong password!");
					passfails++;
				}
				else
				{
					println("Correct!");
				}
				if (passfails > 4)
				{
					println("The password is . Please enter the passord.");
				}
			}
			catch (Exception e)
			{
				println("Fail.");
			}
		}
			
		
		if (command.startsWith("#"))
		{
			String s = command.substring(1);
			println("You entered " + s);
			double a = 10D;
			int b = 403;
			long c = 9207L;
			println(a + " " + b + " " + c);
			println(0x4D4 + "");
		}
		
		if (command.equalsIgnoreCase("hosters"))
		{
			String[] aString = {"Justin Zeng", "Nathan Pryce", "Mike Gautreau", "Ryan Teal", "Zach Savage", "Gannon Terry"};
			String[] ingameNames = {"Whac", "Pl0xpkerrulz", "Mikegau44", "Koawbra", "Hybrid0819", "Gannon"};
			int option = inputInt("Give me the # of the hoster. ");
			if (option > -1 && option < 6)
				println("The hoster was " + ingameNames[option] + ", and his real name was " + aString[option]);
			else
				invalid(true);
		}
		
		if (command.startsWith("encrypt "))
		{
			String stuff = command.substring(8);
			String otherStuff = encrypt(stuff);
			println("MD5: " + otherStuff);
		}
		
		if (command.startsWith("writemd5 "))
		{
			String stuff = command.substring(9);
			String otherStuff = encrypt(stuff);
			println("MD5: " + otherStuff);
			BufferedWriter bw = null; //makes a new bufferedwriter called br
			try
			{
				bw = new BufferedWriter(new FileWriter("aPasswords.txt", true)); //the file used the filwriter class and opens a file,
				bw.write(stuff + ": " + otherStuff);													  //the true part is "add on", false means overwrite file (wipe it)
				bw.newLine(); //write is write a bunch of text, self explanatory, new line makes a new line, duh
				bw.flush(); //to close out
				bw.close();
			}
			catch (Exception e)
			{
				println("Error writing .txt!");
				//fail = 1;
			}
		}
		
		if (command.equalsIgnoreCase("popcorn"))
		{
			String D34THKN1GHT = null;
			//int element = inputInt("Enter Popcorn: ");
			for (int element : popcorn)
			{
				int aRandom = random(50);
				aRandom += (60 - 1);
				println("Popcorn: " + popcorn + "] " + aRandom);
				sleep(500);
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
						println(D34THKN1GHT);
						break;
				}
				sleep(500);
			}
			println("Finished Popping! \n");
			for (int i = 0; i < 4; i++)
			{
				println("[][][][]");
			}
			sleep(1000);
		}
			
		//array, 6, sort arrays
		if ((command.equalsIgnoreCase("quit")) || (command.equalsIgnoreCase("exit")))
		{
			println("Cya next time!");
			println("");
			System.exit(0);
		}

		calcs.main(args);
	}
	
	
	private static String wc = "";
	private static int[][] multi = new int[2][2];
	private static boolean whac = false;
	private static int cash = 10;
	private static int passfails = 0;
	private static int health = -22222;
	private static String name = "";
	private static int inventory[] = new int[27];
	private static boolean wipe = false;
	
	private static int[] luckyNumbers = new int[27];
	private static int luckyNumberPos = 0;
		
	private static int[] popcorn = {3, 7, 11, 14, 19, 21, 23, 24, 25};
	
	private static String pass = null;
	
	private static String capitalize(String text)
	{
		String result = "";
		if (text.length() > 0)
		{
			/**
			String text2 = text.substring(1);
			text = text.replaceAll(text2, "");
			text.toUpperCase();
			result = text + text2;
			**/
			//String start = text.subSequence(1);
			//start.toUpperCase();
			//result = start + text.substring(1);
			result = Character.toUpperCase(text.charAt(0)) + text.substring(1).toString();
		}
		return result;
	}
	
	
    private static void launchURL(String s)
	{
        String s1 = System.getProperty("os.name");
        try 
		{
            if (s1.startsWith("Windows")) 
                Runtime.getRuntime().exec((new StringBuilder()).append("rundll32 url.dll,FileProtocolHandler ").append(s).toString());
			else 
			{
                String as[] = {
                    "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape", "iexplore", "internet explorer", "chrome", "safari"
                };
                String s2 = null;
                for (int i = 0; i < as.length && s2 == null; i++)
				{
                    if (Runtime.getRuntime().exec(new String[]{"which", as[i]}).waitFor() == 0) 
					{
                        s2 = as[i];
                    }
                }
                if (s2 == null)
                    throw new Exception("Could not find web browser..");
                Runtime.getRuntime().exec(new String[]{
                            s2, s
                        });
            }
        } 
		catch (Exception exception) 
		{
            println("An error occured while trying to open the web browser!\n");
        }
    }
	
}