import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		char c = 'a';
		for(int i = 0; i < 6; i++)
		{
			++c;
		}
		System.out.println(String.valueOf(c));
	}

	public int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> m = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        if (m.get(target - nums[i]) != null) {
	            return new int[]{m.get(target - nums[i])+1, i+1};
	        }
	        m.put(nums[i], i);
	    }
	    return new int[]{0, 0};
	}
	
}
