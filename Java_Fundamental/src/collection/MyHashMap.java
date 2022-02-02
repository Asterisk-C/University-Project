package collection;

import java.util.LinkedList;
import java.util.List;

public class MyHashMap implements IHashMap
{
	List<Entry>[] array = new LinkedList[2000];
	
	public void put(String key, Object value)
	{
		int hashcode = hashcode(key);
		List<Entry> list = array[hashcode];
		
		if(list == null)
		{
			list = new LinkedList();
			array[hashcode] = list;
		}
		else
		{
			list.add(new Entry(key, value));
		}
	}
	
	public Object get(String key)
	{
		
	}
	
	public static int hashcode(String s)
	{
		
		if(s.length() == 0)
			return 0;
		
		int sum = 0;
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length; i++)
		{
			sum += (int)c[i];
		}
		sum *= 23;
				
		sum = sum % 2000;
		
		sum = sum < 0 ? 0 - sum: sum;
		
		System.out.println(sum);
		
		return sum;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
