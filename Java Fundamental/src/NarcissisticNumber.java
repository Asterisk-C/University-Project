/*
ˮ�ɻ������壺
1. һ����3λ��
2. ÿһλ��������������ǡ�����������������153=1*1*1+5*5*5+3*3*3

Ѱ�����е�ˮ�ɻ���
 */
public class NarcissisticNumber 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		for(int i = 100; i <= 999; i++)
		{
			int x = i / 100;
			int y = i / 10 % 10;
			int z = i % 10;
			
			double cubic = Math.pow(x, 3) + Math.pow(y, 3) + Math.pow(z, 3);
			
			if(cubic == (double)i)
			System.out.println(x + "" + y + "" + z);
		}
		

	}

}
