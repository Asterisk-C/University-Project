package collection;

import java.util.ArrayList;
import java.util.List;

public class HeroNode 
{
	public HeroNode leftNode;
	public HeroNode rightNode;
	public Hero value;
	
	public void add(Hero v)
	{
		if(value == null)
			value = v;
		else
		{
			if(v.hp > value.hp)
			{
				if(rightNode == null)
					rightNode = new HeroNode();
				rightNode.add(v);
			}
			else
			{
				if(leftNode == null)
					leftNode = new HeroNode();
				leftNode.add(v);
			}
		}
	}
	
	public List<Hero> reverseValue()
	{
		List<Hero> values = new ArrayList();
		
		if(rightNode != null)
			values.addAll(rightNode.reverseValue());
		values.add(value);
		if(leftNode != null)
			values.addAll(leftNode.reverseValue());
		
		return values;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HeroNode test = new HeroNode();
		List<Hero> hList = new ArrayList();
		for(int i = 0; i < 10; i++)
		{
			Hero h = new Hero();
			h.name = "Hero" + i;
			h.hp = (float)(Math.random() * 900 + 100);
			hList.add(h);
		}
		System.out.println("初始化10个Hero: ");
        System.out.println(hList);
        
        for(Hero hero: hList)
        {
        	test.add(hero);
        }
        
        System.out.println("根据血量倒排序后的Hero: ");
        System.out.println(test.reverseValue());

	}

}
