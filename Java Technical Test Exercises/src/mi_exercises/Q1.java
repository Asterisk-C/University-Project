package mi_exercises;

import java.util.*;

public class Q1 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int m = s1.length();
		int n = s2.length();
		
		int[][] table = new int[m+1][n+1];

		for(int i = 1; i <= m; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				if(c1[i-1] == c2[j-1])
				{
					table[i][j] = table[i-1][j-1] + 1;
				}
				else
				{
					table[i][j] = Math.max(table[i-1][j], table[i][j-1]);
				}
//				System.out.print(table[i][j] + " ");
			}
//			System.out.println();
		}
		
		
		if(table[m][n] == 0)
		{
			System.out.print(0);
		}
		else
		{
			System.out.print(table[m][n]);
		}

	}

}
