package stack;

import java.util.Stack;

public class PostfixExpression 
{
	public static int evaluatePostfix(String exp)
	{
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < exp.length(); i++)
		{
			char c = exp.charAt(i);
			if(Character.isDigit(c))
				stack.push(Integer.parseInt(String.valueOf(c)));
			else
			{		
				int n1 = stack.pop();
				int n2 = stack.pop();
				
				switch(c)
				{
				case '+':
					stack.push(n2 + n1);
					break;
				case '-':
					stack.push(n2 - n1);
					break;
				case '*':
					stack.push(n2 * n1);
					break;
				case '/':
					stack.push(n2 / n1);
					break;
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String exp="231*+9-";
        System.out.println("postfix evaluation: "+evaluatePostfix(exp));

	}

}
