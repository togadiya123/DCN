import java.io.*;
import java.net.*;

class Client
{
	public static void main(String[] args) throws Exception
	{ 
		try
		{
			Socket socket = new Socket("localhost", 6666);
			DataOutputStream outStream = new DataOutputStream(socket.getOutputStream()); 
			outStream.writeUTF("Hello from client....!"); 
			outStream.flush();

			outStream.close(); 
			socket.close();
		} 
		catch (Exception e) 
		{ 
			System.out.println(e); 
		}
	}
}

//Mansi Dungariya-3168(B)