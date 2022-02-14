package multiplethread;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileContent 
{
	public static void search(File file, String key)
	{
		if(file.isFile())
		{
			if(file.getName().toLowerCase().endsWith(".java"))
			{
				new SearchFileContentThread(file, key).start();
			}
		}
		if(file.isDirectory())
		{
			File[] fs = file.listFiles();
			for(File f: fs)
			{
				search(f, key);
			}
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		File folder = new File("E:\\Java");
        search(folder,"HashMap");

	}

}
