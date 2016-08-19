package alphamech;
public class Chat extends AlphaMech
{
	public static void main(String[] args)
	{
		println("");
		String chat = input(Calculations.yourName + ": ");
		checkForSwearing(chat);
		Chat cc = new Chat();
		cc.main(null);
	}
	
	public static final void checkForSwearing(String line)
	{
		String templine = line;
		for (int i = 0; i < badWords.length; i++)
		{
			String bad = badWords[i];
			templine = templine.toLowerCase();
			if (templine.contains(bad))
			{
				String stars = "";
				for (int j = 0; j < bad.length(); j++)
				{
					stars = stars + "*";
				}
				templine = templine.replaceAll(badWords[i], stars);
			}
		}
		println("[Player] " + Calculations.yourName + ": " + templine);
	}
	
	public static final String[] badWords = 
	{
		"fuck", "fuk", "fuc", "phuck", "phuk", "shit", "sht", "gay", "asshole", "ashole", 
		"bitch", "btch", "slut", "whore", "nigger", "nigga", "cunt", "bastard", "fag",
		"sex", "oral", "blowjob", "anal", "pussy"
	};
	
	public static final String[] symbols = 
	{
		".", "-", " ", ",", "<", ">", "/",  "!", "~", "`", ";", "'", "_", "+", "="
	};
}