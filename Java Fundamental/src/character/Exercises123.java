package character;

import java.util.Arrays;
import java.util.Random;

public class Exercises123 
{

	public static void main(String[] args) 
	{
		Exercises123 test = new Exercises123();
//		System.out.println(test.getRandomChar());
		System.out.println("The string with length 5:");
		System.out.println(test.getRandomString(5));
		System.out.println("The array with length 8 which makes up by string with length 5:");
		String[] strArray1 = test.getStringArray(8);
		for(String s: strArray1)
		{
			System.out.print(s + " ");
		}
		System.out.println();
		Arrays.sort(strArray1);
		for(String s: strArray1)
		{
			System.out.print(s + " ");
		}
		

	}
	
	public char getRandomChar()
	{
		//48-57 Êý×Ö
        //65-90 ´óÐ´×ÖÄ¸
        //97-122 Ð¡Ð´×ÖÄ¸
        //randoms.nextInt(9)+48; Êý×Ö
        //randoms.nextInt(25)+65; ´óÐ´×ÖÄ¸
        //randoms.nextInt(25)+97; Ð¡Ð´×ÖÄ¸
		Random randoms = new Random();
		int choice = randoms.nextInt(3);
		switch(choice) 
		{
		case 0:
			return (char)((short)randoms.nextInt(9)+48);
		case 1:
			return (char)((short)randoms.nextInt(25)+65);
		case 2:
			return (char)((short)randoms.nextInt(25)+97);
		}
		
		return (char)1;	
	}
	
	public String getRandomString(int length)
	{
		String str = "";
		for(int i = 0; i < length; i++)
		{
			str = str + getRandomChar();
		}
		return str;
	}
	
	public String[] getStringArray(int length)
	{
		String[] strArray = new String[length];
		for(int i = 0; i < length; i++)
		{
			strArray[i] = getRandomString(5);
		}
		return strArray;
	}

}
