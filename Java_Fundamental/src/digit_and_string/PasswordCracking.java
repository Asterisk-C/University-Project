package digit_and_string;

public class PasswordCracking extends RandomString
{
	private static String code = "";
	
	public static void initializeCode()
	{
		// Initialize code
		for(int x = 48; x < 58; x++)
		{
			code += String.valueOf((char)x);					
		}
		for(int y = 65; y < 91; y++)
		{
			code += String.valueOf((char)y);
		}
		for(int z = 97; z < 123; z++)
		{
			code += String.valueOf((char)z);
		}
	}
	
	public static String cracking(String password, int index)
	{
		if(index == password.length() - 1)
		{
			for(int i = 0; i < code.length(); i++)
			{
				if(code.charAt(i) == password.charAt(index))
				{
					return String.valueOf(code.charAt(i));
				}				
			}
		}
		String indexResult = "";		
		for(int i = 0; i < code.length(); i++)
		{
			if(code.charAt(i) == password.charAt(index))
			{
				indexResult = String.valueOf(code.charAt(i));
			}				
		}			
		return indexResult + cracking(password, ++index);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub		
		String password = getRandomString(5);
		System.out.println(password);
		initializeCode();
		String result = cracking(password, 0);
		System.out.println(result);

//		String code = "";
//		for(int i = 0; i < 3; i++)
//		{
//			switch(i)
//			{
//			case 0:
//				for(int x = 48; x < 58; x++)
//				{
//					code += String.valueOf((char)x);					
//				}
//				break;
//			case 1:
//				for(int y = 65; y < 91; y++)
//				{
//					code += String.valueOf((char)y);
//				}
//				break;
//			case 2:
//				for(int z = 97; z < 123; z++)
//				{
//					code += String.valueOf((char)z);
//				}
//				break;
//			default:
//				code = "Error";
//			}
//		}		
//		System.out.println(code);
	}

}
