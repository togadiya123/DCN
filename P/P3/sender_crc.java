//Mansi Dungariya-3168(B)
import java.net.*;
import java.io.*;
import java.util.Scanner;

class sender_crc
{
    public static void main(String args[]) throws Exception
    {
        try{
            DatagramSocket ds1 = new DatagramSocket();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Data: ");
            String data = sc.nextLine();
            String key = "11";
            String rem = div(data,key);
            System.out.println("rem = "+rem);
            String sendmsg = data + rem;
            System.out.println("send_msg = "+sendmsg);

            InetAddress ip = InetAddress.getByName("localhost");
            
            DatagramPacket dp1 = new DatagramPacket(sendmsg.getBytes(),sendmsg.length(),ip,6363);
            ds1.send(dp1);

        }catch(Exception e)
        {System.out.println(e);}
    }

    public static String xor(String a, String b)
    {
        String result = "";
        for(int i=1;i<a.length();i++)
        {
            if(a.charAt(i) == b.charAt(i))
                result = result + "0";
            else
                result = result + "1";
        }
        return result;
    }

    public static String div(String data, String key)
    {
        int len = key.length();
        for(int i=0;i<len-1;i++)
        {
            data = data + "0";
        }

        String zero = "";
        for(int i=0;i<len;i++)
        {
            zero = zero + "0";
        }

        String temp = data.substring(0,len);
        while(len<data.length())
        {
            if(temp.charAt(0)=='1')
                temp = xor(temp,key) + data.charAt(len);
            else
                temp = xor(temp,zero) + data.charAt(len);
            len++;
        }

        if(temp.charAt(0)=='1')
            temp = xor(temp,key);
        else
            temp = xor(temp,zero);

        return temp;
    }
}