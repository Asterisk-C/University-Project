package guidewire;

public class Q3 
{
	static int solution(int X, int Y, int[] A) 
	{
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            if (A[i] == Y)
                nY += 1;
            if (nX == nY && nX!=0 && nY!=0)
                result = i;
        }
        return result;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int[] test = {100, 63, 1, 6, 2, 63};
		System.out.println(solution(100, 63, test));

	}

}
