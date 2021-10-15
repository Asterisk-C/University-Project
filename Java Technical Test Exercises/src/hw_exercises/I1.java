package hw_exercises;

import java.util.ArrayList;
import java.util.List;

public class I1 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(73);
		list.add(74);
		list.add(75);
		list.add(71);
		list.add(69);
		list.add(72);
		list.add(76);
		list.add(73);
		
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++)
		{
			result.add(0);
		}
		
		for(int i = 0; i < list.size() - 1; i++)
		{
			for(int j = i + 1; j < list.size(); j++)
			{
				if(list.get(j) > list.get(i))
				{
					result.set(i, (list.indexOf(j)+1) - (list.indexOf(i)+1));
					continue;
				}				
				
			}
		}
		System.out.println(result);
	}

}
