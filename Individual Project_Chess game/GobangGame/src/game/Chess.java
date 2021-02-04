package game;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*Using MouseListener and ActionListener to achieve man-machine battle and double-player battle
 *Analyzing the chessboard situation, calculating the weight of each position according to the set weight 
(hashmap<checkerboard situation, weight>), and choosing the best position to place the chess pieces*/
public class Chess extends MouseAdapter implements Chessboard
{

	//Use hashmap to achieve auto-play for computer in single player mode
	private HashMap<String, Integer> map = new HashMap<String, Integer>();
	protected JPanel f;
	protected Graphics g;
	//Pictures of pieces
	private ImageIcon iconyellow, iconblack;
	
	//Use count to alternate play for 2 players and repent
	protected int count = 0;
	//Record positions for each step, for repent
	int[] x_undo = new int[LENGTH * LENGTH];
	int[] y_undo = new int[LENGTH * LENGTH];

	/*
	 * flag=0, can set piece
	 * flag=1, can not set piece
	 */
	protected int flag = 0;

	//Constructor
	public Chess() 
	{
		//Get pictures for pieces
		iconyellow = new ImageIcon(this.getClass().getResource("Image/yellow.png"));
		iconblack = new ImageIcon(this.getClass().getResource("Image/black.png"));

		//Initialize hashmap
		map.put("", 0);
		map.put("0", 0);
		//Attack for computer
		map.put("1", 6);
		map.put("11", 40);
		map.put("111", 300);
		map.put("1111", 1);
		//Defence for computer
		map.put("12", 2);
		map.put("112", 8);
		map.put("1112", 13);
		map.put("11112", 50000);
		//Attack for computer
		map.put("2", 10);
		map.put("22", 80);
		map.put("222", 500);
		map.put("2222", 50000);
		//Defence for computer
		map.put("21", 5);
		map.put("221", 15);
		map.put("2221", 70);
		map.put("22221", 50000);
	}

	//Single player mode
	public void singleplayer(int x, int y) {
		//Use x and y to represent mouse click point
		//Use x_cross and y_cross to represent every cross of the chessboard
		int x_cross;
		int y_cross;

		for (int i = 0; i < LENGTH; i++) 
		{
			for (int j = 0; j < LENGTH; j++) 
			{
				//The coordinate value of the i-th intersection
				x_cross = X_START + i * SPACE;
				y_cross = Y_START + j * SPACE;

				//Judge the point you click blongs to which points, and give the coordinate value to x_cross and y_cross
				if (chessArray[i][j] == 0 && x > (x_cross - SPACE / 2) && x < (x_cross + SPACE / 2)
						&& y > (y_cross - SPACE / 2) && y < (y_cross + SPACE / 2) && flag == 1) 
				{
					//Print each steps
					System.out.println("Set piece at no." + i + " rows£¬no." + j + " columns£»");
					//Record information about chessboard
					chessArray[i][j] = 1;
					x_undo[count] = i;
					y_undo[count] = j;
					count++;

					//Draw piece at point
					g.drawImage(iconyellow.getImage(), x_cross - PIECE_SIZE / 2, y_cross - PIECE_SIZE / 2, PIECE_SIZE, PIECE_SIZE, null);

					//Judge win or lose
					//Win
					if (win() == 1) 
					{
						JOptionPane.showMessageDialog(f, "Congratulation, you win");
					} 
					//Lose
					else if (win() == 2) 
					{
						JOptionPane.showMessageDialog(f, "Oops, you lose, wanna try again?");
					}
					
					//Auto set piece by computer
					if (win() == 0) 
					{
						//Traverse chessboard, get values of each point weight and store it to "weight"
						int[][] weight = getWeight();
						//Traverse chessboard, choose latest and biggest weight as point to set piece
						int[] max = maxWeight(weight);
												
						//Record information of chessboard
						chessArray[max[0]][max[1]] = 2;
						g.drawImage(iconblack.getImage(), X_START + max[0] * SPACE - PIECE_SIZE / 2, Y_START + max[1] * SPACE - PIECE_SIZE / 2, PIECE_SIZE, PIECE_SIZE, null);
						x_undo[count] = max[0];
						y_undo[count] = max[1];
						count++;
					}
					
				}
			}
		}
	}

