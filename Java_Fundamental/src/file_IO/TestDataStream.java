package file_IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestDataStream 
{
	public static void read(File f)
	{
		try(
				FileInputStream fis = new FileInputStream(f);
				DataInputStream dis = new DataInputStream(fis);
		)
		{
			boolean b = dis.readBoolean();
			int i = dis.readInt();
			String s = dis.readUTF();
			
			System.out.println("读取到布尔值: "+b);
            System.out.println("读取到整数: "+i);
            System.out.println("读取到字符串: "+s);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void write(File f)
	{
		try(
				FileOutputStream fos = new FileOutputStream(f);
				DataOutputStream dos = new DataOutputStream(fos);
		)
		{
			dos.writeBoolean(true);
			dos.writeInt(334);
			dos.writeUTF("Li zhi niu bi.");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		File f = new File("E:/Java/University-Project/Java_Fundamental/CBA.txt");
		write(f);
		read(f);

	}

}
