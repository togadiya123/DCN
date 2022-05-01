//Mansi Dungariya-3168
import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

class AESSender{
	public static void main(String[] args)
	{
		try
		{
			DatagramSocket ds1 = new DatagramSocket();
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Message: ");
			String msg = sc.nextLine();
			
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			SecretKey key = kg.generateKey();
			
			String keystring = "kssbmdcnahmedaba";
			SecretKey newkey = new SecretKeySpec(keystring.getBytes(),"AES");

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(cipher.ENCRYPT_MODE,newkey);
			
			byte ctByte[] = cipher.doFinal(msg.getBytes());
			String ctstring = new String(ctByte);
			String ciphermsg = new String(cipher.doFinal(msg.getBytes()));
			
			System.out.println("\nEncrypted Data: "+ciphermsg);
			
			InetAddress ip = InetAddress.getByName("localhost");
			DatagramPacket dp1 = new DatagramPacket(ciphermsg.getBytes(),ciphermsg.length(),ip,6666);
			ds1.send(dp1);
			
			//receive data
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