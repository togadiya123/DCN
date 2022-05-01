import java.io.*;
import java.net.*;
import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

class DESReceiver{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket sk = new ServerSocket(6666);
			System.out.println("Server listening on localhost:6666");
			
			Socket s = sk.accept();
			System.out.println("Client got Connected.");
			
			DataInputStream is = new DataInputStream(s.getInputStream());
			DataOutputStream os = new DataOutputStream(s.getOutputStream());
			
			String ciphermsg = is.readUTF();
			System.out.println("\nCipher Message From Sender: "+ciphermsg);
			
			//send data
			KeyGenerator kg = KeyGenerator.getInstance("DES");
			SecretKey key = kg.generateKey();
			
			String keystring = "kssbmdcn";
			SecretKey newkey = new SecretKeySpec(keystring.getBytes(),"DES");

			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
			cipher.init(cipher.DECRYPT_MODE,newkey);
			
			byte ctByte[] = cipher.doFinal(ciphermsg.getBytes());
			String dtstring = new String(ctByte);
			String deciphermsg = new String(cipher.doFinal(ciphermsg.getBytes()));
			
			System.out.println("Decrypted Data: "+deciphermsg);
			os.writeUTF(deciphermsg);
			os.flush();
			
			os.close();
			is.close();
			s.close();
			sk.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}