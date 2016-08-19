/**
* GameFrame.java

* Starts the frame of the game.
*
* by Justin Zeng and James Kim
*
*/

package alphamech;

import javax.swing.*;

public class GameFrame extends JFrame
{
	public static void start()
	{
	    JFrame frame = new JFrame("Alpha Mech 2D");
		frame.add(new Map());
		//frame.setLocationRelativeTo(null);
		frame.setSize(515, 535); //don't change this.. we'll have to make TOTALLY new backgrounds.
		frame.setResizable(false); //don't want it to be resizable, lol
		frame.setVisible(true);
	}
}