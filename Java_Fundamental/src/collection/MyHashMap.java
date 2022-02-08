package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap implements IHashMap
{
	List<Entry>[] array = new LinkedList[2000];
	
	@Override
	public void put(String key, Object value)
	{
		int hashcode = hashcode(key);
		List<Entry> list = array[hashcode];
		
		if(list == null)
		{
			list = new LinkedList();
			array[hashcode] = list;
		}
		
		boolean found = false;
		for(Entry e: list)
		{
			if(e.key.equals(key))
			{
				e.value = value;
				found = true;
				break;
			}	
		}
		if(found == false)
		{
			list.add(new Entry(key, value));
		}
		
	}
	
	public Object get(String key)
	{
		int hashcode = hashcode(key);
		List<Entry> list = array[hashcode];
		
		if(list == null)
			return null;
		else
		{
			for(Entry e: list)
			{
				if(e.key.equals(key))
					return e.value;
			}
			return null;
		}
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
		
//		System.out.println(sum);
		
		return sum;
	}
	
	public String toString()
	{
		LinkedList<Entry> result = new LinkedList();
		
		for(List<Entry> ll: array)
		{
			if(ll == null)
				continue;
			result.addAll(ll);
		}
		return result.toString();
	}
	
	public int randomNumber()
	{
		return (int)(Math.random() * 9000 + 1000);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MyHashMap mhm = new MyHashMap();
//		mhm.put("Paul", "PG");
//		mhm.put("Booker", "SG");
//		mhm.put("Ayton", "C");
//
//		System.out.println(mhm.get("Booker"));
//		System.out.println(mhm);
//		
//		mhm.put("Booker", "SF");
//		System.out.println(mhm.get("Booker"));
		
//		int i = mhm.randomNumber();
//		System.out.println(i);
		
		List<Hero> heros = new ArrayList();
		for(int i = 0; i < 100000; i++)
		{
			Hero h = new Hero("hero-" + mhm.randomNumber());
            heros.add(h);
		}
		
		MyHashMap heroMap = new MyHashMap();
		for(Hero h: heros)
		{
			List<Hero> list = (List<Hero>) heroMap.get(h.name);
			if(list == null)
			{
				list = new LinkedList();
				heroMap.put(h.name, list);
			}
			list.add(h);	
		}
		
		// Search by for
		long start1 = System.currentTimeMillis();
		List<Hero> result1 = new ArrayList();
		for(Hero h: heros)
		{
			if(h.name.equals("hero-5555"))
			{
				result1.add(h);
			}
		}
		long end1 = System.currentTimeMillis();
		System.out.printf("Got %d heros by For Loop, used %d millisecond.%n", result1.size(), end1 - start1);
		
		// Search by MyHashMap
		long start2 = System.currentTimeMillis();
		List<Hero> result2 = (List<Hero>) heroMap.get("hero-5555");
		long end2 = System.currentTimeMillis();
		System.out.printf("Got %d heros by MyHashMap, used %d millisecond.%n", result2.size(), end2 - start2);

	}

}
