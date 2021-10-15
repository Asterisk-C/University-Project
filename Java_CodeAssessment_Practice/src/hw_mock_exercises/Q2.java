package hw_mock_exercises;
import java.util.*;

public class Q2 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		
		String s = String.valueOf(str.charAt(0));
		
		for(int i = 0; i < str.length(); i++)
		{
			if(s.contains(String.valueOf(str.charAt(i))))
				continue;
			s = s + String.valueOf(str.charAt(i));
		}
		
		System.out.print(s);

	}

}
