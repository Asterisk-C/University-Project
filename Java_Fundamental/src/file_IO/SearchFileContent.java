package file_IO;

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
				String fileContent = readFileContent(file);
				if(fileContent.contains(key))
					System.out.printf("找到子目标字符串%s,在文件:%s%n",key,file);
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
	
	public static String readFileContent(File file){
        try (FileReader fr = new FileReader(file)) {
            char[] all = new char[(int) file.length()];
            fr.read(all);
            return new String(all);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
 
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		File folder = new File("E:\\Java");
        search(folder,"HashMap");

	}

}
