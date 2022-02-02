package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class ReverseKeyAndValue 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HashMap<String, String> hm = new HashMap();
		HashMap<String, String> temp = new HashMap();
		hm.put("Chris Paul", "PG");
		hm.put("Booker", "SG");
		hm.put("Ayton", "C");
		System.out.println(hm);
		
		Set<String> keys = hm.keySet();
//		Collection<String> values = hm.values();
		for(String key: keys)
		{
			String value = hm.get(key);
			temp.put(value, key);
		}
		
		hm.clear();
		hm.putAll(temp);
		System.out.println(hm);

	}

}
