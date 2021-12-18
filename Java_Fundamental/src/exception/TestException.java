package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestException 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		method1();
	}
	
	public static void method1()
	{
				
		try
		{
			method2();
		}
		catch(FileNotFoundException | ParseException e)
		{
			if(e instanceof FileNotFoundException)
				System.out.println("File doesn't exist");
			if(e instanceof ParseException)
				System.out.println("Date format parsing error");
			
			e.printStackTrace();
		}
		finally
		{
			System.out.println("Congratulations! No error!");
		}
	}
	
	public static void method2() throws FileNotFoundException, ParseException
	{
		File f = new File("E:/Github Projects/University-Project/Java_Fundamental/CBA.txt");
		new FileInputStream(f);
		System.out.println("Open successfully");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = sdf.parse("2021-12-17");
		
//        //任何除数不能为0:ArithmeticException
//        int k = 5/0;
         
//        //下标越界异常：ArrayIndexOutOfBoundsException
//        int j[] = new int[5];
//        j[10] = 10;
         
//        //空指针异常：NullPointerException
//        String str = null;
//        str.length();
	}

}
