package collection;

import java.util.ArrayList;
import java.util.List;

public class Node 
{
	public Node leftNode;
	public Node rightNode;
	public Object value;
	
	public void add(Object v)
	{
		if(value == null)
			value = v;
		else
		{
			if((Integer)v > (Integer)value)
			{
				if(rightNode == null)
					rightNode = new Node();
				rightNode.add(v);
			}
			else
			{
				if(leftNode == null)
					leftNode = new Node();
				leftNode.add(v);
			}
		}
	}
	
	public List<Object> traverseValue()
	{
		List<Object> values = new ArrayList<>();
		
		if(leftNode != null)
			values.addAll(leftNode.traverseValue());
		
		values.add(value);
		
		if(rightNode != null)
			values.addAll(rightNode.traverseValue());
		
		return values;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Node test = new Node();
		int[] t1 = {67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
		for(int i: t1)
		{
			test.add(i);
		}
		System.out.println(test.traverseValue());

	}

}
