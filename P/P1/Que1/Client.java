import java.io.*;
import java.net.*;

class Client
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            Socket socket=new Socket("localhost",6565);

            DataInputStream inStream=new DataInputStream(socket.getInputStream());
            DataOutputStream outStream=new DataOutputStream(socket.getOutputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            String clientMessage="",serverMessage="";

            while(true)
            {
                System.out.println("Client Message : ");
                clientMessage=br.readLine();
                outStream.writeUTF(clientMessage);
                outStream.flush();

                if(clientMessage.equals("Bye"))
                break;

                serverMessage=inStream.readUTF();
                System.out.println("Server Message : "+serverMessage);
            }

            outStream.close();
            inStream.close();
            socket.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

//Mansi Dungariya-3168(B)