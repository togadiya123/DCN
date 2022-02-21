import java.util.Scanner;
import java.io.*;
import java.net.*;
class p2_sender
{
	public static void main(String args[]) throws Exception
	{
		try
		{
			DatagramSocket ds=new DatagramSocket();
			InetAddress ip = InetAddress.getByName("localhost");
			
			int i,j,ans,counter=0;
			String msg="",op="",finalmsg="";
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter message :");
			msg=sc.nextLine();
			
			for(i=0;i<msg.length();i++)
			{
				op=Integer.toBinaryString(msg.charAt(i));
				counter=0;
				while(op.length()<7)
					op='0'+op;
				for(j=0;j<op.length();j++)
				{
					if(op.charAt(j)=='1')
						counter++;
				}
				if(counter%2!=0)
					op+='0';
				else
					op+='1';
				finalmsg += op;
				System.out.println("Character : "+op);
				
			}
			System.out.println("After adding parity bit:"+finalmsg);
			DatagramPacket dp=new DatagramPacket(finalmsg.getBytes(),finalmsg.length(),ip,6565);
			
			ds.send(dp);
			
			ds.close();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}