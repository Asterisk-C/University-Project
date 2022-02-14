package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestSocket 
{

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		// TODO Auto-generated method stub
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		System.out.println("Local ip£º" + ip);
		
		Process p = Runtime.getRuntime().exec("ping " + "192.168.0.91");
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine()) != null)
		{
			if(line.length() != 0)
				sb.append(line + "\r\n");
		}
		System.out.println("Return message from command is£º");
        System.out.println(sb.toString());

	}

}
