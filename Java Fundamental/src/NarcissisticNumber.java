/*
水仙花数定义：
1. 一定是3位数
2. 每一位的立方，加起来恰好是这个数本身，比如153=1*1*1+5*5*5+3*3*3

寻找所有的水仙花数
 */
public class NarcissisticNumber 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		for(int i = 100; i <= 999; i++)
		{
			int x = i / 100;
			int y = i / 10 % 10;
			int z = i % 10;
			
			double cubic = Math.pow(x, 3) + Math.pow(y, 3) + Math.pow(z, 3);
			
			if(cubic == (double)i)
			System.out.println(x + "" + y + "" + z);
		}
		

	}

}
