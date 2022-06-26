package linkedlist;


public class ReverseLinkedList 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ReverseLinkedList list = new ReverseLinkedList();
        list.node = new Node(85);
        list.node.next = new Node(15);
        list.node.next.next = new Node(4);
        list.node.next.next.next = new Node(20);
 
        System.out.println("Given Linked list");
        list.printList(node);
        node = list.reverse(node);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(node);

	}
	
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
	
	static Node node;
	
	Node reverse(Node node)
	{
		Node prev = null;
		Node next = null;
		Node curr = node;
		
		while(curr != null)
		{
			next = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = next;
		}
		node = prev;	
		return node;
	}
	
	void printList(Node node)
	{
		while(node != null)
		{
			System.out.print(node.data + " ");
            node = node.next;
		}
	}

}
