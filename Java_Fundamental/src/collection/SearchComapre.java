package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchComapre 
{
	private static List<Hero> searchByMap(HashMap<String, List<Hero>> m)
	{
		long start = System.currentTimeMillis();
		List<Hero> results = m.get("hero-5555");
		long end = System.currentTimeMillis();
		System.out.printf("Got %d heros by hashmap, used %d millisecond.", results.size(), end - start);
		return results;
	}
	
	private static List<Hero> searchByFor(List<Hero> data)
	{
		long start = System.currentTimeMillis();
		List<Hero> results = new ArrayList();
		for(Hero h: data)
		{
			if(h.name.equals("hero-5555"))
				results.add(h);
		}
		long end = System.currentTimeMillis();
		System.out.printf("Got %d heros by for-loop, used %d millisecond.", results.size(), end - start);
		return results;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<Hero> data = new ArrayList();
		for(int i = 0; i < 100000; i++)
		{
			Hero h = new Hero();
			h.name = "hero-" + (int)(Math.random()*9000 + 1000);
			data.add(h);
		}
		System.out.println(data);
		
		HashMap<String, List<Hero>> hm = new HashMap();
		for(Hero h: data)
		{
			List<Hero> temp = hm.get(h.name);
			if(temp == null)
			{
				temp = new ArrayList();
				hm.put(h.name, temp);
			}
			temp.add(h);
		}
		
		System.out.println("Start Searching");
		searchByMap(hm);
		searchByFor(data);

	}

}
