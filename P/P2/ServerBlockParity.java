

import java.io.*;
import java.net.*;
import java.util.*;
class ServerBlockParity{
	public static void main(String args[])throws Exception
	{
		try
		{
			Scanner sc=new Scanner(System.in);
			ServerSocket serversocket = new ServerSocket(6001);
			System.out.println("Server Is Listening On Localhost : 6001");
			
			Socket socket = serversocket.accept();
			DataInputStream istream = new DataInputStream(socket.getInputStream());
			DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());
			
			String rmsg = new String();
			String omsg  = new String();
			rmsg=istream.readUTF();
			char cpmsg[][] = new char[rmsg.length()/8][8];
			int rowerror =0 , colerror = 0;
			
			
			System.out.println("Received Binary String    : "+rmsg);
			
				
			for(int i=0;i<rmsg.length();i+=8)
			{
				String rtemp = rmsg.substring(i,i+8);
				char p = evenParity(rtemp);
				
				
				if(p == '0')
				{
					System.out.println("Row : " + i/8 + " No Error");
				}
				else
				{
					rowerror++;
					System.out.println("Row : " + i/8 + " Error Detected");
				}
				
				cpmsg[i/8] = rtemp.toCharArray();
				rtemp = rtemp.substring(0,rtemp.length()-1);
				omsg = omsg + (char)Byte.parseByte(rtemp,2);
			}
			for(int j=0;j<8;j++)
			{
				String ctemp = new String();
				for(int i=0;i<rmsg.length()/8;i++)
				{
					ctemp = ctemp + cpmsg[i][j];
				}
				char p = evenParity(ctemp);
				
				
				
				if(p == '0')
				{
					System.out.println("Column : " + j + " No Error");
				}
				else
				{
					colerror++;
					System.out.println("Column : " + j + " Error Detected");
				}
			}
			if(rowerror == 0 && colerror == 0)
			{
				omsg = omsg.substring(0,omsg.length()-1);
				System.out.println("\nOriginal Message : "+omsg);
			}
		
			
			
			
			istream.close();
			socket.close();
			serversocket.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static char evenParity(String msg)
	{
		int c=0;
		
		for(int j=0;j<msg.length();j++)
		{
			if(msg.charAt(j)=='1')
			{
				c++;
			}
		}
		//System.out.println("Counter : "+c);
		if(c%2==0)
		{
			return '0';
		}
		else
		{
			return '1';
		}
	}

}