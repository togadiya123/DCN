import java.io.*;
import java.net.*;

public class Server
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            ServerSocket serversocket=new ServerSocket(6565);
            System.out.println("Server is listening at localhost : 6565");

            Socket socket=serversocket.accept();

            DataInputStream inStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String clientMessage="",serverMessage="";

            while(true)
            {
                clientMessage=inStream.readUTF();
                System.out.println("Client Message : "+clientMessage);

                if(clientMessage.equals("bye"))
                break;

                System.out.println("Server Message : ");
                serverMessage=br.readLine();
                outStream.writeUTF(serverMessage);
                outStream.flush();
            }

            outStream.close();
            inStream.close();
            socket.close();
            serversocket.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

//Mansi Dungariya-3168(B)