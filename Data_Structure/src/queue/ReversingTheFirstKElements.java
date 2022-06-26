package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* Given an integer k and a queue of integers, we need to reverse the order of the first 
 * k elements of the queue, leaving the other elements in the same relative order.
 */
public class ReversingTheFirstKElements 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        queue.add(70);
        queue.add(80);
        queue.add(90);
        queue.add(100);
 
        int k = 5;
        reverseQueueFirstKElements(queue, k);
        Print(queue);

	}
	
	static void reverseQueueFirstKElements(Queue<Integer> queue, int k)
	{
		Stack<Integer> stack = new Stack<>();
		
		if(queue.isEmpty() || k > queue.size() || k <= 0)
			return;
		
		for(int i = 0; i < k; i++)
		{
			stack.push(queue.poll());
		}
		
		while(!stack.isEmpty())
		{
			queue.offer(stack.pop());
		}
		
		for(int i = 0; i < queue.size() - k; i++)
		{
			queue.offer(queue.poll());
		}
	}
	
	static void Print(Queue<Integer> queue)
    {
        while (!queue.isEmpty()) {
            System.out.print(queue.peek() + " ");
            queue.remove();
        }
    }

}
