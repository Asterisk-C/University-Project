import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test 
{ 
	public static int[] swap(int[] ab)
	{
		int temp = ab[0];
		ab[0] = ab[1];
		ab[1] = temp;

		return ab;
	}
	
    public static void main(String[] args) 
    {

    	int[] ab = {1, 2};
    	System.out.println("The values of a and b before swap:");
		for(int i = 0; i < ab.length; i++)
    	{
    		System.out.println(ab[i]);
    	}
    	swap(ab);
    	System.out.println("The values of a and b after swap:");
		for(int i = 0; i < ab.length; i++)
    	{
    		System.out.println(ab[i]);
    	}
    	
    }
}
