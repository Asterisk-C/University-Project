package hw_exercises;

/*
 * 1.	n 级台阶，一次允许走1级，2级，3级。
a)	一共有多少种走法
b)	把a)的所有的走法都列出来
c)	如果不考虑先后顺序，只考虑组合（比如3级台阶，先走1级再走2级和先走2级再走1级是同一个解）一共有多少种走法
d)	把c)都所有走法都列出来

比如4个台阶
如果考虑顺序
1.1.1.1
1.1.2
1.2.1
2.1.1
1.3.
3.1.
2.2
共7种

如果不考虑顺序，只考虑组合
1.1.1.1
1.1.2
1.3
2.2
共4种

 */
public class I2 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		I2 test = new I2();
		
		System.out.println(test.jumpNumber(50));

	}
	
	public int jumpNumber(int n)
	{
		int result = 0;
		
		if(n <= 0) 
		{
			return 0;
		}
		else if(n == 1) 
		{
			return 1;
		}
		else if(n == 2) 
		{
			return 2;
		}
		else if(n == 3) 
		{
			return 4;
		}
		else
		{		
			for(int i = 4; i <= n; i++)
			{
				result = jumpNumber(i-3) + jumpNumber(i-2) + jumpNumber(i-1);
			}
			return result;
		}
		
	}

}
