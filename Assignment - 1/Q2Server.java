import java.io.*;
import java.net.*;
import java.util.*;

class Q2Server{
    public static void main(String[] args) throws Exception
    {
        try
        {
            DatagramSocket ds1 = new DatagramSocket(6565);
            System.out.println("Server is listening at localhost 6565.");

            byte[] buf = new byte[50];
            DatagramPacket dp1 = new DatagramPacket(buf,50);
            ds1.receive(dp1);
            String msg = new String(buf);
            System.out.println("Client : "+msg);

            DatagramSocket ds2 = new DatagramSocket();
            String msg1 = "Hello, This Message is from server side.";
            InetAddress ip = InetAddress.getByName("localhost");
            DatagramPacket dp2 = new DatagramPacket(msg1.getBytes(),msg1.length(),ip,6666);
            ds2.send(dp2);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
