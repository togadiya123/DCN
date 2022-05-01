import java.util.*;
import java.net.*;
import java.io.*;

class CeasarCipherSender{
	public static void main(String[] args)
	{
		try
		{
			Socket s = new Socket("localhost",6666);
			DataOutputStream os = new DataOutputStream(s.getOutputStream());
			DataInputStream is = new DataInputStream(s.getInputStream());
			Scanner sc = new Scanner(System.in);
		
			System.out.print("Enter String: ");
			String msg = sc.nextLine();
			System.out.print("Enter Key : ");
            int key = sc.nextInt();
		
			//Cipher process
			 String ciphermsg = "";

            for(int i = 0; i < msg.length(); i++)
            {
                char ch = msg.charAt(i);
                char c = (char)(((((int)ch + key)-97)%26)+97);
                ciphermsg += c;
            }
			System.out.println("\nEncrypted Data: "+ciphermsg);
				
			os.writeUTF(ciphermsg);
			os.writeInt(key);
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