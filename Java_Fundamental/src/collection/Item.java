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
     
    //�ṩһ����ʼ��name�Ĺ��췽��
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
        System.out.println("��Ʒʹ�ú󣬿�����Ч��");
    }
    
    // ��дtoString����
    @Override
    public String toString() 
    {
        return String.format("[%s(price: %d)]", name, price);
    }
    
}
