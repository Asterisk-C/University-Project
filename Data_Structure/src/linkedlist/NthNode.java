package linkedlist;

public class NthNode 
{
	public class Node
	{
		int data;
		Node next;
		public Node(int data)
		{
			this.data = data;
			next = null;
		}
	}
	
	Node head;
	
	public Node search(int n)
	{
		Node main_ptr = head;
		Node ref_ptr = head;
		int count = 0;
		
		while(count < n)
		{
			ref_ptr = ref_ptr.next;
			count++;
		}
		
		while(ref_ptr != null)
		{
			ref_ptr = ref_ptr.next;
			main_ptr = main_ptr.next;
		}
		return main_ptr;
	}
	
	public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		NthNode llist = new NthNode();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);
        
        System.out.println(llist.search(3).data);
	}

}
