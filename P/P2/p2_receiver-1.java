//Program 2(Receiver)
import java.io.*;
import java.net.*;
class p2_receiver
{
	public static void main(String args[]) throws Exception
	{
		try
		{
			DatagramSocket ds=new DatagramSocket(6565);
			
			byte[] buf = new byte[1024]; //client data mokle e aama store thasse
			DatagramPacket dp=new DatagramPacket(buf,1024);//Or we can write buf.length instead of 1024
			ds.receive(dp);
			
			int i,j,counter=0;
			String msg=new String(dp.getData(),0,dp.getLength());
			for(i=0;i<msg.length();i+=8)
			{
				String decode=msg.substring(i,i+8);
				System.out.println("Message Checking:"+decode);
				for(j=0;j<decode.length();j++)
				{
					if(decode.charAt(j)=='1')
						counter++;
				}
				if(counter%2!=0)
					System.out.println("Correct message passes of character : "+((i/8)+1));
				else	
					System.exit(0);
				counter=0;
			}
			
			int k;
			String f="",op="";
			for(k=0;k<msg.length();k+=8)
			{
				op=msg.substring(k,k+7);
				System.out.println("After removing parity bit:"+op);
				f+=(char)Byte.parseByte(op,2);
			}
		
			System.out.println("Client Message : " + f);
			ds.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}