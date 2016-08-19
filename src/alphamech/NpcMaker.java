/**
* NpcMaker.java

* Creates NPC's.
*
* by Justin Zeng and James Kim
*
*/

package alphamech;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class NpcMaker extends AlphaMech
	{
		public static void main(String args[])
		{
			try
			{
				File f = new File("./NPC/");
				f.mkdir();
				BufferedWriter bwin = null;
				BufferedReader keyboard = null;
				try
				{
					keyboard = new BufferedReader(new InputStreamReader(System.in));
					System.out.print("Type in the NPC Number(ID) of the NPC: ");
					String npc = keyboard.readLine();
					
					bwin = new BufferedWriter(new FileWriter(("./NPC/"+ npc + ".txt"), false)); //false = overwrites
					
					bwin.write(npc);
					bwin.newLine();
					
					System.out.print("Type in the NPC name (word): ");
					String NPCName = keyboard.readLine();
					bwin.write(NPCName);
					bwin.newLine(); //newLine() is better than \n as we can read it easier in regular notepad.exe :D
					System.out.print("Type in the kind of the NPC (1: Fightable, 2: Talkable, 3: A shop seller) ");
					String type = keyboard.readLine();
					bwin.write(type);
					bwin.newLine();
					System.out.print("Type in the location of the NPC (number): ");
					String location = keyboard.readLine();
					bwin.write(location);
					bwin.newLine();
					System.out.print("Type in the level (number): ");
					String level = keyboard.readLine();
					bwin.write(level);
					bwin.newLine();
					System.out.print("Type in the wielding weapon (item number): ");
					String wweapon = keyboard.readLine();
					bwin.write(wweapon);
					bwin.newLine();
					if (Integer.parseInt(type) == 1)
					{
						System.out.print("Type in the number of items this NPC may drop (number): ");
						String ditem = keyboard.readLine();
						bwin.write(ditem);
						bwin.newLine();
						int leftPer = 100;
						for(int i=1; i <= Integer.parseInt(ditem); i++)
						{
							
							System.out.print("Type in the ID of one item that the NPC may drop (number): ");
							String itemno = keyboard.readLine();
							bwin.write(itemno);
							bwin.newLine();
							boolean percentageChecker  = true;
							System.out.print("Type in the percentage possibility of the drop <percentage left:"+leftPer+"> " + "<ITEM: "+ itemno + "> =>");
							String dropPos = keyboard.readLine();
							String deletedPer = dropPos;
							if(Integer.parseInt(deletedPer)<= leftPer)
							{
								leftPer -= Integer.parseInt(deletedPer);
								bwin.write(deletedPer);
								bwin.newLine();
							}else{
								System.out.println("Yo, plz learn math and put a possible percentage");
							}
							
						}
						
					}
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
