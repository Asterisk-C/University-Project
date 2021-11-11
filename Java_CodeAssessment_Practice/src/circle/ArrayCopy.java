package circle;

import java.util.Arrays;

public class ArrayCopy 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] a1 = new int[9];
		int[][] a2 = new int[][] {
			{1, 2, 3, 8, 8, 8},
			{4, 5, 6, 8, 8, 8},
			{7, 8, 9, 8, 8, 8}
		};
//		copyArray_For(a2, a1);	
		
		
		
		int[][] a3 = new int[3][3];	
//		System.out.print(a3.length);	
		
		copyArray_arraycopy(a2, a3);
//		copyArray_copyOf(a2, a3);
		for(int i = 0; i < a3.length; i++)
		{
			for(int j = 0; j < a3[i].length; j++)
			{
				System.out.print(a3[i][j] + " ");
			}
			System.out.println();
		}
		
		// Print method 1
//		for(int i = 0; i < a1.length; i++)
//		{
//			System.out.print(a1[i] + " ");
//		}
		
		// Print method 2
//		for(int i: a1)
//		{
//			System.out.print(i + " ");
//		}
		
		// Print method 3
//		System.out.print(Arrays.toString(a1));
		
	}
	
	public static void copyArray_For(int[][] src, int[] dest)
	{
		dest[0] = src[0][0];
		dest[1] = src[0][1];
		dest[2] = src[0][2];
		dest[3] = src[1][0];
		dest[4] = src[1][1];
		dest[5] = src[1][2];
		dest[6] = src[2][0];
		dest[7] = src[2][1];
		dest[8] = src[2][2];
	}
	
	public static void copyArray_arraycopy(int[][] src, int[][] dest)
	{
		for(int i = 0; i < src.length; i++)
		{
			System.arraycopy(src[i], 0, dest[i], 0, dest[i].length);
		}	
	}
	
	public static void copyArray_copyOf(int[][] src, int[][] dest)
	{
		for(int i = 0; i < src.length; i++)
		{
			dest[i] = Arrays.copyOf(src[i], src[i].length);
		}
		
	}

}
