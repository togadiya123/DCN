import java.net.*;
import java.io.*;
import java.util.*;

class Server01 {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running...");

            Socket socket = serverSocket.accept();

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            String clientMessage= "";
            String serverMessage= "";

            while(true) {

                System.out.print("You    : ");
                serverMessage = scanner.nextLine();

                out.writeUTF(serverMessage);
                out.flush();
                clientMessage = in.readUTF();
                System.out.println("Client : " + clientMessage);
            }


        } catch (Exception error){
            System.out.println("error");
        }
    }
}