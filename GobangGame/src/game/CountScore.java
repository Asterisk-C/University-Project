package game;

public class CountScore implements Chessboard
{
	
	//Count consecutive pieces to right
	public String countR(int x, int y) 
	{
		String code = "";
		int chess = 0;
		if (chessArray[x][y] == 0) 
		{
			for (int i = x + 1; i < LENGTH; i++) 
			{
				if (chessArray[i][y] == 0) 
				{
					break;
				} 
				else if (chessArray[i][y] != 0) 
				{
					if (chess == 0)
					{
						code = code + chessArray[i][y];
						chess = chessArray[i][y];
					}
					else if (chess == chessArray[i][y]) 
					{
						//If the color is as same as the previous one, continue recording score
						code = code + chessArray[i][y];
					} 
					else 
					{
						//If the color is different, stop recording score
						code = code + chessArray[i][y];
						break;
					}
				}
			}
		}
		return code;
	}
	
	//Count consecutive pieces to left
	public String countL(int x, int y) 
	{
		String code = "";
		int chess = 0;
		if (chessArray[x][y] == 0)
		{
			for (int i = x - 1; i > 0; i--)
			{
				if (chessArray[i][y] == 0) 
				{
					break;
				} 
				else 
				{
					if (chess == 0) 
					{
						code = code + chessArray[i][y];
						chess = chessArray[i][y];
					} 
					else if (chess == chessArray[i][y]) 
					{
						//If the color is as same as the previous one, continue recording score
						code = code + chessArray[i][y];
					} 
					else 
					{
						//If the color is different, stop recording score
						code = code + chessArray[i][y];
						break;
					}
				}
			}
		}
		return code;
	}
	
	//Count consecutive pieces to up
	public String countU(int x, int y) 
	{
		String code = "";
		int chess = 0;
		if (chessArray[x][y] == 0) 
		{
			for (int i = y + 1; i < LENGTH; i++) 
			{
				if (chessArray[x][i] == 0) 
				{
					break;
				} 
				else 
				{
					if (chess == 0) 
					{
						code = code + chessArray[x][i];
						chess = chessArray[x][i];
					} 
					else if (chess == chessArray[x][i]) 
					{
						//If the color is as same as the previous one, continue recording score
						code = code + chessArray[x][i];
					} 
					else 
					{
						//If the color is different, stop recording score
						code = code + chessArray[x][i];
						break;
					}
				}
			}
		}
		return code;
	}
	
	//Count consecutive pieces to down
	public String countD(int x, int y) 
	{
		String code = "";
		int chess = 0;
		if (chessArray[x][y] == 0) 
		{
			for (int i = y - 1; i > 0; i--) 
			{
				if (chessArray[x][i] == 0)
				{
					break;
				} 
				else 
				{
					if (chess == 0) 
					{
						code = code + chessArray[x][i];
						chess = chessArray[x][i];
					} 
					else if (chess == chessArray[x][i]) 
					{
						//If the color is as same as the previous one, continue recording score
						code = code + chessArray[x][i];
					} 
					else 
					{
						//If the color is different, stop recording score
						code = code + chessArray[x][i];
						break;
					}
				}
			}
		}

		return code;
	}
	
	//Count consecutive pieces to bottom right
	public String countRD(int x, int y) 
	{
		String code = "";
		int chess = 0;
		if (chessArray[x][y] == 0) 
		{
			for (int i = 1; i < 100; i++) 
			{
				if (x + i < LENGTH && y + i < LENGTH)
				{
					if (chessArray[x + i][y + i] == 0) 
					{
						break;
					} 
					else 
					{
						if (chess == 0) 
						{
							code = code + chessArray[x + i][y + i];
							chess = chessArray[x + i][y + i];
						} 
						else if (chess == chessArray[x + i][y + i]) 
						{
							//If the color is as same as the previous one, continue recording score
							code = code + chessArray[x + i][y + i];
						} 
						else 
						{
							//If the color is different, stop recording score
							code = code + chessArray[x + i][y + i];
							break;
						}
					}
				}
			}
		}

		return code;
	}
	
	//Count consecutive pieces to upper right
	public String countRU(int x, int y)
	{
		String code = "";
		int chess = 0;
		if (chessArray[x][y] == 0) 
		{
			for (int i = x + 1, j = y - 1; i < LENGTH && j > 0; i++, j--) 
			{

				if (chessArray[i][j] == 0) 
				{
					break;
				} 
				else 
				{
					if (chess == 0) 
					{
						code = code + chessArray[i][j];
						chess = chessArray[i][j];
					} 
					else if (chess == chessArray[i][j]) 
					{
						//If the color is as same as the previous one, continue recording score
						code = code + chessArray[i][j];
					} 
					else 
					{
						//If the color is different, stop recording score
						code = code + chessArray[i][j];
						break;
					}
				}
			}
		}

		return code;
	}

	//Count consecutive pieces to upper left
	public String countLU(int x, int y) 
	{
		String code = "";
		int chess = 0;
		if (chessArray[x][y] == 0) 
		{
			for (int i = x - 1, j = y - 1; i > 0 && j > 0; i--, j--) 
			{
				if (chessArray[i][j] == 0) 
				{
					break;
				} 
				else 
				{
					if (chess == 0) 
					{
						code = code + chessArray[i][j];
						chess = chessArray[i][j];
					} 
					else if 
					(chess == chessArray[i][j]) 
					{
						//If the color is as same as the previous one, continue recording score
						code = code + chessArray[i][j];
					}
					else 
					{
						//If the color is different, stop recording score
						code = code + chessArray[i][j];
						break;
					}
				}
			}
		}
		return code;
	}	
	
	//Count consecutive pieces to bottom left
	public String countLD(int x, int y) 
	{
		String code = "";
		int chess = 0;
		if (chessArray[x][y] == 0) 
		{
			for (int i = x - 1, j = y + 1; i > 0 && j < LENGTH; i--, j++) 
			{
				if (chessArray[i][j] == 0) 
				{
					break;
				} 
				else 
				{
					if (chess == 0) 
					{
						code = code + chessArray[i][j];
						chess = chessArray[i][j];
					} 
					else if (chess == chessArray[i][j]) 
					{
						//If the color is as same as the previous one, continue recording score
						code = code + chessArray[i][j];
					} 
					else 
					{
						//If the color is different, stop recording score
						code = code + chessArray[i][j];
						break;
					}
				}
			}
		}
		return code;
	}
			
}
