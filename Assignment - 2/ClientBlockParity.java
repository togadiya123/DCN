import java.io.*;
import java.net.*;
import java.util.*;
class ClientBlockParity{
	public static void main(String args[])throws Exception
	{
		try
		{
			Scanner sc = new Scanner(System.in);
			
			Socket socket = new Socket("localhost",6001);
			DataInputStream istream = new DataInputStream(socket.getInputStream());
			DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());
			
			System.out.print("Enter Any String : ");
			String msg=sc.nextLine();
			char gpmsg[][] = new char[msg.length()+1][8];
			String sendmsg=new String();
			
			for(int i=0;i<msg.length();i++)
			{
				int ch=msg.charAt(i);                    // Store Each Char ASCII Value
				String temp=Integer.toBinaryString(ch); // Convert ASCII Value to Binary Byte
				while(temp.length()<7)
				{
						temp = '0'+ temp;
				}
				temp = temp + evenParity(temp);    // Send String and Check Even Bit Parity or Odd Bit Parity 
				
				
				
				sendmsg = sendmsg + temp;
				for(int j=0;j<temp.length();j++)
				{
					gpmsg[i][j] = temp.charAt(j);
				}
				
				System.out.println("Char : "+msg.charAt(i) + " ASCII :- "+ch+" Binary String With Parity Bit - "+temp);
			}
			
			//System.out.println();
			for(int i = 0;i<8;i++)
			{
				String temp = new String();
				for(int j=0;j<msg.length();j++)
				{
					temp = temp + gpmsg[j][i];
				}
				gpmsg[msg.length()][i]= evenParity(temp);
				
				sendmsg = sendmsg + gpmsg[msg.length()][i];
				
				System.out.println("Column : "+i+" Parity Bit : "+gpmsg[msg.length()][i]);
			}
			System.out.println("Send Binary String        : "+sendmsg);
			
			ostream.writeUTF(sendmsg);
			ostream.flush();

			ostream.close();
			socket.close();
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
				c++;
		}
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