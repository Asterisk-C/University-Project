package digit_and_string;

import java.util.ArrayList;
import java.util.Random;

public class CampareString extends RandomString
{
	public static String[] getRandomStringArray(int length)
	{
		String[] str = new String[length];
		for(int i = 0; i < str.length; i++)
		{
			str[i] = getRandomString(2);
		}
		return str;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String[] str = getRandomStringArray(100);
		for(String s: str)
		{
			System.out.print(s + " ");
		}
		
		ArrayList<String> repeatString = new ArrayList<String>();
		int count = 0;
		for(int i = 0; i < str.length; i++)
		{
			for(int j = i + 1; j < str.length; j++)
			{
				if(str[i].equals(str[j]))
				{
					++count;
					repeatString.add(str[i]);
				}
			}
		}
		System.out.println();
		System.out.println(count);
		System.out.println(repeatString);
	}

}
