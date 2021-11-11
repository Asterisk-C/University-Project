package stack;

import java.util.Arrays;

public class ArrayToStack 
{
	private int[] shortage;
	private int capacity;
	private int count;
	private static final int GROW_FACTOR = 2;
	
	public ArrayToStack()
	{
		this.capacity = 8;
		this.shortage = new int[8];
		this.count = 0;
	}
	
	public ArrayToStack(int initialCapacity)
	{
		if (initialCapacity < 1)
            throw new IllegalArgumentException("Capacity too small.");
		this.capacity = initialCapacity;
		this.shortage = new int[initialCapacity];
		this.count = 0;
	}
	
	public void push(int value)
	{
		if(count == capacity)
			extendCapacity();
		shortage[count++] = value;
	}
	
	public int pop()
	{
		if (count == 0)
            throw new IllegalArgumentException("Stack is empty.");
		return shortage[--count];
	}
	
	public void extendCapacity()
	{
		int newCapacity = capacity * GROW_FACTOR;
		shortage = Arrays.copyOf(shortage, newCapacity);
		capacity = newCapacity;
	}
	
	public int peek()
	{
		if (count == 0)
            throw new IllegalArgumentException("Stack is empty.");
		return shortage[count - 1];
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ArrayToStack mystack = new ArrayToStack(4);
		mystack.push(1);
		mystack.push(2);
		mystack.push(3);
		mystack.push(4);
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.peek());
	}

}
