package array;
// Find the first non-repeating element in a given array of integers.

import java.util.HashMap;

public class NonRepeatingElement 
{
	// Simple solution
	public static int nRE1(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = 0; j < arr.length; j++)
			{
				if(arr[i] == arr[j] && i != j)
					break;
				if(j == arr.length - 1)
					return arr[i];
			}
		}
		return -1;
	}
	
	// Efficient solution		
	public static int nRE2(int[] arr)
	{
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < arr.length; i++)
		{
			int count = 1;
			if(hm.containsKey(arr[i]))
				hm.put(arr[i], hm.get(arr[i]) + 1);
			else
				hm.put(arr[i], count);
		}
		
		for(int j = 0; j < arr.length; j++)
		{
			if(hm.get(arr[j]) == 1)
				return arr[j];
		}
		
		return -1;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int arr[] = {9, 4, 9, 6, 7, 4, 0};
		System.out.println(nRE2(arr));
	}

}
