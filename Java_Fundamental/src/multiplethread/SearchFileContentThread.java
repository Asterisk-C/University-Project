package multiplethread;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchFileContentThread extends Thread
{
	private File file;
	private String key;
	
	public SearchFileContentThread(File file, String key)
	{
		this.file = file;
		this.key = key;
	}
	
	public void run()
	{
		String fileContent = readFileContent(file);
		if(fileContent.contains(key))
			System.out.printf("找到子目标字符串%s,在文件:%s%n",key,file);
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

}
