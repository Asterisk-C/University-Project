/*
首先创建一个长度是5的数组,并填充随机数

首先用选择法正排序，然后再对其使用冒泡法倒排序

注 所谓的正排序就是从小到大排序，倒排序就是从大到小排序
 */
import java.util.Arrays;

public class ArraySort 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] a = new int[5];
		a[0] = 8;
		a[1] = (int)(Math.random() * 100);
		a[2] = (int)(Math.random() * 100);
		a[3] = (int)(Math.random() * 100);
		a[4] = (int)(Math.random() * 100);
		
		int[] a1 = a;
//		int[] a2 = a;
		int[] a2 = new int[5];
		System.arraycopy(a, 0, a2, 0, 5);
		int[] a3 = a;
		
		ArraySort array = new ArraySort();		
		System.out.println("a: " + Arrays.toString(a));
		//selectiveSort
		array.selectiveSort(a1);
		System.out.println("a1: " + Arrays.toString(a1));
		//bubbleSort
		array.bubbleSort(a2);
		System.out.println("a2: " + Arrays.toString(a2));
		//sort()
		array.autoSort(a3);
		System.out.println("a3: " + Arrays.toString(a3));
		//binarySearch
		System.out.println("数字8出现的位置:" + Arrays.binarySearch(a3, 8));
		//equals()
		System.out.println(Arrays.equals(a, a1));
	}
	
	public void selectiveSort(int[] s)
	{
		for(int i = 0; i < s.length - 1; i++)
		{
			for(int j = i + 1; j < s.length; j++)
			{
				if(s[j] < s[i])
				{
					int temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}			
		}
	}
	
	public void bubbleSort(int[] b)
	{
		for(int i = 0; i < b.length - 1; i++)
		{
			for(int j = 0; j < b.length - i - 1; j++)
			{
				if(b[j] < b[j + 1])
				{
					int temp = b[j];
					b[j] = b[j + 1];
					b[j + 1] = temp;
				}
			}			
		}
	}
	
	public void autoSort(int[] a)
	{
		Arrays.sort(a);
	}

}
