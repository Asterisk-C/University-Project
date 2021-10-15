package collection;

import java.util.LinkedList;
import collection.Hero;

public class MyStack implements Stack
{
	
	LinkedList<Hero> list = new LinkedList<Hero>();
	
	public void push(Hero hero)
	{
		list.addLast(hero);
	}
	public Hero pull()
	{
		return list.removeLast();
	}
	public Hero checkTopHero()
	{
		return list.getLast();
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MyStack test = new MyStack();
		Hero h1 = new Hero("Chris Paul");
		test.push(h1);
		Hero h2 = new Hero("JJ Redick");
		test.push(h2);
		Hero h3 = new Hero("Andre Iguodala");
		test.push(h3);
		System.out.println(test.checkTopHero());
		test.pull();
		System.out.println(test.checkTopHero());
	}

}
