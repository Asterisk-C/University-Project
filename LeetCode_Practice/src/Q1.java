
public class Q1 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Q1 test = new Q1();
		System.out.println(test.internNumber(10, 25000));
	}
	
	public int internNumber(int input1, int input2)
	{
		int totalDays = 50;
		int password = 0;
		
		for(int i = 1; i <= input1; i++)
		{
			password = 5000 * i;
			for(int d = 1; d < totalDays; d++)
			{
				password += 5000 + d;
				if(password == input2)
				{
					return i;
				}
			}
		}
		return -1;
	}

}
