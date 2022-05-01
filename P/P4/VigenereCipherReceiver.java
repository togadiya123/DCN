import java.util.*;
import java.net.*;
import java.io.*;

class VigenereCipherReceiver{
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
			
			String key = "manage";
			System.out.println("Key: "+key);
			
			//Set Key
			int x=0;
			while(key.length() < ciphermsg.length())
			{
				if(x == key.length())
				{
					x=0;
				}
				key += key.charAt(x);
				x++;
			}
			System.out.println("New Key: "+key);
			
			//De-cipher process
			String deciphermsg = "";
			for(int i=0; i<ciphermsg.length(); i++)
			{
				int cno = ((ciphermsg.charAt(i)-97) - (key.charAt(i)-97) + 26) % 26;
				cno += 97;
				//System.out.println("char: " + char(cno) + " ASCII: " + cno);
				deciphermsg += (char)cno;
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