import java.io.*;
import java.net.*;
import java.util.*;

class Server03 {
    public static void main(String[] args) throws Exception {
        try {

            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running...");

            Socket socket = serverSocket.accept();

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Client : "+message);
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
            serverSocket.close();



        } catch(Exception error) {
            System.out.println("Error: " + error);
        }
    }
}