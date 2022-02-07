import java.io.*;
import java.net.*;
import java.util.*;

public class Q7Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket sr=new ServerSocket(9999);
        System.out.println("Server started");
        Socket skt=sr.accept();
        System.out.println("Request accepted");

        InputStream in=skt.getInputStream();
        byte b[]=new byte[1024];
        in.read(b);

        String str=new String(b);
        str=str.trim();
        System.out.println("Data from client "+str);
        int cnt=0;
        String s="";
        for(int i=8;i<str.length()-8;i++)
        {
            char c=str.charAt(i);
            if(c=='1')
            {
                cnt++;
                if(cnt==5)
                {
                    i++;
                    cnt=0;
                    s=s+c;
                }
                else
                {
                    s=s+c;
                }
            }
            else
            {
                s=s+c;
            }
        }
        System.out.println("Unstuffed data "+s);
    }
}