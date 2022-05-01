import java.util.*;
import java.net.*;
import java.io.*;

class RailFenceSender{
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket ds1 = new DatagramSocket();
			
			Scanner sc = new Scanner(System.in);
		
			System.out.print("Enter String: ");
			String msg = sc.nextLine();
		
			String one = "";
			String two = "";
			for(int i=0; i<msg.length(); i++)
			{
				if(i%2 == 0)
				{
					one += msg.charAt(i);
				}
				else
				{
					two += msg.charAt(i);
				}
			}
			String ciphermsg = one + two;
			System.out.println("Cipher Message: "+ciphermsg);
				
			InetAddress ip = InetAddress.getByName("localhost");
			DatagramPacket dp1 = new DatagramPacket(ciphermsg.getBytes(),ciphermsg.length(),ip,6666);
			ds1.send(dp1);
			
			
			
			DatagramSocket ds2 = new DatagramSocket(6565);
			
			byte[] buf = new byte[1024];			
			DatagramPacket dp2 = new DatagramPacket(buf,1024);
			ds2.receive(dp2);
			String deciphermsg = new String(buf);
			deciphermsg = deciphermsg.trim();
			System.out.println("Decipher Message From Receiver: "+deciphermsg);
		
			ds1.close();
			ds2.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}