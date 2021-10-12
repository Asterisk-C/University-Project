package mi_exercises;

import java.util.*;

public class Q2 
{

	public static void main(String[] args) 
	{
		int[] source = new int[10];
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < source.length; i++)
		{
			source[i] = sc.nextInt();
		}

		
		int countOne = 0; 
		int countTwo = 0;
		int countThree = 0;
		for(int i = 0; i < source.length; i++)
		{
			if(source[i] == 1)
				countOne++;
			if(source[i] == 2)
				countTwo++;
			if(source[i] == 3)
				countThree++;
		}
		
		int[] result = new int[10];
		for(int i = 0; i < countOne; i++)
		{
			result[i] = 1;
		}
		for(int i = countOne; i < countOne+countTwo; i++)
		{
			result[i] = 2;
		}
		for(int i = countOne+countTwo; i < result.length; i++)
		{
			result[i] = 3;
		}
		
		for(int n : result)
		{
			System.out.print(n + " ");
		}
		
	}

}
