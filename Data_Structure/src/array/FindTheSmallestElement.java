package array;
//Write an efficient program to find smallest and second smallest element in an array.

public class FindTheSmallestElement 
{
	public static void print2Smallest(int arr[])
	{
		int smallest = Integer.MAX_VALUE;
		int second_smallest = Integer.MAX_VALUE;
		
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] < smallest)	
			{
				second_smallest = smallest;
				smallest = arr[i];				
			}
			else if(arr[i] != smallest && arr[i] < second_smallest)
			{
				second_smallest = arr[i];	
			}
		}	
		
		if (second_smallest == Integer.MAX_VALUE)
            System.out.println("There is no second smallest element");
		else
			System.out.println(smallest + " and " + second_smallest);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int arr[] = {8, 2, 4, 3, 9, 9, 0};
		print2Smallest(arr);

	}

}
