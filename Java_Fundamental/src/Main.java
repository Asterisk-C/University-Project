import java.util.Arrays;

public class Main 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String s = "I wanna fuck with you.";
		System.out.println(s);
/*
		flag:
		for(int n = 0; n < 100; n++)
		{
			System.out.println(n);
			if(n >= 15)
			{				
				break flag;					
			}
			
		}
*/	
		
/*
		int values [] = new int[]{18,62,68,82,65,9};
        //�������
        for (int i = 0; i < values.length; i++) 
        {
            int each = values[i];
            System.out.println(each);
        }
         
        //��ǿ��forѭ������
        int max = 0;
        for (int each : values) 
        {
            if(each > max)
            	max = each;
        }
        System.out.println(max);
*/
		
/*
		int[] a = new int[(int)(Math.random() * 5) + 5];
		int[] b = new int[(int)(Math.random() * 5) + 5];
		
		for(int i = 0; i < a.length; i++)
		{
			a[i] = (int)(Math.random() * 100);
		}
		System.out.println(Arrays.toString(a));
		
		for(int i = 0; i < b.length; i++)
		{
			b[i] = (int)(Math.random() * 100);
		}
		System.out.println(Arrays.toString(b));
		
		int[] c = new int[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		System.out.println(Arrays.toString(c));
*/
//		int a[] = new int[] { 18, 62, 68, 82, 65, 9 };
//		 
//        // copyOfRange(int[] original, int                                                                                                                                                                                                                                                                                                                          from, int to)
//        // ��һ��������ʾԴ����
//        // �ڶ���������ʾ��ʼλ��(ȡ�õ�)
//        // ������������ʾ����λ��(ȡ����)
//        int[] b = Arrays.copyOfRange(a, 0, 3);
// 
//        for (int i = 0; i < b.length; i++) {
//            System.out.print(b[i] + " ");
//        }
	}

}
