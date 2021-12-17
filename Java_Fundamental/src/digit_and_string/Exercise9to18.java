package digit_and_string;

public class Exercise9to18 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// 每个单词的首字母都转换为大写
		String str9 = "let there be light";
		System.out.println(str9);
		String[] strArray9 = str9.split(" ");
		String r9 = "";
		for(String s: strArray9)
		{
			char c = Character.toUpperCase(s.charAt(0));
			s = c + s.substring(1);
			r9 += s + " ";
		}
		r9 = r9.trim();
		System.out.println(r9);
		
		// 英文绕口令
		String str11 = "peter piper picked a peck of pickled peppers";
		String[] strArray11 = str11.split(" ");
		int count = 0;
		for(String s: strArray11)
		{
			if(s.charAt(0) == 'p')
				++count;
		}
		System.out.println(count);
		
		// 间隔大写小写模式
		String str13 = "lengendary";
		char[] c13 = new char[str13.length()];
		String r13 = "";
		for(int i = 0; i < c13.length; i++)
		{
			if(i % 2 == 0)
				c13[i] = Character.toUpperCase(str13.charAt(i));
			else
				c13[i] = str13.charAt(i);
			r13 += c13[i];
		}
		System.out.println(r13);
		
		// 最后一个字母变大写
		char[] c15 = new char[str13.length()];
		for(int i = 0; i < c15.length; i++)
		{
			if(i == c15.length - 1)
				c15[i] = Character.toUpperCase(str13.charAt(i));
			else
				c15[i] = str13.charAt(i);
		}
		String r15 = new String(c15);
		System.out.println(r15);
		
		// 把最后一个two单词首字母大写
		String str17 = "Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
		char[] c17 = str17.toCharArray();
		int index = str17.lastIndexOf("two");
		c17[index] = Character.toUpperCase(c17[index]);
		String r17 = new String(c17);
		System.out.println(r17);
	}

}
