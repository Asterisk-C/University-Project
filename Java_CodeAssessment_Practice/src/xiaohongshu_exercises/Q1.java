package xiaohongshu_exercises;
//小红书邀请用户参与新兴线下生活方式的体验活动，每个活动有编号从1到n。每个活动之间有依赖关系，例如滑雪III（编号5）依赖滑雪II（编号3），[3,5]表示用户需要先完成3再完成5。为方便大家使用，组委会提供了一个查询依赖的功能，该功能输入[x,y]，若x是y需要进行的前置活动，则返回true。请实现这一功能
//Input:
//n = 5
//relations = [[1,3], [1,2], [3,2], [2,4], [3,5]]
//queries = [[1,5], [1,4], [4,5], [4,2]]
//
//Output: 
//[1, 1, 0, 0]

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution 
{
    /* Write Code Here */
    public int[] checkDependency(int n, int[][] relations, int[][] queries) 
    {
    	Map<Integer, List<Integer>> map = new HashMap<>();
    	for(int[] point: queries)
    	{
    		if(!map.containsKey(point[0]))
    		{
    			map.put(point[0], new ArrayList<>());
    		}
    		map.get(point[0].add(point[1]));
    	}
    	List<Integer> list = new ArrayList<>();
    	list.add(hasPath(n, map, relations));
    }
    
    public int hasPath(int n, Map<Integer, List<Integer>> map, int[][] relations)
    {
    	LinkedList<Integer> queue = new LinkedList<>();
    	boolean[] visited = new boolean[n];
    	
    	for(int i = 0; i < relations.length; i++)
    	{
    		queue.add(relations[i][0]);
    		visited[relations[i][0]] = true;
    	}
    	
    	while(!queue.isEmpty())
    	{
    		int tmp = queue.pop();
    		List<Integer> list = map.get(tmp);
    		
    		if(list == null)
    			continue;
    		 		
    		for(int x: list)
    		{
    			for(int i = 0; i < relations.length; i++)
    	    	{
    	    		if(x == relations[i][1])
    	    			return 1;
    	    		if(visited[x] == true)
    	    			continue;
    	    		
    	    		visited[x] = true;
    	    		queue.add(x);
    	    	}
    		}
    	}
    	return 0;
    }
}

public class Q1 
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] res;
            
        int n;
        n = Integer.parseInt(in.nextLine().trim());

        int relations_rows = 0;
        int relations_cols = 0;
        relations_rows = in.nextInt();
        relations_cols = in.nextInt();
        
        int[][] relations = new int[relations_rows][relations_cols];
        for(int relations_i=0; relations_i<relations_rows; relations_i++) {
            for(int relations_j=0; relations_j<relations_cols; relations_j++) {
                relations[relations_i][relations_j] = in.nextInt();
            }
        }


        int queries_rows = 0;
        int queries_cols = 0;
        queries_rows = in.nextInt();
        queries_cols = in.nextInt();
        
        int[][] queries = new int[queries_rows][queries_cols];
        for(int queries_i=0; queries_i<queries_rows; queries_i++) {
            for(int queries_j=0; queries_j<queries_cols; queries_j++) {
                queries[queries_i][queries_j] = in.nextInt();
            }
        }


        res = new Solution().checkDependency(n, relations, queries);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}

