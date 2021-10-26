package guidewire;
//given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
//
//For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
//
//Given A = [1, 2, 3], the function should return 4.
//
//Given A = [−1, −3], the function should return 1.
		
public class M1 
{
	public int solution(int[] A) 
    {
        // write your code in Java SE 8
        for(int i = 0; i < A.length - 1; i++)
        {
            for(int j = 0; j < A.length - 1 - i; j++)
            {
                if(A[j] > A[j + 1])
                {
                    int tmp;
                    tmp = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = tmp;
                }
            }
        }
        
        int n;
        if(A[A.length - 1] <= 0)
        	return 1;
        else
        {
        	if(A[0] <= 0)
            	n = 1;
            else 
            	n = A[0];

            while(n <= A[A.length - 1])
            {
                if(!isContain(A, n))
                	return n;
                n++;
            }
            return A[A.length - 1] + 1;
        }
        
    }

    public static boolean isContain(int arr[], int target)
    {
        for(int i: arr)
        {
            if(i == target)
            	return true;
        }
        return false;
    }

}
