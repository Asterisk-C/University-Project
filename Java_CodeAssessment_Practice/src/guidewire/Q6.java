package guidewire;

public class Q6 
{
	public int solution(int[] D, int X) 
    {
        // write your code in Java SE 8
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int days = 1;

        for(int i = 0; i < D.length; i++)
        {
            if(D[i] > max)
            max = D[i];

            if(D[i] < min)
            min = D[i];

            if(Math.abs(max - min) > X)
            {
                days++;
                max = D[i];
                min = D[i];
            }
        }

        return days;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
