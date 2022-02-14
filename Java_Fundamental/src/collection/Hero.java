package collection;

public class Hero implements Comparable<Hero>
{
    public String name;
    public float hp;
    public int damage;
 
    public Hero() 
    {
 
    }
 
    // 增加一个初始化name的构造方法
    public Hero(String name) 
    {
        this.name = name;
    }
    
    // Add another constructor of Hero
    public Hero(String name, int hp, int damage) 
    {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }
    
    @Override
    public int compareTo(Hero anotherHero)
    {
    	if(damage < anotherHero.damage)
    		return 1;
    	else
    		return -1;
    }
 
    // 重写toString方法
    @Override
    public String toString() 
    {
        return String.format("[%s(hp: %.0f, damgage: %d)]", name, hp, damage);
    }
    
    public void attackHero(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
         
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }
    
    public boolean isDead()
    {
    	return hp < 0 ? true: false;
    }
 
}
