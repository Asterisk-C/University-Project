package hw_exercises;

import java.util.*;

public class Q1 
{
	public class Tree
	{
		private int value;
		private int parent;
		
		public Tree(int value, int parent)
		{
			this.value = value;
			this.parent = parent;
		}
		
		public int getValue()
		{
			return value;
		}
		
		public void setValue(int value)
		{
			this.value = value;
		}
		
		public int getParent()
		{
			return parent;
		}
		
		public void setParent(int parent)
		{
			this.parent = parent;
		}
		
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] source = new int[length];
		
		for(int i = 0; i < length; i++)
		{
			source[i] = sc.nextInt();
		}
		
//		for(int i: source)
//		{
//			System.out.print(i + " ");
//		}
		
		Tree[] arrayNode = new Tree[length];
		
		
		
		
		
	}

}
