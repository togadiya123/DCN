import java.io.*;
import java.net.*; import java.util.Scanner;

class server_checksum
{
    public static void main(String[] args) throws Exception
    {

        try
        {



            ServerSocket serversocket = new ServerSocket(6666); System.out.println("server is listening on

                localhost:6666");

            Socket socket = serversocket.accept();

            DataInputStream instream = new DataInputStream(socket.getInputStream());
            DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());

            String rmsg = instream.readUTF(); System.out.println("\nReceive msg ="+rmsg); int len = 4;
// System.out.println(len); String result = "";

            while(result.length()<len)
            {
                result="0"+result;
            }

            for(int i=0;i<rmsg.length();i+=len)
            {
                String temp = rmsg.substring(i,i+len); result = binadd(result,temp);
// System.out.println("result = "+result);
            }
            result = ones(result); System.out.println("final result = "+result);

            int flag=0;
            for(int i=0;i<result.length();i++)
            {
                if(result.charAt(i)!='0') System.out.println("Error");

                else

            }


            flag=1;

            if(flag!=0)
                System.out.println("Run Successfully.");

            ostream.close(); instream.close(); socket.close(); serversocket.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }



    public static String binadd(String a,String b)
    {
        String result = ""; String carry = "0";
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

                        result = "0"+result; carry="1";



                    }
                }
                else
                {

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


            }
            else
            {

            }
        }

        ans = ans+"1";



        ans = ans+"0";

        return ans;
    }
}
import java.io.*;
        import java.net.*; import java.util.Scanner;

class server_checksum
{
    public static void main(String[] args) throws Exception
    {

        try
        {



            ServerSocket serversocket = new ServerSocket(6666); System.out.println("server is listening on

                localhost:6666");

            Socket socket = serversocket.accept();

            DataInputStream instream = new DataInputStream(socket.getInputStream());
            DataOutputStream ostream = new DataOutputStream(socket.getOutputStream());

            String rmsg = instream.readUTF(); System.out.println("\nReceive msg ="+rmsg); int len = 4;
// System.out.println(len); String result = "";

            while(result.length()<len)
            {
                result="0"+result;
            }

            for(int i=0;i<rmsg.length();i+=len)
            {
                String temp = rmsg.substring(i,i+len); result = binadd(result,temp);
// System.out.println("result = "+result);
            }
            result = ones(result); System.out.println("final result = "+result);

            int flag=0;
            for(int i=0;i<result.length();i++)
            {
                if(result.charAt(i)!='0') System.out.println("Error");

                else

            }


            flag=1;

            if(flag!=0)
                System.out.println("Run Successfully.");

            ostream.close(); instream.close(); socket.close(); serversocket.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }



    public static String binadd(String a,String b)
    {
        String result = ""; String carry = "0";
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

                        result = "0"+result; carry="1";



                    }
                }
                else
                {

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


            }
            else
            {

            }
        }

        ans = ans+"1";



        ans = ans+"0";

        return ans;
    }
}