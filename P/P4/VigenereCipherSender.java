import java.util.*;
import java.net.*;
import java.io.*;

class VigenereCipherSender{
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket ds1 = new DatagramSocket();
			
			Scanner sc = new Scanner(System.in);
		
			System.out.print("Enter String: ");
			String msg = sc.nextLine();
			String key = "manage";
			System.out.println("Key: "+key); 
		
			//Set Key
			int x=0;
			while(key.length() < msg.length())
			{
				if(x == key.length())
				{
					x=0;
				}
				key += key.charAt(x);
				x++;
			}
			System.out.println("New Key: "+key);
			
			//Cipher process
			String ciphermsg = "";
			for(int i=0; i<msg.length(); i++)
			{
				int cno = (msg.charAt(i)-97 + key.charAt(i)-97) % 26;
				cno += 97;
				//System.out.println("char: " + char(cno) + " ASCII: " + cno);
				ciphermsg += (char)cno;
			}
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