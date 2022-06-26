package linkedlist;

import java.util.HashSet;
import java.util.LinkedList;

public class DetectLoop 
{
	static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	static Node head;

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		DetectLoop list = new DetectLoop();
		list.push(20);
		list.push(4);
		list.push(15);
		list.push(10);
		list.push(26);
		
//		list.head.next.next.next.next.next = list.head;
		
		if (detection(head))
            System.out.println("Loop found");
        else
            System.out.println("No Loop");

	}
	
	public static boolean detection(Node n)
	{
		HashSet<Node> hashset = new HashSet<>();
		
		while(n != null)
		{
			if(hashset.contains(n))
				return true;
			
			hashset.add(n);
			n = n.next;
		}
		return false;
	}
	
	public static void push(int data)
	{
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

}
