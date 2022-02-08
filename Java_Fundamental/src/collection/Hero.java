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
 
}
