package collection;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ReverseTreeSet 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Comparator<Integer> c = new Comparator<Integer>()
		{
			@Override
			public int compare(Integer i1, Integer i2)
			{
				return i2 - i1;
			}
		};
		
		Set<Integer> treeSet = new TreeSet<>(c);
		for(int i = 0; i < 10; i++)
		{
			treeSet.add(i);
		}
		System.out.println(treeSet);

	}

}
