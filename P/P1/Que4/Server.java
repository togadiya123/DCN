//

import java.io.*;
import java.net.*;
import java.util.*;

class Server{
	public static void main(String[] args) throws Exception
	{
		try
		{
			DatagramSocket ds1 = new DatagramSocket(6565);
			System.out.println("Server is listening...");
			
			byte[] buf = new byte[50];			
			DatagramPacket dp1 = new DatagramPacket(buf,50);
			ds1.receive(dp1);
			String msg = new String(dp1.getData(),0,dp1.getLength());
			System.out.println("Client : Make a cube of number "+msg +".");
			ds1.close();
			
			
			DatagramSocket ds2 = new DatagramSocket();
			int msg1= Integer.parseInt(msg);
			int cube = msg1 * msg1 * msg1;
			String res = String.valueOf(cube);
			InetAddress ip = InetAddress.getByName("localhost");
			DatagramPacket dp2 = new DatagramPacket(res.getBytes(),res.length(),ip,6667);
			ds2.send(dp2);
			ds2.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}