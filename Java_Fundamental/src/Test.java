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
	public Test test;
	
    public static void main(String[] args) 
    {
//        HashSet<Integer> names = new HashSet<Integer>();
//    	
//    	for(int i = 0; i < 10; i++)
//    	{
//    		names.add(i);
//    	}
//        
//    	System.out.println(names);
//    	
//    	for(int i: names)
//    	{
//    		System.out.println(i);
//    	}
//    	
//    	for(Iterator<Integer> it = names.iterator(); it.hasNext();)
//    	{
//    		Integer i = (Integer)it.next();
//    		System.out.println(i);
//    	}
    	
//    	//初始化集合numbers
//        List<Integer> numbers = new ArrayList<>();
//         
//        for (int i = 0; i < 10; i++) {
//            numbers.add(i);
//        }
//         
//        System.out.println("集合中的数据:");
//        System.out.println(numbers);
//         
//        Collections.reverse(numbers);      
//        System.out.println("翻转后集合中的数据:");
//        System.out.println(numbers);
//        
//        Collections.shuffle(numbers);   
//        System.out.println("混淆后集合中的数据:");
//        System.out.println(numbers);
//        
//        Collections.sort(numbers);  
//        System.out.println("排序后集合中的数据:");
//        System.out.println(numbers);
//        
//        Collections.swap(numbers, 2, 8);
//        System.out.println("交换2和8下标的数据后，集合中的数据:");
//        System.out.println(numbers);
//        
//        Collections.rotate(numbers,2);
//        System.out.println("把集合向右滚动2个单位，标的数据后，集合中的数据:");
//        System.out.println(numbers);
//        
//        System.out.println("把非线程安全的List转换为线程安全的List");
//        List<Integer> synchronizedNumbers = (List<Integer>)Collections.synchronizedList(numbers);
    	
//    	HashSet<Integer> hs = new HashSet();
//    	hs.add(3);
//    	hs.add(6);
//    	hs.add(5);
//    	System.out.println(hs);
//    	
//    	LinkedHashSet<Integer> lhs = new LinkedHashSet();
//    	lhs.add(3);
//    	lhs.add(6);
//    	lhs.add(5);
//    	System.out.println(lhs);
//    	
//    	TreeSet<Integer> ts = new TreeSet();
//    	ts.add(3);
//    	ts.add(6);
//    	ts.add(5);
//    	System.out.println(ts);
//    	
//    	double n = Math.PI;
//    	System.out.println(n);
//    	String s = String.valueOf(n);
//    	s = s.replace(".", "");
////    	System.out.println(s);
//    	char[] c = s.toCharArray();
//    	
//    	Set<Integer> temp = new LinkedHashSet();
//    	for(char cc: c)
//    	{
//    		temp.add(Integer.parseInt(String.valueOf(cc)));
//    	}
//    	System.out.println(temp);
    	short i = 'a';
    	System.out.println(i);
    }
}
