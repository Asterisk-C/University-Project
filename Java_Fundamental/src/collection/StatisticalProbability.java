package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticalProbability 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		List<Integer> data = new ArrayList();
		for(int i = 0; i < 10; i++)
		{
			data.add(i);
		}
		System.out.println(data);
		
		int count = 0;
		int amount = 1000 * 1000;
		for(int n = 0; n < amount; n++)
		{
			Collections.shuffle(data);
			if(data.get(0) == 3 && data.get(1) == 1 && data.get(2) == 4)
				++count;
		}
		
		double probability = count / (double)amount;
		System.out.println(probability);

	}

}
