package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortCompare 
{
	interface Sort
	{
		void sort();
		int[] result();
	}
	
	static class SelectionSort implements Sort
	{
		int[] numbers;
		public SelectionSort(int[] numbers)
		{
			this.numbers = numbers;
		}
		
		@Override
		public void sort()
		{
			for(int i = 0; i < numbers.length - 1; i++)
			{
				for(int j = i + 1; j < numbers.length; j++)
				{
					if(numbers[j] < numbers[i])
					{
						int temp = numbers[i];
						numbers[i] = numbers[j];
						numbers[j] = temp;
					}
				}			
			}
		}
		
		@Override
		public int[] result()
		{
			return numbers;
		}
	}
	
	static class BubbleSort implements Sort
	{
		int[] numbers;
		public BubbleSort(int[] numbers)
		{
			this.numbers = numbers;
		}
		
		@Override
		public void sort()
		{
			for(int i = 0; i < numbers.length - 1; i++)
			{
				for(int j = 0; j < numbers.length - i - 1; j++)
				{
					if(numbers[j] < numbers[j + 1])
					{
						int temp = numbers[j];
						numbers[j] = numbers[j + 1];
						numbers[j + 1] = temp;
					}
				}			
			}
		}
		
		@Override
		public int[] result()
		{
			return numbers;
		}
	}
	
	static class TreeSort implements Sort
	{
		int[] numbers;
		Node n;
		
		public TreeSort(int[] numbers)
		{
			this.numbers = numbers;
			n = new Node();
		}
		
		@Override
		public void sort()
		{
			for(int i: numbers)
			{
				n.add(i);
			}
		}
		
		@Override
		public int[] result()
		{
			List<Object> values = n.traverseValue();
			int[] results = new int[values.size()];
			for(int i = 0; i < results.length; i++)
			{
				results[i] = Integer.parseInt(values.get(i).toString());
			}
			return results;
		}
	}
	
	private static int[] performance(Sort algorithm, String type)
	{
		long start = System.currentTimeMillis();
		algorithm.sort();
		int[] results = algorithm.result();
		long end = System.currentTimeMillis();
		System.out.printf("%s algorithm, used %d millisecond%n", type, end - start);
		return results;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] numbers = new int[4000];
		for(int i = 0; i < numbers.length; i++)
		{
			numbers[i] = (int)(Math.random()*10000);
			System.out.print(numbers[i] + " ");
		}
		System.out.println("初始化完毕");
		
		int[] test;
		
		test = Arrays.copyOf(numbers, numbers.length);
		int[] resultBySelectionSort = performance(new SelectionSort(test), "SelectionSort");
		
		test = Arrays.copyOf(numbers, numbers.length);
		int[] resultByBubbleSort = performance(new BubbleSort(test), "BubbleSort");
		
		test = Arrays.copyOf(numbers, numbers.length);
		int[] resultByTreeSort = performance(new TreeSort(test), "TreeSort");
		
		System.out.println("查看排序结果，是否是不同的数组对象");
        System.out.println(resultBySelectionSort);
        System.out.println(resultByBubbleSort);
        System.out.println(resultByTreeSort);
        
		System.out.println("查看排序结果，内容是否相同");
        System.out.println("比较 选择法 和 冒泡法  排序结果：");
        System.out.println(Arrays.equals(resultBySelectionSort, resultByBubbleSort));
        System.out.println("比较 选择法 和 二叉树  排序结果：");
        System.out.println(Arrays.equals(resultBySelectionSort, resultByTreeSort));

	}

}
