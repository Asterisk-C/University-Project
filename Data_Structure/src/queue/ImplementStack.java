package queue;

import java.util.LinkedList;
import java.util.Queue;

/* The problem is opposite of this post. We are given a Queue data structure that supports standard operations 
like enqueue() and dequeue(). We need to implement a Stack data structure using only instances of Queue and 
queue operations allowed on the instances.*/
public class ImplementStack 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
 
        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
 
        System.out.println("current size: " + s.size());

	}
	
	// Method 1 (By making push operation costly) 
	public static class Stack
	{
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		int curr_size;
		
		public Stack()
		{
			curr_size = 0;
		}
		
		public void push(int n)
		{
			q1.add(n);
			while(!q2.isEmpty())
			{
				q1.offer(q2.poll());
			}
			curr_size++;
			
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
		}
		
		public void pop()
		{
			q2.poll();
			curr_size--;
		}
		
		public int top()
		{
			if(q2.isEmpty())
				return -1;
			
			return q2.peek();
		}
		
		public int size()
		{
			return curr_size;
		}
	}

}
