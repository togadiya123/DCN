import java.io.IOException;
import java.net.*;
import java.io.*;
public class Char_count_server 
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket dsoc = new DatagramSocket(1234);
		byte buff[] = new byte[1024];
		DatagramPacket dpack= new DatagramPacket(buff,buff.length);
		dsoc.receive(dpack);
		String stuffmsg=new String(dpack.getData());
		String destuff="";
		int digit=Character.getNumericValue(stuffmsg.charAt(0));
		for(int i=1;i<=digit;i++)
		{
			destuff=destuff+stuffmsg.charAt(i);
		}
		System.out.println("destuff="+destuff);

	}
}