package guidewire;

import java.util.Arrays;

public class Q7 
{
	public static int solution(int[] A) 
    {
        // write your code in Java SE 8
        int filters = 0;
        double sum = 0.0;
        double goal = 0.0;

        double[] B = Arrays.stream(A).asDoubleStream().toArray();
        for(double b: B)
        {
            sum += b;
        }
        
        System.out.println("Sum: " + sum);

        goal = sum / 2;
        
        System.out.println("Goal: " + goal);

        while(sum > goal)
        {
            Arrays.sort(B);
            sum -= B[B.length - 1]/2;
            B[B.length - 1] = B[B.length - 1]/2;
            filters++;
            System.out.println(sum);
        }

        return filters;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] A = {5, 19, 8, 1};
//		int[] A = {23, 31, 11, 9};
//		double[] B = Arrays.stream(A).asDoubleStream().toArray();
//		Arrays.sort(B);
//		for(double b: B)
//		{
//			System.out.print(b + " ");
//		}
		solution(A);

	}

}
