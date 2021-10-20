package sort;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort 
{
	public static void bubbleSort1(int[] arr)
	{
		int i, j, tmp;
		
		for(i = arr.length - 1; i > 0; i--)
		{
			for(j = 0; j < i; j++)
			{
				if(arr[j] > arr[j+1])
				{
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}			
			}
		}
	}
	
	public static void bubbleSort2(int[] arr)
	{
		int i, j, tmp;
		
		for(i = 0; i < arr.length - 1; i++)
		{
			for(j = 0; j < arr.length - 1 - i; j++)
			{
				if(arr[j] > arr[j+1])
				{
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}			
			}
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    int[] n = new int[5];
	    for (int i = 0; i < n.length; i++) 
	    {
	        System.out.print("请输入第 " + (i + 1) + " 个整数：");
	        n[i] = sc.nextInt();
	    }
	    
	    System.out.println("排序前的元素值：");
	    for(int i: n) {
	        System.out.print(i + " ");
	    }
	    System.out.println();
		
	    System.out.println("排序后的元素值：");
	    bubbleSort2(n);
	    System.out.println(Arrays.toString(n));
	}

}
