package file_IO;

import java.io.File;
import java.util.Arrays;

public class TraverseFolder 
{
	static long min = Integer.MAX_VALUE;
	static long max = 0;
	static File minFile = null;
	static File maxFile = null;
	
	// Recursion
	public static void traverseFile(File file)
	{
		if(file.isFile())
		{
			if(file.length() != 0 && file.length() < min)
			{
				min = file.length();
				minFile = file;
			}
			if(file.length() > max)
			{
				max = file.length();
				maxFile = file;
			}
			return;
		}
			
		if(file.isDirectory())
		{
			File[] fileList = file.listFiles();
			if(fileList == null)
				return;
			for(File subFile: fileList)
			{
				traverseFile(subFile);
			}		
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		File testF = new File("C:/windows");
		traverseFile(testF);	
		System.out.printf("最大的文件是%s，其大小是%,d字节%n", maxFile.getAbsoluteFile(), max);
        System.out.printf("最小的文件是%s，其大小是%,d字节%n", minFile.getAbsoluteFile(), min);
	}

}
