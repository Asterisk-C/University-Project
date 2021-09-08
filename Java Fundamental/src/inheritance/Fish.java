package inheritance;

public class Fish extends Animal implements Pet
{
	private String name;
	
	public Fish()
	{
		super();
	}
	
	@Override
	public String getName()
	{
		return name;
	}
	
	@Override
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public void eat()
	{
		System.out.println("Fish will be eaten by you.");
	}
	
	@Override
	public void play()
	{
		System.out.println("Fish cannot play with you.");
	}
	
	@Override
	public void walk()
	{
		System.out.println("Fish doesn't have legs and cannot walk.");
	}

}
