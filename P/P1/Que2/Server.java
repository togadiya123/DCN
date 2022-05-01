import java.io.*;
import java.net.*;

class Server
{
	public static void main(String args[]) throws Exception
	{
		try
		{
			ServerSocket serversocket = new ServerSocket(6666);
			Socket socket = serversocket.accept();
			
			DataInputStream inStream = new DataInputStream(socket.getInputStream()); 
			String clientMessage = inStream.readUTF();

			System.out.println("Client Message: " + clientMessage);
			inStream.close(); 
			socket.close();
			serversocket.close();
		} 
		catch (Exception e) 
		{ 
			System.out.println(e);
		}
	}
}

//Mansi Dungariya-3168(B)