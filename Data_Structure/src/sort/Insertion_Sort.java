package sort;

import java.util.Arrays;
import java.util.Scanner;

public class Insertion_Sort 
{
	public static void insertionSort(int[] arr)
	{
		for(int i = 1; i < arr.length; i++)
		{
			int key = arr[i];
			int j = i - 1;
			
			while(j >= 0 && key < arr[j])
			{
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
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
	    insertionSort(n);
	    System.out.println(Arrays.toString(n));

	}

}
