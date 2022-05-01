import java.util.*;
import java.net.*;
import java.io.*;

class MonoAlphabeticReceiver{
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
			
			
			String data = "abcdefghijklmnopqrstuvwxyz";
			String key = "qwertyuiopasdfghjklzxcvbnm";
			
			String ciphermsg = is.readUTF();
			System.out.println("\nCipher Message From Sender: "+ciphermsg);
			
			//De-cipher process
			String deciphermsg = "";
			for(int i=0; i<ciphermsg.length(); i++)
			{
				int chloc = key.indexOf(ciphermsg.charAt(i));
				deciphermsg += data.charAt(chloc);
				//System.out.println("chloc: "+chloc);
			}
			System.out.println("De-cipher Message: "+deciphermsg);
			
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