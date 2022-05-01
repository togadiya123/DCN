import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
class Char_count
{
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);

		DatagramSocket ds = new DatagramSocket();

		InetAddress ip = InetAddress.getLocalHost();
		byte buf[] = null;

		
			String data = sc.nextLine();


		System.out.println("data="+data);
		int length=data.length();
		System.out.println("Length of data="+length);
		String stuffmsg=length + data;
	    System.out.println("stuff-msg="+ stuffmsg);
		
		DatagramPacket DpSend =
				new DatagramPacket(stuffmsg.getBytes(), stuffmsg.length(), ip, 1234);

			// Step 3 : invoke the send call to actually send
			// the data.
			ds.send(DpSend);

	}
}
		
		