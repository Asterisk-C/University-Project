package inheritance;

public class Spider extends Animal
{
	protected Spider(int legs)
	{
		super(8);		
	}
	
	@Override
	public void eat()
	{
		System.out.println("Spider will eat you.");
	}
	
}
