import java.util.HashMap;
import java.util.Map;

public class Q169 
{
	
	public int majorityElement(int[] nums) 
    {
        Map<Integer, Integer> hm = new HashMap<>();
        
        int condition = nums.length / 2;
        
        if(nums.length == 1)
        	return nums[0];
        
        for(int n: nums)
        {
        	if(hm.containsKey(n))
        	{
        		int v = hm.get(n);
        		if(v + 1 > condition)
        			return n;
        					
        		hm.put(n, ++v);
        	}
        	else
        	{
        		int v = 1;
        		hm.put(n, v);
        	}
        }
        return 0;
    }
	
	public int xiaoxiaole(int[] nums) 
    {
		int majority = nums[0];
		int count = 1;
        for(int i = 1; i < nums.length; i++)
        {
        	if(count == 0)
        		majority = nums[i];
        	
        	if(majority == nums[i])
    			++count;
    		else
    			--count;	
        }
        return majority;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
