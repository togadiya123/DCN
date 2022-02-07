import java.io.*;
import java.net.*;
import java.util.*;

public class Q7Client
{
    public static void main(String[] args) throws IOException
    {
        Socket skt=new Socket("localhost",9999);

        InputStream in=skt.getInputStream();
        OutputStream out=skt.getOutputStream();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data");
        String data=sc.nextLine();
        data=data.trim();
        int cnt=0;
        String s="";
        for(int i=0;i<data.length();i++)
        {
            char c=data.charAt(i);
            if(c=='1')
            {
                cnt++;
                if(cnt<5)
                {
                    s=s+c;
                }
                else
                {
                    s=s+c+'0';
                    cnt=0;
                }
            }
            else
            {
                s=s+c;
                cnt=0;
            }
        }
        s="01111110"+" "+s+" "+"01111110";

        System.out.println("Data stuffed in client "+s);
        System.out.println("Sending data to unstuff");
        out.write(s.getBytes());
    }
}
