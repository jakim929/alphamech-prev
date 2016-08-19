/**

* MainMethods.java
* Technical method and coding here.
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
import javax.swing.JApplet;
import java.awt.*;
import java.awt.Graphics;
import java.text.*;

public class MainMethods extends Player implements Constants
{
	public static String wc = "";
	
    public static void openURL(String url) {
        Desktop d = Desktop.getDesktop();
        try {
            d.browse(new URI(url));
        } catch (Exception e) {
        }
    }
	
	public static String encrypt(String string)
	{
		String result = new MD5(string).compute();
		return result;
	}
	
	public static String yourName = "PlayerName";
	
	public static String reverse(String string)
	{
		String result = "";
		for (int i = (string.length() - 1); i >= 0; i--)
			result = result + string.charAt(i);
		return result;
	}
	/*
	public static void account()
	{
		Calculations calcs = new Calculations();
		System.out.println("");
		System.out.println("Welcome to Virtual Rainbow!");
		String existing = input("New User or Existing User? (new, old) ");
		if (existing.equalsIgnoreCase("old"))
		{
			existingUser = true;
		}
		else if (existing.equalsIgnoreCase("new"))
		{
			existingUser = false;
		}
		String u = input("Username: ");
		String p = input("Password: ");
		
		if (existingUser == false)
		{
			if (newAccount(u, p) == 1)
			{
				loggedIn = true;
				System.out.println("Successfully registered!");
				System.out.println("You are now logged in as: " + u);
				playerName = u;
				playerPass = p;
			}
			else if (newAccount(u, p) == 2)
			{
				System.out.println("Already in use!");
				calcs.main(null);
			}
			else
			{
				System.out.println("Error making new account!");
				calcs.main(null);
			}
		}
		if (existingUser == true)
		{
			if (loadAccount(u, p) == 1)
			{
				loggedIn = true;
				System.out.println("Successfully loaded!");
				System.out.println("You are now logged in as: " + u);
				playerName = u;
				playerPass = p;
			}
			else if (loadAccount(u, p) == 2)
			{
				System.out.println("Invalid password!");
				calcs.main(null);
			}
			else
			{
				System.out.println("Failed to load account!");
				calcs.main(null);
			}
		}
	}
	
	public static int newAccount(String user, String pass)
	{
		BufferedWriter bw = null;
		BufferedReader br = null;
		boolean rewrite = false;
		
		try
		{
			br = new BufferedReader(new FileReader(user + ".txt"));
			String s;
			while ((s = br.readLine()) != null)
			{
				rewrite = true;
				return 2;
			}
		}
		catch (Exception e)
		{
		}
		if (rewrite == false)
		{
			try
			{
				bw = new BufferedWriter(new FileWriter(user + ".txt", true));
				bw.write(pass);
				bw.flush();
				bw.close();
				return 1;
			}
			catch (Exception e)
			{
				return 0;
			}
		}
		return 0;
	}
	
	public static int loadAccount(String user, String pass)
	{
		BufferedReader br = null;
		String temppass = "";
		try
		{
			br = new BufferedReader(new FileReader(user + ".txt"));
			String s;
			temppass = br.readLine();
			
			if (temppass.equalsIgnoreCase(pass))
			{
				return 1;
			}
			else
			{
				return 2;
			}
		}
		catch (Exception e)
		{
			return 0;
		}
	}
	
	//henker, zag1s, 
	
	public static int loadAccountNew(String user, String pass)
	{
		BufferedReader br = null;
		String temppass = "";
		try
		{
			br = new BufferedReader(new FileReader(user + ".txt"));
			String read;
			read = br.readLine();
			while ((read = br.readLine()) != null)
			{
			}
				
		}
		catch (Exception e)
		{
			return 0;
		}
		return 72;
	}
	*/
	
	public static double roundDouble(double number, int places)
	{
		String sharps = "";
		for (int i = 0; i < places; i++)
		{
			sharps += "#";
		}
		if (sharps == "")
			sharps = "#";
		DecimalFormat df = new DecimalFormat("#." + sharps);
		return Double.valueOf(df.format(number));
	}
	
	public static String passHash(String password)
	{
        String saltM = new MD5("failsalt").compute();
        String passM = new MD5(password).compute();
        return new MD5(saltM + passM).compute();
	}
	
	public static void loadIniFile(String user, String pass)
	{
	}
	
	public static int randomMethod()
	{
		return 7;
	}
	
    public void paintComponent(Graphics g) 
	{
        g.drawString("Example of Applet", 65, 95);
    }
	
	public static int sleep(int s)
	{
		try
		{
			Thread.sleep(s);
		}
		catch (Exception e)
		{
			println("F@1L3D T0 5L33P!");
		}
		return 7;
	}
	public static void println(String info)
	{
		System.out.println(info);
	}
	
	public static void print(String info)
	{
		System.out.print(info);
	}
	
	public static int inputInt(String Prompt)
    {  
        int result = 0;
        try 
		{
			result = Integer.parseInt(input(Prompt).trim());
		}
        catch (Exception e)
		{
			result = 0;
		}
        return result;
	}
    public static double inputDouble(String Prompt)
    {  
        double result = 0;
        try 
		{
			result = Double.valueOf(input(Prompt).trim()).doubleValue();
		}
		catch (Exception e)
		{
			result = 0;
		}
		return result;
    }
	
	public static String input(String prompt)
	{
		String inputLine = "";
		System.out.print(prompt);
		try
		{
             java.io.InputStreamReader sys = new java.io.InputStreamReader(System.in);
             java.io.BufferedReader inBuffer = new java.io.BufferedReader(sys);
             inputLine = inBuffer.readLine();
		}
		catch (Exception e)
		{
			String err = e.toString();
			System.out.println(err);
			inputLine = "";
		}
		return inputLine;
	}
	
	public static String inputString(String prompt)
	{
		return input(prompt);
	}
	
	public static String input()
	{ 
		return input("");
	}
	
	public static int random(int range)
	{ 
		// returns random from 0 to range, range is included
		return (int) (Math.random() * (range + 1));
	}
	
	public static void saveLog(long l)
	{
		BufferedWriter bw = null;
        try {
			bw = new BufferedWriter(
                    new FileWriter(wc + ".txt", true));
            bw.write(l + "");
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe2) {
                }
            }
        }
    }
	
	public static void saveLog(String l)
	{
		BufferedWriter bw = null;
        try {
			bw = new BufferedWriter(
                    new FileWriter(wc + ".txt", true));
            bw.write(l + "");
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe2) {
                }
            }
        }
    }
	
	public static void saveLog(int l)
	{
		BufferedWriter bw = null;
        try {
			bw = new BufferedWriter(
                    new FileWriter(wc + ".txt", true));
            bw.write(l + "");
            bw.newLine();
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ioe2) {
                }
            }
        }
    }

	public static void wipeFile(String wf)
	{
		BufferedReader br = null;
		//println("Enter the file without '.txt' which you want to wipe.");
        try {
            br = new BufferedReader(new FileReader(wf + ".txt"));
            String s;
            br.close();
            BufferedWriter output = new BufferedWriter(new FileWriter(wf + ".txt"));
            output.write("");
            output.newLine();
			println("Successfully wiped file: " + wf + ".txt.");
        } catch (IOException ioe3) {
            ioe3.printStackTrace();
			System.out.println("Could not wipe file: " + wf + ".txt.");
        }
    }
	
	public static long invalid(boolean b)
	{
		if (b == true)
			println("1NV@L1D NUM133R!!!");
		else
			println("Invalid Number.");
		return 777;
	}
	
	public static boolean R4N1D0M5TR1NG()
	{
		println("");
		return false;
	}
	
	public static String getDate() 
	{
        Calendar cal = new GregorianCalendar();
		String ampm = cal.get(Calendar.AM_PM) == 0 ? "AM" : "PM";
		String date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
		String time = new SimpleDateFormat("hh:mm:ss").format(new Date());
		String result = date + " | Time: " + time + " " + ampm;
		return result;
	}
	
    public static int byteArrayToInt(byte abyte0[], int i)
    {
        int j = 0;
        for(int k = 0; k < 4; k++)
        {
            int l = (3 - k) * 8;
            j += (abyte0[k + i] & 0xff) << l;
        }

        return j;
    }
	
	public static int macAdd()
	{
		byte[] mac;
		int macAdd2;
		try 
		{
			InetAddress address = InetAddress.getLocalHost();
			NetworkInterface ni = NetworkInterface.getByInetAddress(address);
			mac = ni.getHardwareAddress();
			for (int i = 0; i < mac.length; i++)
			{
				System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "\n");
			}
			macAdd2 = byteArrayToInt(mac, 0);
			//System.out.println("Byte Array MAC Address Converted To Int:" + macAdd2);
			return macAdd2;
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int start = 0;
	
}