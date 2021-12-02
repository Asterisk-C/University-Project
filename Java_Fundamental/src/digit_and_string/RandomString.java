package digit_and_string;

import java.util.Random;

public class RandomString 
{
	public static char getRandomChar()
	{
		//48-57 Êý×Ö
        //65-90 ´óÐ´×ÖÄ¸
        //97-122 Ð¡Ð´×ÖÄ¸
		Random random = new Random();
		
		int choice = random.nextInt(3);
		switch(choice)
		{
		case 0:
			return (char)(short)(random.nextInt(10)+48);
		case 1:
			return (char)(short)(random.nextInt(26)+65);
		case 2:
			return (char)(short)(random.nextInt(26)+97);
		}
		return (char)1;
	}
	
	public static String getRandomString(int length)
	{
		String str = "";
		for(int i = 0; i < length; i++)
		{
			str += getRandomChar();
		}
		return str;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println(getRandomString(5));
	}

}
