package BikeRiding;

import javax.swing.*;

public class Main 
{

	public static void main(String[] args) 
	{
		GameBoard gb = new GameBoard();
		
		JFrame gameFrame = new JFrame();
		gameFrame.setTitle("HILL RIDING");
		gameFrame.setSize(1020, 700);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gameFrame.add(gb);
		gameFrame.setVisible(true);
	
	}

}
