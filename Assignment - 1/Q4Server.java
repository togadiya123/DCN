import java.net.*;
class Q4Server
{
    public static void main(String args[]) throws Exception
    {
        DatagramSocket ds=new DatagramSocket(9999);
        System.out.println("Server started");
        byte b1[]=new byte[1024];
        DatagramPacket dp=new DatagramPacket(b1,b1.length);
        ds.receive(dp);

        String str=new String(dp.getData());
        int num=Integer.parseInt(str.trim());
        int ans=num*num*num;

        byte b[]=(ans+"").getBytes();
        InetAddress ia=InetAddress.getLocalHost();
        DatagramPacket dp1=new DatagramPacket(b,b.length,ia,dp.getPort());
        ds.send(dp1);

        System.out.println("Result sent");
    }
}
