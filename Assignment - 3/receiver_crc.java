import java.net.*; import java.io.*;
import java.util.Scanner;

class receiver_crc
{
    public static void main(String args[]) throws Exception
    {
        try{
            DatagramSocket ds1 = new DatagramSocket(6363); System.out.println("server listening on localhost:6363"); byte[] buf = new byte[500];
            DatagramPacket dp1 = new DatagramPacket(buf,500); ds1.receive(dp1);
            ds1.close();

            String data = new String(dp1.getData(),0,dp1.getLength()); System.out.println("Received msg = "+ data);
            String key = "11";
            String rem = div(data,key); System.out.println("rem = "+rem); int cnt=0;
            for(int i=0;i<rem.length();i++)
            {
                if(rem.charAt(i)=='0') cnt++;
            }
            if(cnt!=0)
                System.out.println("No error -> Successful.");

// DatagramSocket ds2 = new DatagramSocket();
// Scanner s = new Scanner(System.in);

// System.out.println("server:");
// String msg1 = s.nextLine();
// InetAddress ip = InetAddress.getByName("localhost");
// DatagramPacket dp2 = new DatagramPacket(msg1.getBytes(),msg1.length(),ip,6565);
// ds2.send(dp2);
        }catch(Exception e)
        {System.out.println(e);}
    }

    public static String xor(String a, String b)
    {
        String result = "";
        for(int i=1;i<a.length();i++)
        {
            if(a.charAt(i) == b.charAt(i)) result = result + "0";
            else
                result = result + "1";
        }
        return result;
    }

    public static String div(String data, String key)
    {
        int len = key.length(); for(int i=0;i<len-1;i++)
    {
        data = data + "0";
    }

        String zero = ""; for(int i=0;i<len;i++)

    {
        zero = zero + "0";
    }

        String temp = data.substring(0,len); while(len<data.length())
    {
        if(temp.charAt(0)=='1')
            temp = xor(temp,key) + data.charAt(len); else
            temp = xor(temp,zero) + data.charAt(len); len++;
    }

        if(temp.charAt(0)=='1') temp = xor(temp,key);
        else
            temp = xor(temp,zero);

        return temp;
    }
}
