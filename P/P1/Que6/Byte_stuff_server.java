import java.net.*;  
import java.io.*;  

class Byte_stuff_server
{
	public static void main(String args[]) throws Exception{  
	
		try{
		ServerSocket ss=new ServerSocket(3333); 
		Socket s=ss.accept();
		DataInputStream din=new DataInputStream(s.getInputStream());  
		String stuffmsg=(String)din.readUTF();
		String destuff="";
		if(stuffmsg.charAt(0)=='F')
		{
			for(int i=1;i<stuffmsg.length();i++)
			{
				if(stuffmsg.charAt(i)=='E')
				{
					i++;
				    destuff=destuff+stuffmsg.charAt(i);
				}
				else if(stuffmsg.charAt(i)=='F')
					break;
				else
					destuff=destuff+stuffmsg.charAt(i);
			}
		}
		System.out.println("destuff= "+ destuff);
		din.close();
		ss.close();
		}
		catch (Exception e)
	{
		System.out.println(e);
	}
}
}