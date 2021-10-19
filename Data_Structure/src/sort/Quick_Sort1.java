package sort;

public class Quick_Sort1 
{
	public static void quickSort(int[] arr, int low, int high)
	{
		int pivot = (low + high) / 2;
		int i = low;
		int j = high;
		int tmp;
		
		while(i <= j)
		{
			while(arr[i] < arr[pivot])
			{
				i++;
			}
			while(arr[j] > arr[pivot])
			{
				j--;
			}
			
			if(i <= j)
			{
				if(i != j)
				{
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;		
				}
				i++;
				j--;
			}
					
		}
			
		if(low < j)
			quickSort(arr, low, j);
		if(high > i)
			quickSort(arr, i, high);
    
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr = new int[]{5, 9, 1, 9, 5, 3, 7, 6, 1};
		quickSort(arr, 0, arr.length - 1);
		for(int i: arr)
		{
			System.out.print(i + " ");
		}

	}

}
