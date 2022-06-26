package stack;

import java.util.Stack;

public class SortStack 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);
        
        Stack<Integer> tmpStack = sortstack(input);
        System.out.println("Sorted numbers are:");
        
        while (!tmpStack.empty())
        {
            System.out.print(tmpStack.pop() + " ");
        }

	}
	
	public static Stack<Integer> sortstack(Stack<Integer> input)
	{
		Stack<Integer> tmpstack = new Stack<Integer>();
		while(!input.isEmpty())
		{
			int temp = input.pop();
			while(!tmpstack.isEmpty() && tmpstack.peek() > temp)
			{
				input.push(tmpstack.pop());
			}
			tmpstack.push(temp);
		}
		
		return tmpstack;	
	}

}
