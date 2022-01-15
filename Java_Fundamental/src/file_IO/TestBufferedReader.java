package file_IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TestBufferedReader 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		File f = new File("E:/Java/University-Project/Java_Fundamental/NBA.txt");
		try(
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
		)
		{
			while(true)
			{
				String line = br.readLine();
				if(line == null)
				{
					break;
				}
				System.out.println(line);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
