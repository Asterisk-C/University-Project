package file_IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Removing_Comment 
{
	public static void removeComment(File javaFile)
	{
		StringBuffer sb = new StringBuffer();
		
		// Read
		try(
				FileReader fr = new FileReader(javaFile);
				BufferedReader br = new BufferedReader(fr);
		)
		{
			while(true)
			{
				String line = br.readLine();
				if(line == null)
					break;
				if(!line.trim().startsWith("//"))
					sb.append(line).append("\r\n");
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		// Write
		try(
				FileWriter fw = new FileWriter(javaFile);
				PrintWriter pw = new PrintWriter(fw);
		)
		{
			pw.println(sb.toString());
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		File javaFile = new File("E:/Java/University-Project/Java_Fundamental/Removing_Comment.txt");
		System.out.println(javaFile.exists());
        System.out.println(javaFile.length());
        removeComment(javaFile);
	}

}
