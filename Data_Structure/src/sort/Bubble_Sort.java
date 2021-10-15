package sort;

public class Bubble_Sort 
{
	public void bubbleSort(int[] array, int length)
	{
		int i, j, tmp;
		
		for(i = length - 1; i > 0; i--)
		{
			for(j = 0; j < i; j++)
			{
				if(array[j] > array[j+1])
				{
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}			
			}
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
	}

}
