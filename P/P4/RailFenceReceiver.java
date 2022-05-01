import java.util.*;
import java.net.*;
import java.io.*;

class RailFenceReceiver{
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket ds1 = new DatagramSocket(6666);
			System.out.println("Server listening on localhost:6666");
			
			byte[] buf = new byte[20];			
			DatagramPacket dp1 = new DatagramPacket(buf,20);
			ds1.receive(dp1);
			String ciphermsg = new String(buf);
			ciphermsg = ciphermsg.trim();
			System.out.println("Cipher Message From Sender: "+ciphermsg);
			
			//De-cipher process
			int point = 0;
			if(ciphermsg.length() % 2 == 0)
			{
				point = ciphermsg.length()/2;
			}	
			else
			{
				point = ciphermsg.length()/2 + 1;
			}	
			String a = ciphermsg.substring(0,point);
			String b = ciphermsg.substring(point,ciphermsg.length());
			
			String deciphermsg = "";
			
			for(int i=0,x=0,y=0; i<ciphermsg.length(); i++)
			{
				if(i%2 == 0)
				{
					deciphermsg += a.charAt(x);
					x++;
				}
				else
				{
					deciphermsg += b.charAt(y);
					y++;
				}
			}
			System.out.println("De-cipher Message: "+deciphermsg);
			
			DatagramSocket ds2 = new DatagramSocket();
			InetAddress ip = InetAddress.getByName("localhost");
			DatagramPacket dp2 = new DatagramPacket(deciphermsg.getBytes(),deciphermsg.length(),ip,6565);
			ds2.send(dp2);
			
			ds1.close();
			ds2.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}