import java.io.*;
import java.net.*;

import java.util.Scanner;

class client_checksum
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            Socket socket = new Socket("localhost",6666);

            DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());
            DataInputStream instream = new DataInputStream(socket.getInputStream());

            Scanner sc = new Scanner(System.in); System.out.print("Enter msg:"); String msg = sc.nextLine(); System.out.print("Enter length:");
// int len = sc.nextInt();
// ostream.writeInt(len); int len = 4;

            String result = new String(); while(result.length()<len)
        {
            result="0"+result;
        }

            while(msg.length()%len!=0)
            {
                msg="0"+msg;
            }

            for(int i=0;i<msg.length();i+=len)
            {
                String temp = msg.substring(i,i+len); System.out.print(result+" + "+temp+" = "); result=binadd(result,temp); System.out.println(result);
// System.out.println("result = "+result);
            }
            System.out.println("result = "+result); result = ones(result);
            System.out.println("result complement = "+result); System.out.println("\nAddition = msg = "+msg+" +
                result = "+result);
                String sendmsg = msg + result;

            ostream.writeUTF(sendmsg); ostream.flush(); System.out.println("sendmsg = "+sendmsg);

            instream.close(); ostream.close(); socket.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }



    public static String binadd(String a,String b)
    {
        String result = "";

        String carry = "0";
        for(int i=a.length()-1;i>=0;i--)
        {

            if(a.charAt(i)==b.charAt(i))
            {
                if(a.charAt(i)=='1')
                {
                    if(carry == "0")
                    {









                    }
                    else
                    {



                    }
else
                    {


                    }

                    result = "0"+result; carry="1";



                    result = "1"+result; carry="1";

                    if(carry=="1")
                    {



                    }
                    else
                    {


                    }
                }

                result = "1"+result; carry="0";



                result = "0"+result; carry="0";

            }
            else
            {




                if(carry=="1")
                {



                }
                else
                {


                }
            }
        }

        result = "0" + result; carry="1";



        result = "1"+ result; carry="0";

        if(carry == "1")
        {
            while(carry.length()<a.length()) carry="0"+carry;
// System.out.print("carry encounter = "); result = binadd(carry,result);
        }
        return result;
    }

    public static String ones(String msg)
    {
        String ans = "";
        for(int i=0;i<msg.length();i++)
        {
            if(msg.charAt(i)=='0')
            {
                ans = ans+"1";

            }
            else
            {

            }
        }

        ans = ans+"0";

        return ans;
    }
}
