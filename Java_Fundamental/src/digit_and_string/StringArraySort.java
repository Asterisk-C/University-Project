package digit_and_string;

import java.util.Random;

public class StringArraySort extends RandomString
{
	public static String[] getStringArray(int length) 
	{
		String[] strArray = new String[length];
		for(int i = 0; i < length; i++)
		{
			strArray[i] = getRandomString(5);
		}
		return strArray;
	}
	
	// bubble sort
	public static void sort(String[] strArray)
	{
		String temp;
		for(int i = 0; i < strArray.length; i++)
		{
			for(int j = 0; j < strArray.length - i - 1; j++)
			{
				char c1 = strArray[j].charAt(0);
				char c2 = strArray[j + 1].charAt(0);
				String s1 = Character.toString(c1);
				String s2 = Character.toString(c2);
				if(Character.toUpperCase(c1) > Character.toUpperCase(c2) && !s1.equalsIgnoreCase(s2))
				{
					temp = strArray[j];
					strArray[j] = strArray[j + 1];
					strArray[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String[] strArray = getStringArray(8);
		for(String s: strArray)
		{
			System.out.print(s + " ");
		}
		sort(strArray);
		System.out.println();
		for(String s: strArray)
		{
			System.out.print(s + " ");
		}
	}

}
