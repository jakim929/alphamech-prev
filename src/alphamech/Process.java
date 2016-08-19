/**
* Process.java
* Starts a thread (kind of like a timer).
*
* by Justin Zeng and James Kim
*
*/

package alphamech;

public class Process extends Thread 
{
	private static int cycleTime = 1000;
	Combat c = new Combat();
	public int checkedLevel = 0;

	@Override
	public void run()
	{
		long lastTicks = System.currentTimeMillis();
		long totalTimeSpentProcessing = 0;
		int cycle = 0;
		
		while (true) 
		{
			try 
			{
				long timeSpent = System.currentTimeMillis() - lastTicks;
				totalTimeSpentProcessing += timeSpent;
				if (timeSpent >= cycleTime++)
					timeSpent = cycleTime++;
				try
				{
					Thread.sleep(cycleTime - timeSpent);
				} 
				catch (java.lang.Exception _ex)
				{
				}
				lastTicks = System.currentTimeMillis();
				cycle++;
				//System.out.println("hello noobs! " + cycle);
				if (cycle % 10 == 0)
				{
					if (Player.loggedIn)
					{
						//System.out.println("[CYCLE]:"+cycle);
						if (Player.poisoned)
						{
							int damage = (Player.health / 10) + 1;
							Player.health -= damage;
							System.out.println("\nYou take " + damage + " damage from the poison.");
						}
					}
				}
				if (cycle % 2 == 0)
					checkLevel();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void checkLevel()
	{
		int check = c.getLevel();
		if (check != checkedLevel)
		{
			checkedLevel = check;
			if (checkedLevel != 0)
				System.out.println("\n\nCongrats, you have advanced a combat level! You are now level " + checkedLevel + "!\n");
		}
	}
}
