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
	
	//advanced solution
	/*
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
    */
	
	//my solution
	public int[] twoSum(int[] nums, int target)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		int result[] = new int[2];
		for(int i=0; i<nums.length; i++)
		{
			
			if(map.containsKey(target-nums[i]))
			{
				result[0] = map.get(target-nums[i]);
				result[1] = i;			
				break;
			}
			map.put(nums[i], i);
		}
		
		return result;
		
	}
	
	public static void main(String[] args)
	{
		TwoSum test = new TwoSum();		
		test.twoSum(new int[]{2, 7, 11, 15}, 9);		
	}

}
