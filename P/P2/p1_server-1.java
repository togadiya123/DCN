//Program 1(Server)
import java.io.*;
import java.net.*;
class p1_server
{
	public static void main(String args[])throws Exception
	{
		try
		{
			ServerSocket serversocket = new ServerSocket(6363);
			Socket socket=serversocket.accept();
			DataInputStream instream=new DataInputStream(socket.getInputStream());
			DataOutputStream outstream=new DataOutputStream(socket.getOutputStream());
			
			String finalmsg=instream.readUTF();
			int i,j,k,counter=0;
			String f="",op="";
			
			for(i=0;i<finalmsg.length();i+=8)
			{
				String decode=finalmsg.substring(i,i+8);
				System.out.println("Message Checking:"+decode);
				for(j=0;j<decode.length();j++)
				{
					if(decode.charAt(j)=='1')
						counter++;
				}
				if(counter%2==0)
					System.out.println("Correct message passes of character : "+((i/8)+1));
				else
				{
					System.out.println("Please send the message again..");
					System.exit(0);
				}
			}
			System.out.println("Message received successfully...");
			for(k=0;k<finalmsg.length();k+=8)
			{
				op=finalmsg.substring(k,k+7);
				System.out.println("After removing parity bit:"+op);
				f+=(char)Byte.parseByte(op,2);
			}
			System.out.println("Final Message:"+f);
			
			instream.close();
			socket.close();
			serversocket.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}