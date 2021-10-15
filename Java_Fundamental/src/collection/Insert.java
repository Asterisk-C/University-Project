package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Insert 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<Integer> list;
		
		list = new ArrayList<>();
		insertFirst(list, "ArrayList");
		
		list = new LinkedList<>();
		insertFirst(list, "LinkedList");
		
		insertLast(list, "ArrayList");
		insertLast(list, "LinkedList");
		
		insertMiddle(list, "ArrayList");
		insertMiddle(list, "LinkedList");
	}
	
	private static void insertFirst(List<Integer> list, String type)
	{
		int total = 1000 * 100;
		final int number = 5;
		long start = System.currentTimeMillis();
		for(int i = 0; i < total; i++)
		{
			list.add(0, number);
		}
		long end = System.currentTimeMillis();
		System.out.printf("在%s最前面插入%d条数据，总共耗时%d毫秒%n", type, total, end - start);
	}
	
	private static void insertLast(List<Integer> list, String type)
	{
		int total = 1000 * 100;
		final int number = 5;
		long start = System.currentTimeMillis();
		for(int i = 0; i < total; i++)
		{
			list.add(number);
		}
		long end = System.currentTimeMillis();
		System.out.printf("在%s最后面插入%d条数据，总共耗时%d毫秒%n", type, total, end - start);
	}
	
	private static void insertMiddle(List<Integer> list, String type)
	{
		int total = 1000 * 100;
		final int number = 5;
		long start = System.currentTimeMillis();
		for(int i = 0; i < total; i++)
		{
			list.add(list.size() / 2, number);
		}
		long end = System.currentTimeMillis();
		System.out.printf("在%s最中间插入%d条数据，总共耗时%d毫秒%n", type, total, end - start);
	}

}
