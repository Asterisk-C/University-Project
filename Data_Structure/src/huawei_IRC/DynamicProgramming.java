package huawei_IRC;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * �����Ե����ϵ��� ��Ķ�̬�滮�������TSP����
 * distance�Ǿ������optimalvalue��Ž׶����·��
 * optimalchoice��Ž׶����Ų��ԣ���������ҵ����·��
 */
public class DynamicProgramming {
	private int citynumbers;//������Ŀ
	double s=0;//�ܾ���
	int path[];//���·��������������
	private double[][] distance;
	private double[][] optimalvalue;//�׶����·��ֵ����
	private int[][] optimalchoice;//�׶����Ų��Ծ���
	
	public DynamicProgramming(int citynumbers) {
		this.citynumbers=citynumbers;
	}
	
//	public void printArray(double[][] distance)
//	{
//		this.distance = distance;
//		for(int i = 0; i < distance.length; i++)
//		{
//			for(int j = 0; j < distance[0].length; j++)
//			{
//				System.out.print(distance[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
	
	public void readData(String filename) throws IOException  {
		
		distance=new double[citynumbers][citynumbers];//�������
		String a;
		BufferedReader in=new BufferedReader(new InputStreamReader(
				new FileInputStream(filename)));
		for(int i=0;i<citynumbers;i++) {
			a=in.readLine();//����һ������
			String[] b=a.split(",");//�ָ���ÿ��ֵ
			for(int j = 0; j < b.length; j++)
			{
				distance[i][j] = Double.parseDouble(b[j]);
			}
			
		}
		in.close();
		
		int h=(int)Math.pow(2, citynumbers-1);
		optimalvalue =new double[citynumbers][h];
		optimalchoice =new int[citynumbers][h];
	}
	
	public void solve() 
	{
		double min=Double.MAX_VALUE;//ȷ�������
		int mink=0;
		//�����һ�е�ֵ
		for(int i=0;i<citynumbers;i++) {
			optimalvalue[i][0]=distance[i][0];
		}
		for(int i=1;i<(Math.pow(2, citynumbers-1));i++) {
			for(int j=1;j<citynumbers;j++) {
				int k=0;
				if(judge(i,j)==0) {//ȷ��j��������i����ļ�����
					String a=DynamicProgramming.binary(i,citynumbers-1);
					for(int w=a.length();w>0;w-- ) {
						k=a.charAt(a.length()-w)-48;//kΪ0����1
						if(k==1) {
							k=k*w;//��ʱ��kΪѡ��ļ����е�ĳ��ֵ
							double y=(distance[j][k]+optimalvalue[k][(int)(i-Math.pow(2, k-1))]);
							if(y<min) {
								min=(distance[j][k]+optimalvalue[k][(int)(i-Math.pow(2, k-1))]);
								mink=k;
							}
						}
					}
					if(min<Double.MAX_VALUE) {//ȷ��min�Ƿ�仯���б仯��д�����
						optimalvalue[j][i]=min;
						optimalchoice[j][i]=mink;
						min=Double.MAX_VALUE;
					}
				}
			}
		}
		min=Double.MAX_VALUE;//����min
		int i=(int)(Math.pow(2, citynumbers-1)-1);//�������һ��
		for(int k=citynumbers-1;k>0;k--) {
			double x=(distance[0][k]+optimalvalue[k][(int)(i-Math.pow(2, k-1))]);
			if(x<min) {
				min=x;
				mink=k;
			}
		}
		optimalvalue[0][i]=min;
		optimalchoice[0][i]=mink;
		path=new int[citynumbers+1];
		path[0]=1;
		int c=1;
		for(int j=0;i>0;) {
			j=optimalchoice[j][i];
			i=(int)(i-Math.pow(2, j-1));
			path[c++]=j+1;
		}
		path[c++]=1;
		for(i=0;i<citynumbers;i++) {
			System.out.print(path[i]+" ");
			s=s+distance[path[i]-1][path[i+1]-1];
	   }
		System.out.println(1+" ");
		 System.out.println(s);
//		 printArray(distance);
	}
	
	//�ж�j�Ƿ���i��ʾ�ļ�����
	public int judge(int i,int j) {
		String a=DynamicProgramming.binary(i,citynumbers-1);
		int b=a.charAt(a.length()-j)-48;
		return b;
	}
	
	//����һ��ʮ�����������һ��ָ��λ���Ķ�������ʽ�ַ���
	public static String binary(int decNum ,int digit) {
        String binStr = "";
        for(int i=digit-1;i>=0;i--) {
            binStr +=(decNum>>i)&1;
        }
        return binStr;
    }
	
	public static void main(String[] args) throws IOException{
		long a=System.currentTimeMillis();
		DynamicProgramming tsp=new DynamicProgramming(22);//�������󣬸�����Ҫ��ʼ��10,25��100
		tsp.readData("C://Users//Chen Xinhao//Desktop//Huawei IRC//distance_2.txt");//��ȡ����
		
		tsp.solve();
		long b=System.currentTimeMillis();
		long c=b-a;
		System.out.println("����ʱ��Ϊ:"+c);//�������ʱ��
		
	}
}
 
