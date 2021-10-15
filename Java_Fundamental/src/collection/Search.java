package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Search 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<Integer> list;
		
		list = new ArrayList<>();
		modify(list, "ArrayList");
		
		list = new LinkedList<>();
		modify(list, "LinkedList");
	}
	
	private static void modify(List<Integer> list, String type)
	{
		int total = 1000 * 100;
		int index = total / 2;
		final int number = 5;
		
		for(int i = 0; i < total; i++)
		{
			list.add(0, number);
		}
		
		long start = System.currentTimeMillis();
		
		for(int i = 0; i < total; i++)
		{
			int n = list.get(index);
			n++;
			list.set(index, n);
		}
		
		long end = System.currentTimeMillis();
		System.out.printf("%s总长度是%d，定位到第%d个数据，取出来，加1，再放回去%n 重复%d遍，总共耗时 %d 毫秒 %n", type, total, index, total, end - start);
        System.out.println();
	}

}
