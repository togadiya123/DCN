import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

class AESReceiver{
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
			System.out.println("\nCipher Message From Sender: "+ciphermsg);
			
			//send data
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			SecretKey key = kg.generateKey();
			
			String keystring = "kssbmdcnahmedaba";
			SecretKey newkey = new SecretKeySpec(keystring.getBytes(),"AES");

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(cipher.DECRYPT_MODE,newkey);
			
			byte ctByte[] = cipher.doFinal(ciphermsg.getBytes());
			String dtstring = new String(ctByte);
			String deciphermsg = new String(cipher.doFinal(ciphermsg.getBytes()));
			System.out.println("Decrypted Data: "+deciphermsg);
			
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