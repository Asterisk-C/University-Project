package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS 
{
	static class Graph
	{
		private int n;
		private LinkedList<Integer> adj[];
		
		public Graph(int n)
		{
			this.n = n;
			adj = new LinkedList[n];
			for(int i = 0; i < n; i++)
			{
				adj[i] = new LinkedList();
			}
		}
		
		void addEdge(int x, int y)
		{
			adj[x].add(y);
		}
		
		void travBFS(int v)
		{
			LinkedList<Integer> output = new LinkedList<>();
			
			boolean mark[] = new boolean[n];
			
			output.add(v);
			mark[v] = true;
			
			while(output.size() != 0)
			{
				int value = output.poll();
				System.out.print(value + " ");
				
				Iterator<Integer> i = adj[value].listIterator();
				while(i.hasNext())
				{
					int num = i.next();
					if(!mark[num])
					{
						output.add(num);
						mark[num] = true;
					}
				}
			}
		}

	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Graph g = new Graph(4);
		 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Following is Breadth First Traversal "+
                           "(starting from vertex 2)");
 
        g.travBFS(2);

	}

}
