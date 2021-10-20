package sort;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort 
{
	public static void selectionSort(int[] arr)
	{
		int tmp;
		
		for(int i = 0; i < arr.length - 1; i++)
		{
			int minIndex = i;
			for(int j = i; j < arr.length; j++)
			{
				if(arr[j] < arr[minIndex])
				{
					minIndex = j;
				}
			}
			tmp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = tmp;
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    int[] n = new int[5];
	    for (int i = 0; i < n.length; i++) 
	    {
	        System.out.print("������� " + (i + 1) + " ��������");
	        n[i] = sc.nextInt();
	    }
	    
	    System.out.println("����ǰ��Ԫ��ֵ��");
	    for(int i: n) {
	        System.out.print(i + " ");
	    }
	    System.out.println();
		
	    System.out.println("������Ԫ��ֵ��");
	    selectionSort(n);
	    System.out.println(Arrays.toString(n));

	}

}
