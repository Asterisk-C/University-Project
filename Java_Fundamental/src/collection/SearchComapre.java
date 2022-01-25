package collection;

import java.util.ArrayList;
import java.util.List;

public class SearchComapre 
{
	public static List<Hero> searchByMap(List<Hero> data)
	{
		long start = System.currentTimeMillis();
		
		long end = System.currentTimeMillis();
	}
	
	public static List<Hero> searchByFor(List<Hero> data)
	{
		long start = System.currentTimeMillis();
		
		long end = System.currentTimeMillis();
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<Hero> data = new ArrayList();
		for(int i = 0; i < 10; i++)
		{
			Hero h = new Hero();
			h.name = "hero-" + (int)(Math.random()*10000);
			data.add(h);
		}
		System.out.println(data);

	}

}
