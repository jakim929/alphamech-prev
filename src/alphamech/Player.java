package alphamech;
/**
* Lists.java
* Declaring variables
*
* by Justin Zeng and James Kim
*
*/

public abstract class Player
{
	//Variables in this class should be static, otherwise there will be problems -Justin
	public static boolean existing = false;
	public static boolean loggedIn = false;
	public static int location = 1;
	public static int anInt = 0;
	public static String playerName = "Player X";
	public static String playerPass = "DEFAULT_PASSWORD";
	public static int health = 100;
	public static int exp = 10;
	public static int potions = 25;
	public static int playerRights = 0;
	public static int weapon;
	public static String weapon2;
	public static int coins = 50;
	public static int playerMaxHit;
	public static boolean poisoned = false;
	public static boolean hasPet = false;
	public static String petName = "NO_PET";
}