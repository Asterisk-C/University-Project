package digit_and_string;

public class StrBuffer extends RandomString
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		String str = "My name is ";
//		StringBuffer sb = new StringBuffer(str);
//		sb.append("Xinhao Chen");
//		System.out.println(sb);
//		sb.delete(17, 22);
//		System.out.println(sb);
//		sb.insert(3, "first ");
//		System.out.println(sb);
//		sb.reverse();
//		System.out.println(sb);
//		System.out.println(sb.length()); //内容长度      
//        System.out.println(sb.capacity());//总空间
//        sb.append("$$$$$$");
//        System.out.println(sb.capacity());//增加后的总空间
		String s = "";
		StringBuffer sb = new StringBuffer();
		
		long start1 = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++)
		{
			s += getRandomString(10);
		}
		long end1 = System.currentTimeMillis();
		System.out.println(end1 - start1);
		
		long start2 = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++)
		{
			sb.append(getRandomString(10));
		}
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start2);

	}

}
