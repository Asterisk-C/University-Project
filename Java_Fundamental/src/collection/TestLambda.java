package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestLambda 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Random r = new Random();
		List<Hero> heros = new ArrayList<Hero>();
		for(int i = 0; i < 10; i++)
		{
			heros.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
		}
		System.out.println("��ʼ����ļ��ϣ�");
        System.out.println(heros);
        System.out.println("ʹ��������ķ�ʽ��ɸѡ�� hp>100 && damange<50��Ӣ��");
        HeroChecker checker = new HeroChecker()
        		{
        	@Override
        	public boolean test(Hero h)
        	{
        		return (h.hp > 100 && h.damage < 50);
        	}
        		};
//        filter(heros, checker);
        filter(heros, h -> h.hp > 100 && h.damage < 50);
	}
	
	private static void filter(List<Hero> heros, HeroChecker checker)
	{
		for(Hero h: heros)
		{
			if(checker.test(h))
				System.out.print(h);
		}
	}

}
