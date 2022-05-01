import java.util.*;
import java.net.*;
import java.io.*;

class CeasarCipherReceiver{
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
			int key = is.readInt();
			System.out.println("\nCipher Message From Sender: "+ciphermsg);
			
			//De-cipher process
			String deciphermsg = "";

            for(int i = 0; i < ciphermsg.length(); i++)
            {
                char ch = ciphermsg.charAt(i);
				int d = ((((int)ch - key)-97)%26)+97;
                char c = (char)d;
                deciphermsg += c;
            }
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