import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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
    	
    	//��ʼ������numbers
        List<Integer> numbers = new ArrayList<>();
         
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
         
        System.out.println("�����е�����:");
        System.out.println(numbers);
         
        Collections.reverse(numbers);      
        System.out.println("��ת�󼯺��е�����:");
        System.out.println(numbers);
        
        Collections.shuffle(numbers);   
        System.out.println("�����󼯺��е�����:");
        System.out.println(numbers);
        
        Collections.sort(numbers);  
        System.out.println("����󼯺��е�����:");
        System.out.println(numbers);
        
        Collections.swap(numbers, 2, 8);
        System.out.println("����2��8�±�����ݺ󣬼����е�����:");
        System.out.println(numbers);
        
        Collections.rotate(numbers,2);
        System.out.println("�Ѽ������ҹ���2����λ��������ݺ󣬼����е�����:");
        System.out.println(numbers);
        
        System.out.println("�ѷ��̰߳�ȫ��Listת��Ϊ�̰߳�ȫ��List");
        List<Integer> synchronizedNumbers = (List<Integer>)Collections.synchronizedList(numbers);
    }
}
