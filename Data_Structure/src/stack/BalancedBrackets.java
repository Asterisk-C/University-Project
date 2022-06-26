package stack;

import java.util.Stack;

public class BalancedBrackets 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String expr = "[()]";
		 
        // Function call
        if (areBracketsBalanced(expr))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");

	}
	
	public static boolean areBracketsBalanced(String exp)
	{
		Stack<Character> tmpStack = new Stack<Character>();
		
		for(int i = 0; i < exp.length(); i++)
		{
			char c = exp.charAt(i);
			if(c == '(' || c == '{' || c == '[')
			{
				tmpStack.push(c);
				continue;
			}
			
			if (tmpStack.isEmpty())
                return false;
			
			if(c == ')' || c == '}' || c == ']')
			{
				char temp = tmpStack.pop();
				switch(c)
				{
				case ')':
					if (temp == '{' || temp == '[')
						return false;
					break;
					
				case '}':
					if (temp == '(' || temp == '[')
						return false;
					break;
					
				case ']':
					if (temp == '(' || temp == '{')
						return false;
					break;
				}
			}
		}
		return tmpStack.isEmpty();
	}

}
