package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MergeTwoSortedArrays 
{
	// Method 1: O(1) Extra Space
	// Extra space is not allowed and doesn¡¯t look possible in less than O(m*n) worst case time. 
	public static void merge1(int arr1[], int arr2[])
	{
		int m = arr1.length - 1;
		int n = arr2.length - 1;
		
		for(int i = n; i >= 0; i--)
		{
			int j;
			int last = arr1[m];
			
			for(j = m - 1; j >= 0 && arr1[j] > arr2[i]; j--)
			{			
				arr1[j + 1] = arr1[j];		
			}
			
			// If there was a greater element
			if(j != m - 1 || last > arr2[i])
			{
				arr1[j + 1] = arr2[i];		
				arr2[i] = last;
			}
			
		}
	}
	
//	Method 2: (O(n1 * n2) Time and O(n1+n2) Extra Space) 
//	1. Create an array arr3[] of size n1 + n2.
//	2. Copy all n1 elements of arr1[] to arr3[].
//	3. Traverse arr2[] and one by one insert elements (like insertion sort) of arr3[] to arr1[]. This step take O(n1 * n2) time.
	public static int[] merge2(int arr1[], int arr2[])
	{
		int m = arr1.length;
		int n = arr2.length;		
		int[] arr3 = new int[m + n];
		System.arraycopy(arr1, 0, arr3, 0, m);
		
		for(int i = 0; i < n; i++)
		{
			int j = m - 1 + i;
			for(j = m - 1 + i; j >= 0 && arr3[j] > arr2[i]; j--)
			{
				arr3[j + 1] = arr3[j];
			}
			arr3[j + 1] = arr2[i];
			
		}
		return arr3;
	}
	
//	Method 3: Using Maps (O(nlog(n) + mlog(m)) Time and O(N) Extra Space) 
//
//	Insert elements of both arrays in a map as keys.
//	Print the keys of the map.

	public static void printMerge3(int arr1[], int arr2[])
	{
		Map<Integer, Boolean> mp = new HashMap<>();
		for(int i = 0; i < arr1.length; i++)
		{
			mp.put(arr1[i], true);
		}
		for(int j = 0; j < arr2.length; j++)
		{
			mp.put(arr2[j], true);
		}
		
		for(Map.Entry<Integer, Boolean> entry: mp.entrySet())
		{
			System.out.print(entry.getKey() + " ");
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] arr1 = {1, 5, 9, 10, 15, 20};
		int[] arr2 = {2, 3, 8, 13};
		
//		merge1(arr1, arr2);
//		System.out.print(Arrays.toString(arr1) + " and " + Arrays.toString(arr2));
//		System.out.println();
		
//		System.out.println(Arrays.toString(merge2(arr1, arr2)));
		
		printMerge3(arr1, arr2);

	}

}
