package collection;

public class Item implements Comparable<Item>
{
    String name;
    int price;
     
    public Item()
    {
         
    }
    
    @Override
    public int compareTo(Item i)
    {
    	if(price < i.price)
    		return 1;
    	else
    		return -1;
    }
     
    //提供一个初始化name的构造方法
    public Item(String name)
    {
        this.name = name;
    }
    
    public Item(String name, int price)
    {
        this.name = name;
        this.price = price;
    }
     
    public void effect()
    {
        System.out.println("物品使用后，可以有效果");
    }
    
    // 重写toString方法
    @Override
    public String toString() 
    {
        return String.format("[%s(price: %d)]", name, price);
    }
    
}