	//Double player mode, without connection to internet
	public void doubleplayer(int x, int y) 
	{
		//Use x and y to represent mouse click point
		//Use x_cross and y_cross to represent every cross of the chessboard
		int x_cross;
		int y_cross;
		for (int i = 0; i < LENGTH; i++) 
		{
			for (int j = 0; j < LENGTH; j++) 
			{
				//The coordinate value of the i-th intersection
				x_cross = X_START + i * SPACE;
				y_cross = Y_START + j * SPACE;
				
				//Judge the point you click blongs to which points, and give the coordinate value to x_cross and y_cross
				if (flag == 1 && chessArray[i][j] == 0 && x > (x_cross - SPACE / 2)
						&& x < (x_cross + SPACE / 2) && y > (y_cross - SPACE / 2)
						&& y < (y_cross + SPACE / 2)) 
				{
					//Play chess and record steps
					chessArray[i][j] = drawPiece(x_cross, y_cross);
					x_undo[count] = i;
					y_undo[count] = j;
					//Judge win or lose
					if (win() == 1) 
					{
						JOptionPane.showMessageDialog(f, "Yellow piece win");
					} 
					else if (win() == 2) 
					{
						JOptionPane.showMessageDialog(f, "Blace piece win");
					}
				}
			}
		}
	}
	
	//Set chessboard
		public void setJPane(JPanel f) 
		{
			this.f = f;
			g = f.getGraphics();
		}

	/*
	 * Draw piece(x_cross, y_cross) with alternate order
	 * Use 1 represent yellow piece
	 * Use 2 represent black piece
	 */
	public int drawPiece(int x_cross, int y_cross) 
	{
		if (count % 2 == 0) 
		{
			g.drawImage(iconyellow.getImage(), x_cross - PIECE_SIZE / 2, y_cross - PIECE_SIZE / 2, PIECE_SIZE, PIECE_SIZE, null);
			count++;
			return 1;
		} 
		else 
		{
			g.drawImage(iconblack.getImage(), x_cross - PIECE_SIZE / 2, y_cross - PIECE_SIZE / 2, PIECE_SIZE, PIECE_SIZE, null);
			count++;
			return 2;
		}

	}

	//Traverse the board to get the weight of each position
	public int[][] getWeight() 
	{
		//A specific point
		String code = "";
		//Weight value of a specific point
		Integer value = 0;
		//Weight of whole chessboard
		int[][] weight = new int[LENGTH][LENGTH];

		for (int i = 0; i < LENGTH; i++) 
		{
			for (int j = 0; j < LENGTH; j++)
			{				
				//8 directions of next step
				CountScore c = new CountScore();
				
				code = c.countR(i, j);
				value = map.get(code);
				if (value != null) 
				{
					weight[i][j] += value;
				}
				code = c.countL(i, j);
				value = map.get(code);
				if (value != null) 
				{
					weight[i][j] += value;
				}
				code = c.countU(i, j);
				value = map.get(code);
				if (value != null) 
				{
					weight[i][j] += value;
				}
				code = c.countD(i, j);
				value = map.get(code);
				if (value != null) 
				{
					weight[i][j] += value;
				}
				code = c.countRU(i, j);
				value = map.get(code);
				if (value != null) 
				{
					weight[i][j] += value;
				}
				code = c.countRD(i, j);
				value = map.get(code);
				if (value != null) 
				{
					weight[i][j] += value;
				}
				code = c.countLU(i, j);
				value = map.get(code);
				if (value != null) 
				{
					weight[i][j] += value;
				}
				code = c.countLD(i, j);
				value = map.get(code);
				if (value != null) 
				{
					weight[i][j] += value;
				}

			}
		} 
		//Get weight by traverse the chessboard
		return weight;
	}

