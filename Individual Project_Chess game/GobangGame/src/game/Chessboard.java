package game;

//This is an interface which contains key features in chessboard, using lots of constants. 
public interface Chessboard 
{
	//The chessboard is square, set the initial length(both rows and columns) of the chessboard
	public final static int LENGTH = 25;	
	
	//Inital position(x,y) to draw the chessboard
	public final static int X_START = 30;	

	public final static int Y_START = 30;	

	//The distance between each line
	public final static int SPACE = 40;	
	
	//The size of the piece
	public final static int PIECE_SIZE = 30;
	
	/*
	 * Using a Two-dimensional array to record information of the chessboard
	 * The different values meanings:
	 * 1: yellow piece
	 * 2: white piece
	 * 0: empty position
	*/
	public final static int[][] chessArray = new int[LENGTH][LENGTH];
}
