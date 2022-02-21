import java.net.*;
import java.util.*;
import java.io.*;
class Q6Server
{
    public static void main(String args[])throws Exception
    {
        ServerSocket ss= new ServerSocket(9999);
        System.out.println("Server started");
        Socket socket=ss.accept();
        System.out.println("Request accepted");
        InputStream dis=socket.getInputStream();
        byte b[]=new byte[1024];
        dis.read(b);

        String s= new String(b);
        System.out.println("Stuffed data from client:"+s.trim());

        System.out.println("Unstuffed data:");
        String str="";

        for(int i=1;i<(s.trim()).length()-1;i++)
        {
            char ch=s.charAt(i);
            if(ch=='E'||ch=='F')
            {
                ch=s.charAt(i+1);
                str+=ch;
                i++;
            }
            else
            {
                str+=ch;
            }
        }
        System.out.println(str);
    }
}
