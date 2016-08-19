package alphamech;
import java.io.*;

public class NpcHandler {

	public static BufferedReader iR = null;
		
	public static String getNpcName(int npcId) throws IOException
	{
		iR = new BufferedReader(new FileReader("./NPC/"+npcId+".txt"));
		iR.readLine();
		String name = iR.readLine();
		return name;
		
	}
	
	public static int getNpcType(int npcId) throws IOException
	{
		iR = new BufferedReader(new FileReader("./NPC/"+npcId+".txt"));
		for(int i = 0; i<2; i++)
			iR.readLine();
		int npcType = Integer.parseInt(iR.readLine());
		return npcType;
		
	}
	
	public static int getNpcLocation(int npcId) throws IOException
	{
		iR = new BufferedReader(new FileReader("./NPC/"+npcId+".txt"));
		for(int i = 0; i<3; i++)
			iR.readLine();
		int location = Integer.parseInt(iR.readLine());
		iR.close();
		return location;
		
	}
	
	public static int getNpcLevel(int npcId) throws IOException
	{
		iR = new BufferedReader(new FileReader("./NPC/"+npcId+".txt"));
		for(int i = 0; i<4; i++)
			iR.readLine();
		int location = Integer.parseInt(iR.readLine());
		iR.close();
		return location;
		
	}
	
	public static int getNpcWeapon(int npcId) throws IOException
	{
		iR = new BufferedReader(new FileReader("./NPC/"+npcId+".txt"));
		for(int i = 0; i<5; i++)
			iR.readLine();
		int weapon = Integer.parseInt(iR.readLine());
		iR.close();
		return weapon;
		
	}
	
	public static int getDroppableItems(int npcId) throws IOException
	{
		iR = new BufferedReader(new FileReader("./NPC/"+npcId+".txt"));
		for(int i = 0; i<6; i++)
			iR.readLine();
		int droppableItems = Integer.parseInt(iR.readLine());
		iR.close();
		return droppableItems;
	}
}
