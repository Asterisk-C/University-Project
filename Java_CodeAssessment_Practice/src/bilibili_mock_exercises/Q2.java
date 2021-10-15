package bilibili_mock_exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q2 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine())
		{
			int m = sc.nextInt();
			int n = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			for(int i = m; i <= n; i++)
			{
				int x = i / 100;
				int y = i / 10 % 10;
				int z = i % 10;
				
				double cubic = Math.pow(x, 3) + Math.pow(y, 3) + Math.pow(z, 3);
				
				if(cubic == (double)i)
				{
					list.add(Integer.valueOf((int)cubic));
					System.out.print(Arrays.toString(list.toArray()));
				}				
				
			}
			System.out.println();
		}
		
		
	}

}
