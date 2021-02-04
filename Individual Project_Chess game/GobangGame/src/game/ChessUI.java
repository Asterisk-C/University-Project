package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessUI extends JPanel implements Chessboard 
{
	Buttons b = new Buttons();
	
	private Buttons listener = null;

	public static void main(String[] args) 
	{
		ChessUI test = new ChessUI();
		test.ShowUI();
	}

	//Constructor
	public ChessUI()
	{
		listener = new Buttons();
	}
	
	//Make an UI
	public void ShowUI() 
	{
		//A JFrame
		JFrame jf = new JFrame();
		jf.setTitle("Gobang");
		jf.setDefaultCloseOperation(3);
		//Set width and height
		jf.setSize(750, 650);
		jf.setResizable(false);
		//Get logo
		jf.setIconImage(new ImageIcon("src/com/dsq/Fivechesse1128/Image/qqÍ¼±ê.png").getImage());
		//Centralize the window
		jf.setLocationRelativeTo(null);
		
		
		//Menu on the right
		JPanel jp = new JPanel();
		jp.setLayout(new FlowLayout());
		//Set menu's color
		jp.setBackground(Color.GRAY);
		//Set menu's size
		jp.setPreferredSize(new Dimension(100,0));
		jf.add(jp, BorderLayout.EAST);
		
		//Set buttons name
		String[] buttons = { "Start", "1P","2P" ,"Repent", "Reset" };
		for (int i = 0; i < buttons.length; i++) 
		{
			JButton jb = new JButton(buttons[i]);
			jb.setPreferredSize(new Dimension(100, 40));
			jb.setBackground(Color.GRAY);
			//boundary of button
			jb.setBorderPainted(false);
			jp.add(jb);	
			//Add listener to buttons
			jb.addActionListener(listener);
		}
		
		//Set color in chessboard
		this.setBackground(Color.LIGHT_GRAY);
		jf.add(this, BorderLayout.CENTER);
		
		//Add listener to chessboard
		this.addMouseListener(listener);
		jf.setVisible(true);
		listener.setJPane(this);
	}
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		//Draw the lines to chessboard
		for (int i = 0; i < LENGTH; i++) 
		{
			g.drawLine(X_START, Y_START + i * SPACE, X_START + (LENGTH - 1) * SPACE, Y_START + i * SPACE);
			g.drawLine(X_START + i * SPACE, Y_START, X_START + i * SPACE, Y_START + (LENGTH - 1) * SPACE);
		}
		//Draw pieces
		for (int i = 0; i < LENGTH; i++) 
		{
			for (int j = 0; j < LENGTH; j++) 
			{
				//Yellow piece
				if (chessArray[i][j] == 1) 
				{
					g.drawImage(new ImageIcon("src/game/Image/yellow.png").getImage(),(X_START + i * SPACE) - PIECE_SIZE / 2,(Y_START + j * SPACE) - PIECE_SIZE / 2, PIECE_SIZE, PIECE_SIZE, null);
				}
				//Blace piece
				if (chessArray[i][j] == 2) 
				{
					g.drawImage(new ImageIcon("src/game/Image/black.png").getImage(),(X_START + i * SPACE) - PIECE_SIZE / 2,(Y_START + j * SPACE) - PIECE_SIZE / 2, PIECE_SIZE, PIECE_SIZE, null);
				}
			}
		}
	}
}
