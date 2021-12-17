package huawei_IRC;

public class TSP 
{
	private double distance[][];
	private static int n;
	double[][] dp = new double[n][(int) Math.pow(2, n-1)];
	double[][] choice = new double[n][(int) Math.pow(2, n-1)];
	public void TSP(double distance[][], int n)
	{
		this.distance = distance;
		this.n = n;
	}
	
	public void solve()
	{
		// Initialize 1st row of dp
		for(int i = 0; i < n; i++)
		{
			dp[i][0] = distance[i][0];
			
		}
		
		for(int j = 1; j < (int) Math.pow(2, n-1); j++)
		{
			for(int i = 0; i < n; i++)
			{
				if(((j >> (i-1)) & 1) == 1)
					continue;
			}
		}
	}
	
	public static boolean isVisited(boolean visited[])
	{
		for(int i = 1; i < n; i++)
		{
			if(visited[i] == false)
				return false;
		}
		return true;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
