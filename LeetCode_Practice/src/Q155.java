import java.util.Stack;

public class Q155 
{
	private Stack<Integer> data;
    private Stack<Integer> helper;

    public Q155() {
        data = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int val) {
        data.add(val);
        if(helper.isEmpty() || val <= helper.peek())
            helper.add(val);
    }
    
    public void pop() {
        if(!data.isEmpty()){
            if(data.peek().equals(helper.peek()))
                helper.pop();
            
            data.pop();
        }
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return helper.peek();
    }
    
    public void printHelper()
    {
    	System.out.print("Size of helper is " + helper.size());
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 Q155 obj = new Q155();
		 obj.push(512);
		 obj.push(-1024);
		 obj.push(-1024);
		 obj.push(512);
		 obj.pop();
		 System.out.print(obj.getMin() + " ");
		 obj.printHelper();
		 obj.pop();
		 System.out.print(obj.getMin() + " ");
		 obj.printHelper();
		 obj.pop();
		 System.out.print(obj.getMin() + " ");
		 obj.printHelper();
	}

}
