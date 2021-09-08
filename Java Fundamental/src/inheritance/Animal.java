package inheritance;

public abstract class Animal 
{
	protected int legs;
	
	protected Animal(int legs)
	{
		this.legs = legs;
	}
	
	protected Animal()
	{
		
	}
	
	public abstract void eat();
	
	public void walk()
	{
		System.out.println("This animal uses " + legs + " legs to walk.");
	}
	
}
