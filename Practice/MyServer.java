import java.io.*;
import java.net.*;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            Socket socket = ss.accept();//establishes connection
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String str = (String) dis.readUTF();
            System.out.println("message : " + str);
            serverSocket.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}