package digit_and_string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
		int count1 = 0;
		for(int i = 0; i < str.length; i++)
		{
			for(int j = i + 1; j < str.length; j++)
			{
				if(str[i].equalsIgnoreCase(str[j]))
				{
					++count1;
					repeatString.add(str[i]);
				}
			}
		}
		System.out.println();
		System.out.println(count1);
		System.out.println(repeatString);
		
		HashSet<String> hs = new HashSet();
		for(String s1: str)
		{
			int count2 = 0;
			for(String s2: str)
			{
				if(s1.equalsIgnoreCase(s2))
					count2++;
				if(count2 == 2)
				{
					hs.add(s2);
					break;
				}
			}
		}
		System.out.println();
		System.out.println(hs.size());
		System.out.println(hs);
	}

}
