import java.io.*;
import java.net.*;

class Server{
	public static void main(String[] args) throws Exception
	{
		try
		{
			ServerSocket ss = new ServerSocket(6565);
			System.out.println("Server is listening...");
			
			Socket s =ss.accept();
			
			String clientmsg="";
			DataInputStream is = new DataInputStream(s.getInputStream());
			clientmsg = is.readUTF();
			System.out.println("Client : "+clientmsg);
			
			
			String servermsg = clientmsg;
			DataOutputStream os = new DataOutputStream(s.getOutputStream());			
			os.writeUTF(servermsg);
			os.flush();
		
		
			os.close();
			is.close();
			s.close();
			ss.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}