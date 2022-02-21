import java.io.*;
import java.net.*;
import java.util.*;

class Q5Client{
    public static void main(String[] args) throws Exception
    {
        try
        {
            Socket s = new Socket("localhost",6565);

            DataInputStream is = new DataInputStream(s.getInputStream());
            DataOutputStream os = new DataOutputStream(s.getOutputStream());
            String clientmsg="",servermsg="";
            Scanner s1 = new Scanner(System.in);

            while(true)
            {
                System.out.print("You    : ");
                clientmsg = s1.nextLine();
                os.writeUTF(clientmsg);
                os.flush();

                if(clientmsg.equals("bye"))
                {
                    break;
                }


                servermsg = is.readUTF();
                System.out.println("server : "+servermsg);


            }
            os.close();
            is.close();
            s.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
