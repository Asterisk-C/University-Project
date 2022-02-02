package collection;

public class MyHashcode 
{
	public static int hashcode(String s)
	{
		
		if(s.length() == 0)
			return 0;
		
		int sum = 0;
		char[] c = s.toCharArray();
		for(int i = 0; i < c.length; i++)
		{
			sum += (int)c[i];
		}
		sum *= 23;
				
		sum = sum % 2000;
		
		sum = sum < 0 ? 0 - sum: sum;
		
		System.out.println(sum);
		
		return sum;
	}
	
	public static String randomString(int length)
	{
		String pool = "";
		
		 for (short i = '0'; i <= '9'; i++) 
		 {
	            pool += (char) i;
	     }
	     for (short i = 'a'; i <= 'z'; i++) 
	     {
	            pool += (char) i;
	     }
	     for (short i = 'A'; i <= 'Z'; i++) 
	     {
	            pool += (char) i;
	     }
	     
	     char[] c = new char[length];
	     for(int n = 0; n < length; n++)
	     {
	    	 int index = (int)(Math.random() * pool.length());
	    	 c[n] = pool.charAt(index);
	     }
	     
	     String result = new String(c);
		
		return result;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		for(int i = 0; i < 100; i++)
		{
			int length = (int)(Math.random() * 8 + 2);
			String str = randomString(length);
//			System.out.println(str);
			hashcode(str);
		}

	}

}
