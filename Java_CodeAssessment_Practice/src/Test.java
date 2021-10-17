import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Test test = new Test();
		int[] nums = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(test.twoSum(nums, 10)));
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
