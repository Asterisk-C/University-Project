package hw_mock_exercises;
import java.util.*;

public class Q1 
{

	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			
			String s = sc.nextLine();
			if(s.length() >= 100)
				break;
			
			String[] s_split = s.split(",");
			Arrays.sort(s_split);
			
			for(int i = 0; i < s_split.length-1; i++)
			{
				System.out.print(s_split[i] + ",");
			}
			System.out.print(s_split[s_split.length-1]);
			
			System.out.println();
		}
		
	}
	
}
