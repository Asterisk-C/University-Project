package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TestComparator 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// Hero
		Random r = new Random();
		List<Hero> heros = new ArrayList();
		
		for(int i = 0; i < 10; i++)
		{
			heros.add(new Hero("hero " + i, r.nextInt(100), r.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
        System.out.println(heros);
        
//        Collections.sort(heros);
        
//        Comparator<Hero> c = new Comparator<Hero>()
//        {
//        	@Override
//        	public int compare(Hero h1, Hero h2)
//        	{
//        		// order by hp
//        		if(h1.hp > h2.hp)
//        			return 1;
//        		else
//        			return -1;
//        	}
//        };
//        Collections.sort(heros, c);
//        System.out.println("按照血量排序后的集合：");
//        System.out.println(heros);
        
        Collections.sort(heros);
        System.out.println("按照伤害高低排序后的集合");
        System.out.println(heros);
        
        // Item
        Random r2 = new Random();
		List<Item> items = new ArrayList();
		
		for(int i = 0; i < 10; i++)
		{
			items.add(new Item("item " + i, r2.nextInt(100)));
		}
		System.out.println("初始化后的集合：");
        System.out.println(items);
        
        Collections.sort(items);
        System.out.println("按照价格高低排序后的集合");
        System.out.println(items);

	}

}
