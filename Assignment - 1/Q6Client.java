import java.io.*;
import java.net.*;
import java.util.Scanner;
class Q6Client
{
    public static void main(String args[])throws Exception
    {
        Socket socket=new Socket("localhost",9999);
        InputStream dis= socket.getInputStream();
        OutputStream dos= socket.getOutputStream();

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data:");
        String data=sc.next();

        String str="";
        String str1="F";
        for(int i=0;i<data.length();i++)
        {
            char ch=data.charAt(i);
            if(ch=='E'||ch=='F')
            {
                str+='E';
                str+=data.charAt(i);
            }
            else
            {
                str+=data.charAt(i);
            }
        }
        String Final=str1+" "+str+" "+str1;

        System.out.println("Data stuffed in client:"+Final);
        System.out.println("sending to server for unstuffing");
        dos.write(Final.getBytes());
    }
}
