import java.util.HashMap;

public class TwoSum 
{
/* sample solution
	public int[] twoSum(int[] nums, int target) 
    {
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i+1; j<nums.length; j++)
            {
                if(nums[i]+nums[j]==target)
                    return new int[] {i,j};
            }
        }
        return null;
    }
*/
	// advanced solution
	public int[] twoSum(int[] nums, int target) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++)
        {
            final Integer value = map.get(nums[i]);
            if(value != null)
            {
                return new int[] {value, i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }

}
