package guidewire;

public class Q2 
{
	public static Integer binary2decimal(String str)
	{
		Integer sum = 0;
		for(int i = 1; i <= str.length(); i++)
		{
			int dt = Integer.parseInt(str.substring(i - 1, i));
			sum += (int)Math.pow(2, str.length() - i)*dt;
		}
		return sum;
	}
	
	public static int solution(String S) 
    {
        // write your code in Java SE 8
		int number = binary2decimal(S);
		int count = 0;
		while(number > 0)
		{
			if(number%2 == 0)
			{
				number = number/2;
				count++;
			}
			else
			{
				number -= 1;
				count++;
			}
		}
		return count;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println(binary2decimal("011100"));
		System.out.println(solution("111"));

	}

}
