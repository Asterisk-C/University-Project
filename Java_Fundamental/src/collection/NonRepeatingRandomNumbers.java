package collection;

import java.util.HashSet;

public class NonRepeatingRandomNumbers 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HashSet<Integer> hs = new HashSet();
		while(hs.size() < 50)
		{
			int n = (int)(Math.random() * 100);
//			if(!hs.contains(n))
			hs.add(n);
		}
		
		System.out.println(hs.size());
		System.out.println(hs);

	}

}
