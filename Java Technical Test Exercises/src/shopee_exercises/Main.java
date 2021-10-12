package shopee_exercises;

public class Main 
{

	public String thousandSeparator(int number)
	{
		String source = String.valueOf(number);
		int count = 0;
		StringBuilder result = new StringBuilder();
		
		for(int i = source.length()-1; i >= 0; i--)
		{
			count++;
			result.append(source.charAt(i));
			if(count == 3 && i != 0)
			{
				result.append(',');
				count = 0;
			}
		}
		return result.reverse().toString();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Main test = new Main();
		System.out.println(test.thousandSeparator(1234567));
	}

}
