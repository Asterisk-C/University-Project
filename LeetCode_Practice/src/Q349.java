import java.util.ArrayList;
import java.util.HashSet;

public class Q349 
{
	public int[] intersection(int[] nums1, int[] nums2) 
    {
        HashSet<Integer> hs = new HashSet<>();
        for(int i: nums1)
        {
            hs.add(i);
        }
        
        ArrayList<Integer> a_result = new ArrayList<>();
        for(int j: nums2)
        {
        	if(hs.contains(j))
        	{
        		a_result.add(j);
        		hs.remove(j);
        	}
        }

        int n = a_result.size();
        int i = 0;
        int[] result = new int[n];
        for(int x: a_result)
        {
        	result[i++] = x;
        }
        return result;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
