package sort;

public class Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Test test = new Test();
		System.out.println(test.fibonacci(6));
		
	}
	
	// µÝ¹é
	public int fibonacci(int n)
	{
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	// ¶¯Ì¬¹æ»®
	public static int fib(int n)
	{
		if(n <= 1)
			return n;
		
		int Memo_i_2 = 0;
		int Memo_i_1 = 1;
		int Memo_i = 1;
		for(int i = 2; i <= n; i++)
		{
			Memo_i = Memo_i_1 + Memo_i_2;
			Memo_i_2 = Memo_i_1;
			Memo_i_1 = Memo_i;
		}
		return Memo_i;
	}

}
