import java.io.*;
import java.net.*;
import java.util.*;

class Q5Server{
    public static void main(String[] args) throws Exception
    {
        int counter=0;
        try
        {
            ServerSocket ss = new ServerSocket(6565);
            System.out.println("Server is listening at localhost 6565.");

            while(true)
            {
                Socket s= ss.accept();
                counter++;
                System.out.println("\nNew Client-"+ counter +" Connected.");

                clientThread cs = new clientThread(s,counter);
                cs.start();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
class clientThread extends Thread{
    Socket cs = null;
    int clientno;

    clientThread(Socket s, int counter)
    {
        cs=s;
        clientno=counter;
    }
    public void run()
    {
        int counter = 0;
        try{
            DataInputStream is = new DataInputStream(cs.getInputStream());
            DataOutputStream os = new DataOutputStream(cs.getOutputStream());
            String clientmsg="",servermsg="";
            Scanner s1 = new Scanner(System.in);

            while(true)
            {

                clientmsg = is.readUTF();
                System.out.println("Client : "+clientmsg);

                if(clientmsg.equals("bye"))
                {
                    break;
                }

                System.out.print("You : ");
                servermsg = s1.nextLine();
                os.writeUTF(servermsg);
                os.flush();
            }
            cs.close();
            os.close();
            is.close();
            //s.close();
            //ss.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
