package file_IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestPrintWriter 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		File f = new File("E:/Java/University-Project/Java_Fundamental/NBA.txt");
		try(
				FileWriter fw = new FileWriter(f);
				PrintWriter pw = new PrintWriter(fw);
		)
		{
			pw.println("Devin Booker needs to strengthen his defence.");
			pw.println("I like Mikal Bridges so much!");
			pw.println("Deandre Ayton is soft like a cake.");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
