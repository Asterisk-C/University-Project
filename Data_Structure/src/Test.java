import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		Map<Integer, Boolean> mp = new HashMap<>();
//		for(int i = 0; i < 5; i++)
//        {
//            mp.put(i, true);
//        }
//		
//		// Print method 1	
//		Set<Integer> s = mp.keySet();	
//		Iterator itr = s.iterator();
//	    while (itr.hasNext()) 
//	    {
//	        System.out.print(itr.next() + " ");
//	    }
//	    
//	    System.out.println();
//	    
//	    // Print method 2
//        for (Map.Entry<Integer,Boolean> me : mp.entrySet())
//        {
//            System.out.print(me.getKey() + " ");
//        }
		int[] shortage = new int[8];
		int head = 0;
		shortage[head++] = 1;
		shortage[head++] = 2;
		shortage[head++] = 3;
		shortage[head++] = 4;
		
		int end = 7;
		shortage[end--] = 8;
		shortage[end--] = 7;
		shortage[end--] = 6;
		shortage[end--] = 5;
		
		int test = 7;
		int x = shortage[test++];
		for(int i:shortage)
		{
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.print(x);
	}

}
