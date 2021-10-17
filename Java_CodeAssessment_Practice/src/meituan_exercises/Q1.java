package meituan_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n-1];
		int[] b = new int[n-1];
		for(int i = 0; i < a.length; i++)
		{
			a[i] = sc.nextInt();
		}
		for(int i = 0; i < b.length; i++)
		{
			b[i] = sc.nextInt();
		}
		
		int[] result = new int[n];
		result[0] = 1;
		result[1] = a[0] * b[0];
		
		for(int i = 2; i < result.length; i++)
		{
			result[i] = a[i-1] * b[i-1] * result[b[i-1]-2];
		}
		
		for(int i: result)
		{
			System.out.print(i + " ");
		}
				
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
		
//		String s1 = sc.nextLine();
//		String[] ss1 = s1.split(" ");
//		int[] a = new int[ss1.length];
//		for(int i = 0; i < a.length; i++)
//		{
//			a[i] = Integer.parseInt(ss1[i]);
//		}
//		
//		String s2 = sc.nextLine();
//		String[] ss2 = s2.split(" ");
//		int[] b = new int[ss2.length];
//		for(int i = 0; i < a.length; i++)
//		{
//			a[i] = Integer.parseInt(ss2[i]);
//		}
//		
//		System.out.println(n);
//		for(int i: a)
//		{
//			System.out.print(i);
//		}
//		System.out.println();
//		for(int i: b)
//		{
//			System.out.print(i);
//		}
			
	}

}
