package guidewire;
//Write a function in Java, given two integers N and K. returns a palindrome of length N which consists of K distinct lower-case.
//
//For example, if N=5 and K=3 function should return any palindrome that is 5 characters long with 3 distinct letters such as, abcba, xyxyx, yqtqy
//
//aaaaa will be wrong in this case.
//
//If N=7 and k=2 than it should return abababa.
//
//Function should return one correct palindrome string from many possibilities that is what required.
//
//Function input should be two values of integer K and N.

public class Q1 
{
	public static String Palindrome(int N,int K)
    {
        if(K==1) //if there is only 1 distinct character required
        {
            char[] ans = new char[N];
            for(int i=0;i<N;i++)
            ans[i] = 'a';
            String str = String.valueOf(ans);
            return str;
        }
        
        if (K > ((N+1)/2)) //if K is greater than (N+1)/2 then no string is possible 
        {
            char[] ans = new char[N];
            for(int i=0;i<N;i++)
            ans[i] = '*';
            String str = String.valueOf(ans);
            return str;
        }
        char[] ans = new char[N];
        int cnt = N/K; //every character will occur N/K times except the last character that occurs N/K + N%K times
        int distinct = 1;
        char c = 'a'; //Starting with character a
        int i = 0; //starting position
        int j = N-1; //ending position
        while(i <= j)
        {
            ans[i] = c;
            ans[j] = c;
            i++;
            j--;
            cnt -= 2;
            if(cnt <= 0)
            {
                if (distinct == K)
                {
                    cnt = N%K;
                }
                else
                {
                    cnt = N/K;
                    c++;
                    distinct++;
                }
            }
        }
        String str = String.valueOf(ans);
        return str;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println(Palindrome(51, 26));
	}

}
