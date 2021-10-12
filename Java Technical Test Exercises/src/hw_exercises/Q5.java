package hw_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Q5 
{
	public int maxProfit(int[] value, int[] time, int[] deadline)
	{
		//Order the value
		//Complete tasks one by one following the order
		//Once completed one task, search another task which has max value
		int profit = 0;
		return profit;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		int[] value = new int[number];
		int[] time = new int[number];
		int[] deadline = new int[number];
		
		for(int i = 0; i < number; i++)
		{
			value[i] = sc.nextInt();
		}
		for(int i = 0; i < number; i++)
		{
			time[i] = sc.nextInt();
		}
		for(int i = 0; i < number; i++)
		{
			deadline[i] = sc.nextInt();
		}
		
		Q5 test = new Q5();
		System.out.println(test.maxProfit(value, time, deadline));
//		System.out.println(Arrays.toString(value));
//		System.out.println(Arrays.toString(time));
//		System.out.println(Arrays.toString(deadline));
	}

}
