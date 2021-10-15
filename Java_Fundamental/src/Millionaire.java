/*
假设你月收入是3000，除开平时花销，每个月留下1000块钱进行投资。

然后你认真的钻研了 《股票和基金 21天从入门到精通》，达到了每年20%的投资回报率。

那么问题来了，以每个月投资1000块钱的节奏，持续投资多少年，总收入达到100万？
（复利计算按照每年12000投入计算，不按照每月计息）
*/
public class Millionaire 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		double fundPerYear = 12000;
		double target = 1000 * 1000;
		double sum = 0;
		for(int n = 0; n < 100; n++)
		{
			double interest = fundPerYear * (Math.pow(1.2, n));
			sum += interest;
			if(sum >= target)
			{				
				System.out.println(n);
				System.out.println(sum);
				break;					
			}
			
		}
	}

}
