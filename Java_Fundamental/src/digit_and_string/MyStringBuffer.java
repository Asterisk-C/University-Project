package digit_and_string;

import exception.IndexIsNagetiveException;
import exception.IndexIsOutofRangeException;

public class MyStringBuffer extends RandomString implements IStringBuffer
{ 
	int capacity = 16;
	int length = 0;
	char[] value;
	
	public MyStringBuffer()
	{
		value = new char[capacity];
	}
	
	public MyStringBuffer(String str)
	{
		if(str != null)
			value = str.toCharArray();
		
		length = value.length;
		
		if(capacity < length)
			capacity = length * 2;
	}
	
	//追加字符串
	@Override
	public void append(String str) throws IndexIsNagetiveException, IndexIsOutofRangeException
	{
		insert(length, str);
	}

    //追加字符
	@Override
    public void append(char c) throws IndexIsNagetiveException, IndexIsOutofRangeException
    {
		insert(length, String.valueOf(c));
    }
 
    //指定位置插入字符
	@Override
    public void insert(int pos, char c) throws IndexIsNagetiveException, IndexIsOutofRangeException
    {
    	insert(pos, String.valueOf(c));
    }
     
    //指定位置插入字符串
	@Override
    public void insert(int pos, String str) throws IndexIsNagetiveException, IndexIsOutofRangeException
    {
    	if(pos < 0) 
    		throw new IndexIsOutofRangeException();
    	if(pos > length)
    		throw new IndexIsOutofRangeException();
    	if(str == null)
			return;
		
		// Expend
		while(capacity < length + str.length())
		{
			capacity = (int)((length + str.length()) * 1.5f);
			char[] newValue = new char[capacity];
			System.arraycopy(value, 0, newValue, 0, length);
			value = newValue;
		}
		
		char[] temp = str.toCharArray();
		// Move
		System.arraycopy(value, pos, value, pos + str.length(), length - pos);
		// Copy
		System.arraycopy(temp, 0, value, pos, str.length());
		
		length = length + str.length();
    	
    }
    
    //从开始位置删除剩下的
	@Override
    public void delete(int start) throws IndexIsNagetiveException, IndexIsOutofRangeException
    {
		delete(start, length);
    }
    
    //从开始位置删除到结束位置-1
	@Override
    public void delete(int start, int end) throws IndexIsNagetiveException, IndexIsOutofRangeException
    {
    	if(start < 0 || end < 0)
    		throw new IndexIsNagetiveException();
    	if(start > length || end > length || start >= end)
    		throw new IndexIsOutofRangeException();
    	
    	System.arraycopy(value, end, value, start, length - end);
    	length -= end - start;
    	char[] temp = new char[length];
    	System.arraycopy(value, 0, temp, 0, length);
    	value = temp;
    }
     
    //反转
	@Override
    public void reverse()
    {
		for(int i = 0; i < length / 2; i++)
		{
			char temp = value[i];
			value[i] = value[length -1 - i];
			value[length -1 - i] = temp;
		}
    }
    
    //返回长度
	@Override
    public int length()
    {
    	return length;
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub	
		try
		{
			String s1 = "How are you?";
			MyStringBuffer msb = new MyStringBuffer(s1);
			System.out.println(msb.value);
			msb.append(" I'm fine, thank you, and you?");
			System.out.println(msb.value);
			msb.insert(17, " not ");
			System.out.println(msb.value);
			msb.delete(17, 22);
			System.out.println(msb.value);
			msb.reverse();
			System.out.println(msb.value);
			
			StringBuffer t1 = new StringBuffer();
			MyStringBuffer t2 = new MyStringBuffer(s1);
			
			long start1 = System.currentTimeMillis();
			for(int i = 0; i < 1000000; i++)
			{
				t1.append(getRandomString(10));
			}
			long end1 = System.currentTimeMillis();
			System.out.printf("StringBuffer: %dms", (end1 - start1));
			
			System.out.println();
			
			long start2 = System.currentTimeMillis();
			for(int i = 0; i < 1000000; i++)
			{
				t2.append(getRandomString(10));
			}
			long end2 = System.currentTimeMillis();
			System.out.printf("MyStringBuffer: %dms", (end2 - start2));
		}
		catch(IndexIsNagetiveException e)
		{
			e.printStackTrace();
		}
		catch(IndexIsOutofRangeException e)
		{
			e.printStackTrace();
		}

	}

}
