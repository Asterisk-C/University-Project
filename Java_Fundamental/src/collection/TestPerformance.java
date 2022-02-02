package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPerformance 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		// List Performance
//		List<Hero> heros = new ArrayList<Hero>();
//        
//        for (int j = 0; j < 2000000; j++) {
//            Hero h = new Hero("Hero " + j);
//            heros.add(h);
//        }
//            
//        // 进行10次查找，观察大体的平均值
//        for (int i = 0; i < 10; i++) 
//        {
//            // 打乱heros中元素的顺序
//            Collections.shuffle(heros);
//             
//            long start = System.currentTimeMillis();
//     
//            String target = "Hero 1000000";
//     
//            for (Hero hero : heros) {
//                if (hero.name.equals(target)) {
//                    System.out.println("找到了 hero!" );
//                    break;
//                }
//            }
//            long end = System.currentTimeMillis();
//            long elapsed = end - start;
//            System.out.println("一共花了：" + elapsed + " 毫秒");
//        }
		
		
		// HashMap Performance
		Map<String, Hero> heros = new HashMap();
        
        for (int j = 0; j < 2000000; j++) {
            Hero h = new Hero("Hero " + j);
            heros.put(h.name, h);
        }
            
        // 进行10次查找，观察大体的平均值
        for (int i = 0; i < 10; i++) 
        {
             
            long start = System.currentTimeMillis();
     
            String target = "Hero 1000000";
     
            heros.get(target);
            System.out.println("找到了 hero!" );
            
            long end = System.currentTimeMillis();
            long elapsed = end - start;
            System.out.println("一共花了：" + elapsed + " 毫秒");
        }

	}

}
