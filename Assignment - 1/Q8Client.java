import java.io.*;
import java.net.*;
import java.util.*;

public class Q8Client
{
    public static void main(String[] args) throws IOException
    {
        DatagramSocket ds=new DatagramSocket();
        String str;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter String");
        str=sc.nextLine();

        byte b[]=(str+"").getBytes();

        InetAddress ia=InetAddress.getLocalHost();
        DatagramPacket dp=new DatagramPacket(b,b.length,ia,9999);
        ds.send(dp);

        byte b1[]=new byte[1024];
        DatagramPacket dp1=new DatagramPacket(b1,b1.length);
        ds.receive(dp1);

        String str1=new String(dp1.getData());
        str1=str1.trim();
        System.out.println("Received From Server " +str1);
        if(str1.length()<10)
        {
            System.out.println("Original data:"+str1.substring(1));
        }
        else
        {
            System.out.println("Original data:"+str1.substring(2));
        }
    }
}
