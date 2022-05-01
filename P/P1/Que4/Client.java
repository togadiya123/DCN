import java.io.*;
import java.net.*;
import java.util.*;

class Client{
	public static void main(String[] args) throws Exception
	{
		try
		{
			DatagramSocket ds1 = new DatagramSocket();
			
			String msg;
			Scanner s1 = new Scanner(System.in);
			System.out.print("Enter any Value:- ");
			msg = s1.nextLine();
		
			InetAddress ip = InetAddress.getByName("localhost");
			DatagramPacket dp1 = new DatagramPacket(msg.getBytes(),msg.length(),ip,6565);
			ds1.send(dp1);
			ds1.close();
			
			DatagramSocket ds2 = new DatagramSocket(6667);
			byte[] buf = new byte[50];
			DatagramPacket dp2 = new DatagramPacket(buf,50);
			ds2.receive(dp2);
			
			String str = new String(dp2.getData(),0,dp2.getLength());
			System.out.println("Server : Cube of "+msg+" is : "+str);
			ds2.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}