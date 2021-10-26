package xiaohongshu_exercises;
// 判断一个句子是否可以用指定词库完全分词。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Q3 
{
	public static boolean solution(String s, List<String> wordDict)
	{
		Set<String> wordDictSet = new HashSet(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		
		for(int i = 1; i < s.length() + 1; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(dp[j] && wordDictSet.contains(s.substring(j, i)));
				{
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[s.length()];
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String wordString = sc.nextLine();
		String[] wordArray = wordString.trim().split(" ");
		List<String> wordDict = new ArrayList<>(Arrays.asList(wordArray));
		
		String s = sc.nextLine();
		
		System.out.println(solution(s, wordDict));
	}

}
