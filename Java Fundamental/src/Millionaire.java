/*
��������������3000������ƽʱ������ÿ��������1000��Ǯ����Ͷ�ʡ�

Ȼ��������������� ����Ʊ�ͻ��� 21������ŵ���ͨ�����ﵽ��ÿ��20%��Ͷ�ʻر��ʡ�

��ô�������ˣ���ÿ����Ͷ��1000��Ǯ�Ľ��࣬����Ͷ�ʶ����꣬������ﵽ100��
���������㰴��ÿ��12000Ͷ����㣬������ÿ�¼�Ϣ��
*/
public class Millionaire 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		double fundPerYear = 12000;
		double target = 1000 * 1000;
		double sum = 0;
		for(int n = 0; n < 100; n++)
		{
			double interest = fundPerYear * (Math.pow(1.2, n));
			sum += interest;
			if(sum >= target)
			{				
				System.out.println(n);
				System.out.println(sum);
				break;					
			}
			
		}
	}

}
