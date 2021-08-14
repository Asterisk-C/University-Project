package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

public class Buttons extends Chess implements Chessboard, ActionListener
{
	private String mode = "2P";
	
	//Use a global variable to test void method reset()
	public static int testReset = 0;
	
	public static int testButtons = 0;
	
	public MouseEvent me;
	public ActionEvent ae;
	
	//Choose play mode, 1P or 2P
	public void mousePressed(MouseEvent e) 
	{
		if (mode.equals("1P")) 
		{
			singleplayer(e.getX(), e.getY());
			testButtons++;
		} 
		else if (mode.equals("2P")) 
		{
			doubleplayer(e.getX(), e.getY());
			testButtons++;
		}
		me = e;
	}
	
	//Achieve each function of buttons by action listener
	public void actionPerformed(ActionEvent e) 
	{
		//Get char of button
		String cmd = e.getActionCommand();
		if ("Start".equals(cmd) || "Reset".equals(cmd)) 
		{
			//Reset the chessboard
			reset();
			testButtons++;
		}
		if ("1P".equals(cmd))
		{
			mode = "1P";
			reset();
			testButtons++;
		}
		if ("2P".equals(cmd)) 
		{
			mode = "2P";
			reset();
			testButtons++;
		}
		//Undo the steps according to game mode
		if ("Repent".equals(cmd)) 
		{
			testButtons++;
			if (count > 0) 
			{
				if (mode == "2P") 
				{
					chessArray[x_undo[count]][y_undo[count]] = 0;
					count--;
				} 
				else if (mode == "1P") 
				{
					chessArray[x_undo[count - 1]][y_undo[count - 1]] = 0;
					count--;
					chessArray[x_undo[count - 1]][y_undo[count - 1]] = 0;
					count--;
				} else 
				{
					JOptionPane.showMessageDialog(f, "You have run out of chess pieces");
				}
			f.repaint();
			}
		}
		ae = e;
	}
	
	//Method of reset
	public void reset() 
	{
		flag = 1;
		count = 0;
		f.repaint();
		for (int i = 0; i < LENGTH; i++) 
		{
			for (int j = 0; j < LENGTH; j++) 
			{
				chessArray[i][j] = 0;
				//Check reset() works or not
				testReset = 1;
			}
		}
	}
}
