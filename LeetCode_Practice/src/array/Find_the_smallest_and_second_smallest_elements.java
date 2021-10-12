package array;

public class Find_the_smallest_and_second_smallest_elements 
{
	public static void print2Smallest(int[] arr)
	{
		int first, second;
		first = second = Integer.MAX_VALUE;
		int arr_size = arr.length;
		
		if(arr_size < 2)
		{
			System.out.println("Invalid input.");
			return;
		}
		
		for(int i = 0; i < arr_size; i++)
		{
			if(arr[i] < first)
			{
				second = first;
				first = arr[i];			
			}
			else if(arr[i] < second && arr[i] != first)
			{
				second = arr[i];
			}
		}
		if(second == Integer.MAX_VALUE)
		{
			System.out.println(first);
		}
		else
		{
			System.out.println(first + " " + second);
		}
		
	}
	
	public static void bubbleSort(int[] arr)
	{
		
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = {12, 13, 1, 10, 34, 1};
		print2Smallest(arr);
	}

}
