package hw_exercises;

/*
 * 1.	n ��̨�ף�һ��������1����2����3����
a)	һ���ж������߷�
b)	��a)�����е��߷����г���
c)	����������Ⱥ�˳��ֻ������ϣ�����3��̨�ף�����1������2��������2������1����ͬһ���⣩һ���ж������߷�
d)	��c)�������߷����г���

����4��̨��
�������˳��
1.1.1.1
1.1.2
1.2.1
2.1.1
1.3.
3.1.
2.2
��7��

���������˳��ֻ�������
1.1.1.1
1.1.2
1.3
2.2
��4��

 */
public class I2 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		I2 test = new I2();
		
		System.out.println(test.jumpNumber(50));

	}
	
	public int jumpNumber(int n)
	{
		int result = 0;
		
		if(n <= 0) 
		{
			return 0;
		}
		else if(n == 1) 
		{
			return 1;
		}
		else if(n == 2) 
		{
			return 2;
		}
		else if(n == 3) 
		{
			return 4;
		}
		else
		{		
			for(int i = 4; i <= n; i++)
			{
				result = jumpNumber(i-3) + jumpNumber(i-2) + jumpNumber(i-1);
			}
			return result;
		}
		
	}

}
