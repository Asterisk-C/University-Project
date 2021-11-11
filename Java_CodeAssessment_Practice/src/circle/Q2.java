package circle;

import java.util.HashSet;

public class Q2 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[][] src = new int[][] {
			{1, 2, 3, 4, 8, 6},
			{4, 5, 6, 1, 5, 9},
			{7, 8, 9, 7, 2, 3}
		};

		int[][] dest = new int[3][3];	
		boolean[] judgement = new boolean[src[0].length - 2];
		
		for(int n = 0; n < src[0].length - 2; n++)
		{
			// Copy
			for(int i = 0; i < src.length; i++)
			{
				System.arraycopy(src[i], n, dest[i], 0, dest[i].length);
			}
//			// Print
//			for(int i = 0; i < dest.length; i++)
//			{
//				for(int j = 0; j < dest[i].length; j++)
//				{
//					System.out.print(dest[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			HashSet<Integer> hs = new HashSet<>();
			for(int i = 0; i < dest.length; i++)
			{
				for(int j = 0; j < dest[i].length; j++)
				{
					hs.add(dest[i][j]);
				}			
			}
			
			if(hs.size() == dest.length * dest[0].length)
				judgement[n] = true;
			else
				judgement[n] = false;
		}
		
		for(boolean i: judgement)
		{
			System.out.print(i + " ");
		}

	}

}
