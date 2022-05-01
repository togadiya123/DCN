import java.util.*;
import java.net.*;
import java.io.*;

class MonoAlphabeticSender{
	public static void main(String[] args)
	{
		try
		{
			Socket s = new Socket("localhost",6666);
			DataOutputStream os = new DataOutputStream(s.getOutputStream());
			DataInputStream is = new DataInputStream(s.getInputStream());
			Scanner sc = new Scanner(System.in);
			
			String data = "abcdefghijklmnopqrstuvwxyz";
			String key = "qwertyuiopasdfghjklzxcvbnm";
		
			System.out.print("Enter String: ");
			String msg = sc.nextLine();
		
			//Cipher process
			String ciphermsg = "";
			for(int i=0; i<msg.length(); i++)
			{
				int chloc = data.indexOf(msg.charAt(i));
				ciphermsg += key.charAt(chloc);
				//System.out.println("chloc: "+chloc);
			}
			System.out.println("\nCipher Message: "+ciphermsg);
				
			os.writeUTF(ciphermsg);
			os.flush();
			
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