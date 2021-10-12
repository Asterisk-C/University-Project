package hw_exercises;

import java.util.Scanner;

public class Q6 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number, value, sum;
		number = sc.nextInt();
		value = sc.nextInt();
		sum = sc.nextInt();
		
		int[] presents = new int[sum+1];
		for(int i = 0; i < sum; i++)
		{
			presents[i] = sc.nextInt();
		}
		int[][] table = new int[number+1][value+1];
		table[0][0] = 1;
		
		for(int i = 0; i < sum; i++)
		{
			for(int column = number; column > 0; column--)
			{
				for(int row = value; row >= presents[i]; row--)
				{
					table[column][row] += table[column-1][row-presents[i]];
				}
			}
		}
		System.out.println(table[number][value]);		
	}

}
