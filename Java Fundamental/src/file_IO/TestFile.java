package file_IO;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Date;
import java.io.IOException;

public class TestFile 
{
	public static void main(String[] args)
	{
		try
		{
			File f = new File("E:/Github Projects/University-Project/Java Fundamental/NBA.txt");
			FileInputStream fs = new FileInputStream(f);
			
			byte[] bArray = new byte[(int) f.length()];
			fs.read(bArray);
			for(byte b: bArray)
			{
				System.out.println(b);
			}
			fs.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
        
//		// Basic command
//		
//		System.out.println("��ǰ�ļ��ǣ�" +f);
//		
//        //�ļ��Ƿ����
//        System.out.println("�ж��Ƿ���ڣ�"+f.exists());
//         
//        //�Ƿ����ļ���
//        System.out.println("�ж��Ƿ����ļ��У�"+f.isDirectory());
//          
//        //�Ƿ����ļ������ļ��У�
//        System.out.println("�ж��Ƿ����ļ���"+f.isFile());
//          
//        //�ļ�����
//        System.out.println("��ȡ�ļ��ĳ��ȣ�"+f.length());
//          
//        //�ļ�����޸�ʱ��
//        long time = f.lastModified();
//        Date d = new Date(time);
//        System.out.println("��ȡ�ļ�������޸�ʱ�䣺"+d);
//        
//        //�����ļ��޸�ʱ��Ϊ1970.1.1 08:00:00
//        f.setLastModified(0);
//          
//        //�ļ�������
//        File f2 =new File("E:/Github Projects/University-Project/Java Fundamental/CBA.exe");
//        f.renameTo(f2);
//        System.out.println("��NBA.exe��������CBA.exe");      
//        System.out.println("ע�⣺ ��Ҫ��pathȷʵ����һ��NBA.exe,\r\n�ſ��Կ�����Ӧ���ļ����ȡ��޸�ʱ�����Ϣ");
//        
//        // ���ַ����������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
//        f.list();
//  
//        // ���ļ��������ʽ�����ص�ǰ�ļ����µ������ļ������������ļ������ļ��У�
//        File[]fs= f.listFiles();
//  
//        // ���ַ�����ʽ���ػ�ȡ�����ļ���
//        f.getParent();
//  
//        // ���ļ���ʽ���ػ�ȡ�����ļ���
//        f.getParentFile();
//        
//        // �����ļ��У�������ļ���skin�����ڣ���������Ч
//        f.mkdir();
//  
//        // �����ļ��У�������ļ���skin�����ڣ��ͻᴴ�����ļ���
//        f.mkdirs();
//  
//        // ����һ�����ļ�,������ļ���skin�����ڣ��ͻ��׳��쳣
//        f.createNewFile();
//        
//        // ���Դ���һ�����ļ�֮ǰ��ͨ�����ᴴ����Ŀ¼
//        f.getParentFile().mkdirs();
//  
//        // �г����е��̷�c: d: e: �ȵ�
//        f.listRoots();
//  
//        // �h���ļ�
//        f.delete();
//  
//        // JVM������ʱ�򣬄h���ļ�����������ʱ�ļ���ɾ��
//        f.deleteOnExit();
        
	}
}
