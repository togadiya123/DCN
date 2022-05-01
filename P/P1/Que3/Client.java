import java.io.*;
import java.net.*;
import java.util.*;

class Client{
	public static void main(String[] args) throws Exception
	{
		try
		{
			Socket s = new Socket("localhost",6565);
			
			String clientmsg="";
			Scanner s1 = new Scanner(System.in);
			DataOutputStream os = new DataOutputStream(s.getOutputStream());			
			System.out.print("Client: ");
			clientmsg = s1.nextLine();
			os.writeUTF(clientmsg);
			os.flush();
			
			String servermsg="";
			DataInputStream is = new DataInputStream(s.getInputStream());
			servermsg = is.readUTF();
			System.out.println("server : "+servermsg);
			
			
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