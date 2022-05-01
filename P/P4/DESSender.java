import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

class DESSender{
	public static void main(String[] args)
	{
		try
		{
			Socket s = new Socket("localhost",6666);
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Message: ");
			String msg = sc.nextLine();
			
			DataInputStream is = new DataInputStream(s.getInputStream());
			DataOutputStream os = new DataOutputStream(s.getOutputStream());
			
			KeyGenerator kg = KeyGenerator.getInstance("DES");
			SecretKey key = kg.generateKey();
			
			String keystring = "kssbmdcn";
			SecretKey newkey = new SecretKeySpec(keystring.getBytes(),"DES");

			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(cipher.ENCRYPT_MODE,newkey);
			
			byte ctByte[] = cipher.doFinal(msg.getBytes());
			String ctstring = new String(ctByte);
			String ciphermsg = new String(cipher.doFinal(msg.getBytes()));
			
			System.out.println("\nEncrypted Data: "+ciphermsg);
			os.writeUTF(ciphermsg);
			os.flush();
			
			
			//receive data
			String deciphermsg =  is.readUTF();
			System.out.println("De-cipher Message From Receiver: "+deciphermsg);
			
			os.close();
			is.close();
			s.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}