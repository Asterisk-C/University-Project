package linkedlist;

import java.util.HashSet;

public class removeDuplicates 
{
	static class Node
	{
		int data;
		Node next;
		
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	static void removeDuplicate(Node head)
	{
		HashSet<Integer> hs = new HashSet<>();
		
		Node curr = head;
		Node prev = null;
		
		while(curr != null)
		{
			if(hs.contains(curr.data))
			{
				prev.next = curr.next;
			}
			else
			{
				hs.add(curr.data);
				prev = curr;
			}	
			curr = curr.next;		
		}
	}
	
	static void printList(Node head)
	{
		while(head != null)
		{
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		/* The constructed linked list is:
        10->12->11->11->12->11->10*/
		Node start = new Node(10);
        start.next = new Node(12);
        start.next.next = new Node(11);
        start.next.next.next = new Node(11);
        start.next.next.next.next = new Node(12);
        start.next.next.next.next.next = new Node(11);
        start.next.next.next.next.next.next = new Node(10);
 
        System.out.println(
            "Linked list before removing duplicates :");
        printList(start);
 
        removeDuplicate(start);
 
        System.out.println(
            "\nLinked list after removing duplicates :");
        printList(start);

	}

}
