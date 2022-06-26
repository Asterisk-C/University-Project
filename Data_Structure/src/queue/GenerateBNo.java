package queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBNo 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int n = 10;
//        generatePrintBNo(n);
        convertDToB(n);

	}
	
	static void convertDToB(int n)
	{
		for(int i = 0; i < n; i++)
		{
			String s = Integer.toBinaryString(i);
			System.out.println(s);
		}
		
	}
	
	static void generatePrintBNo(int n)
	{
		Queue<String> queue = new LinkedList<>();
		queue.offer("1");
		String s1, s2;
		
		while(n > 0)
		{
			s1 = queue.poll();
			System.out.println(s1);
			
			s2 = s1;
			queue.offer(s1 + "0");
			queue.offer(s2 + "1");
			n--;
		}
	}

}