	//Find latest and biggest weight as next step
	public int[] maxWeight(int[][] weight) 
	{
		int max = 0;
		int[] array = new int[2];
		for (int i = 0; i < weight.length; i++) 
		{
			for (int j = 0; j < weight[i].length; j++) 
			{
				if (max < weight[i][j]) 
				{
					max = weight[i][j];
					array[0] = i;
					array[1] = j;
				}
			}
		}
		return array;
	}

	//Judge win or lose, 1 represent yellow piece win and 2 represent black piece win
	public int win() 
	{
		//Judge columns
		for (int a = 2; a < LENGTH + 2; a++) 
		{
			for (int b = 2; b < LENGTH - 2; b++) 
			{
				if (chessArray[a - 2][b - 2] == 1 && chessArray[a - 2][b - 1] == 1 && chessArray[a - 2][b] == 1
						&& chessArray[a - 2][b + 1] == 1 && chessArray[a - 2][b + 2] == 1) 
				{
					//Black piece win
					flag = 0;
					return 1;
				}
				if (chessArray[a - 2][b - 2] == 2 && chessArray[a - 2][b - 1] == 2 && chessArray[a - 2][b] == 2
						&& chessArray[a - 2][b + 1] == 2 && chessArray[a - 2][b + 2] == 2) 
				{
					//Yellow piece win
					flag = 0;
					return 2;
				}
			}
		}

		//Judge rows
		for (int a = 2; a < LENGTH - 2; a++) 
		{
			for (int b = 2; b < LENGTH + 2; b++) 
			{
				if (chessArray[a - 2][b - 2] == 1 && chessArray[a - 1][b - 2] == 1 && chessArray[a][b - 2] == 1
						&& chessArray[a + 1][b - 2] == 1 && chessArray[a + 2][b - 2] == 1) 
				{
					//Black piece win
					flag = 0;
					return 1;
				}
				if (chessArray[a - 2][b - 2] == 2 && chessArray[a - 1][b - 2] == 2 && chessArray[a][b - 2] == 2
						&& chessArray[a + 1][b - 2] == 2 && chessArray[a + 2][b - 2] == 2) 
				{
					//Yellow piece win
					flag = 0;
					return 2;
				}
			}
		}
		//Judge diagonalLR
		for (int a = 2; a < LENGTH - 2; a++) 
		{
			for (int b = 2; b < LENGTH - 2; b++) 
			{
				if (chessArray[a - 2][b - 2] == 1 && chessArray[a - 1][b - 1] == 1 && chessArray[a][b] == 1
						&& chessArray[a + 1][b + 1] == 1 && chessArray[a + 2][b + 2] == 1) 
				{
					//Black piece win
					flag = 0;
					return 1;
				}
				if (chessArray[a - 2][b - 2] == 2 && chessArray[a - 1][b - 1] == 2 && chessArray[a][b] == 2
						&& chessArray[a + 1][b + 1] == 2 && chessArray[a + 2][b + 2] == 2) 
				{
					//Yellow piece win
					flag = 0;
					return 2;
				}
			}
		}
		//Judge diagonalRL
		for (int a = 2; a < LENGTH - 2; a++) 
		{
			for (int b = 2; b < LENGTH - 2; b++) 
			{
				if (chessArray[a + 2][b - 2] == 1 && chessArray[a + 1][b - 1] == 1 && chessArray[a][b] == 1
						&& chessArray[a - 1][b + 1] == 1 && chessArray[a - 2][b + 2] == 1) 
				{
					//Black piece win
					flag = 0;
					return 1;
				}
				if (chessArray[a + 2][b - 2] == 2 && chessArray[a + 1][b - 1] == 2 && chessArray[a][b] == 2
						&& chessArray[a - 1][b + 1] == 2 && chessArray[a - 2][b + 2] == 2) 
				{
					//Yellow piece win
					flag = 0;
					return 2;
				}
			}
		}
		return 0;
	}
	
}
