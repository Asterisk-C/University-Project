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
		System.out.printf("%s�ܳ�����%d����λ����%d�����ݣ�ȡ��������1���ٷŻ�ȥ%n �ظ�%d�飬�ܹ���ʱ %d ���� %n", type, total, index, total, end - start);
        System.out.println();
	}

}
