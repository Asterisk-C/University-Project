package xiecheng_exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//现在，小红有n个数字，她想按照数字的所含“洞”的数量从大到小排序，如果两个数字“洞”的数量相同则按照其十进制的从大到小排序。
//你需要输出排序后的结果。

public class Q1 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		String s = sc.nextLine();
		String[] key = s.split(" ");
		
		HashMap<Integer, Integer> dong = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < key.length; i++)
		{
			Integer value = 0;
			String[] str = key[i].split("");
			for(int j = 0; j < str.length; j++)
			{
				if(str[j].equals("8"))
					value += 2;
				else if(str[j].equals("0") || str[j].equals("4") || str[j].equals("6") || str[j].equals("9"))
					value += 1;
			}
			dong.put(Integer.valueOf(key[i]), value);
		}
//		System.out.println(dong);
		
		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(dong.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if(o2.getValue() == o1.getValue())
					return (o2.getKey() - o1.getKey());
				else
					return (o2.getValue() - o1.getValue());
			}	
		});
		
//		for(Map.Entry<Integer, Integer> mapping: list)
//		{
//			System.out.print(mapping.getKey() + " ");
//		}
		
		for(int i = 0; i < list.size(); i++)
		{
			if(i == list.size() - 1)
			{
				System.out.print(list.get(i).getKey());
			}
			else
			{
				System.out.print(list.get(i).getKey() + " ");
			}
		}

	}

}
