//Name : Mansi Dungariya   roll no : 3168
//Program 1(Client)
import java.io.*;
import java.net.*;
import java.util.Scanner;
class p1_client
{
	public static void main(String args[]) throws Exception
	{
		try
		{
			Socket socket=new Socket("localhost",6363);
			DataOutputStream outstream=new DataOutputStream(socket.getOutputStream());
			String msg="",op="",finalmsg="";
			int counter=0,i,j;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter message:");
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
				if(counter%2==0)
					op+='0';
				else
					op+='1';
				finalmsg += op;
				System.out.println("Character : "+op);
				
			}
			System.out.println("After adding parity bit:"+finalmsg);
			
			outstream.writeUTF(finalmsg);
			outstream.flush();
			outstream.close();
			socket.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}