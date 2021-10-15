package bilibili_exercises;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution 
{
    /* Write Code Here */
    public String reorder(String a, String b) 
    {
    	// Get a common string, put it into a list
    	char[] aa = a.toCharArray();
    	char[] bb = b.toCharArray();
    	
    	ArrayList list = new ArrayList();
    	for(int i = 0; i < aa.length; i++)
    	{
    		for(int j = 0; j < bb.length; j++)
    		{
    			if(aa[i] == bb[j])
    				list.add(aa[i]);
    		}
    	}
    	
    	// Define the order
    	HashMap<String, Integer> orderMap = new HashMap()
    	{{
    		for(int i = 0; i < list.size(); i++)
    		{
    			put(list.get(i), i);
    		}
    	}};
    	
    	ArrayList aaa = new ArrayList()
    	{{
    		for(int i = 0; i < aa.length; i++)
    		{
    			add(aa[i]);
    		}
    	}};
    	
    	aaa.sort(new Comparator() 
    	{
    		public int compare(Object o1, Object o2)
    		{
    			if(orderMap.get(o1) == null || orderMap.get(o1) == null)
    				return 1;
    			return orderMap.get(o1).compareTo(orderMap.get(o2));
    		}
    	});
    	String c = String.join(",", aaa);
    	return c;

    }
}

public class Q2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;
            
        String _a;
        try {
            _a = in.nextLine();
        } catch (Exception e) {
            _a = null;
        }
        
        String _b;
        try {
            _b = in.nextLine();
        } catch (Exception e) {
            _b = null;
        }
  
        res = new Solution().reorder(_a, _b);
        System.out.println(res);
    }
}
