import java.io.*;
import java.net.*;
import java.util.*;

class Q2Client{
    public static void main(String[] args) throws Exception
    {
        try
        {
            DatagramSocket ds1 = new DatagramSocket();

            String msg="Hello, This Message is from client side.";
            InetAddress ip = InetAddress.getByName("localhost");
            DatagramPacket dp1 = new DatagramPacket(msg.getBytes(),msg.length(),ip,6565);
            ds1.send(dp1);

            DatagramSocket ds2 = new DatagramSocket(6666);
            byte[] buf = new byte[50];
            DatagramPacket dp2 = new DatagramPacket(buf,50);
            ds2.receive(dp2);

            String str = new String(buf);
            System.out.println("Server : "+str);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}