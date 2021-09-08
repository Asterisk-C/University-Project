/*
Ѱ��ĳ��������������� ��ƽ�ָ�� 0.618���

��ĸ�ͷ��Ӳ���ͬʱΪż��
��ĸ�ͷ��� ȡֵ��Χ��[1-20]
 */
public class GoldenRatio 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int num1 = 0;
		int num2 = 0;
		double minDiff = 1000;
		int range = 20;
		for(int i = 1; i <= range; i++)
		{
			for(int j = 1; j <= range; j++)
			{
				if(i % 2 == 0 && j % 2 == 0)
				{
					continue;
				}
				double diff = ((double)i / (double)j) - 0.618;
				diff = diff < 0 ? 0 - diff : diff;
				
				if(diff < minDiff)
				{
					minDiff = diff;
					num1 = i;
					num2 = j;					
				}			
			}
		}
		System.out.println(num1 + " and " + num2);
		
	}

}
