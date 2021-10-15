package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import collection.Hero;

public class TestArrayList 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<Hero> test = new ArrayList<Hero>();
		
		// Put 5 Hero into ArrayList
		for(int i = 0; i < 100; i++)
		{
			test.add(new Hero("hero " + i));
		}
		
		// Search if there is an object which name equals to "hero 1"
		
		String name = "hero 1";
		for(int i = 0; i < test.size(); i++)
		{
			Hero h = (Hero) test.get(i);
			
			if(name.equals(h.name ) )
			{
                System.out.printf("找到了name是%s的对象%n", name);
                break;
            }	
		}
		
		// Method 1: for循环
		for(int i = 0; i < test.size(); i++)
		{
			System.out.print(test.get(i) + " ");
		}
		System.out.println();
		
		// Method 2: Iterator
		Iterator<Hero> it = test.iterator();
		while(it.hasNext())
		{
			Hero h = it.next();
			System.out.print(h + " ");
		}
		System.out.println();
		
		// Method 3: 增强型for循环
		for(Hero h: test)
		{
			System.out.print(h + " ");
		}
		System.out.println();
		
		// Delete
		List<Hero> temp = new ArrayList<Hero>();
		for(int i = 0; i < 100; i++)
		{
			if(i % 8 == 0)
				temp.add(test.get(i));
		}
		for(Hero h: temp)
		{
			test.remove(h);
		}
		System.out.println(test);
	}

}
