import java.net.*;
import java.io.*;
import java.util.*;

class Client01 {
    public static void main(String[] arg) throws Exception {
        try {
            Socket socket = new Socket("localhost", 8080);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            String clientMessage= "";
            String serverMessage= "";

            while (true) {
                serverMessage = in.readUTF();
                System.out.println("Server : " + serverMessage);

                System.out.print("You    : ");
                clientMessage = scanner.nextLine();
                out.writeUTF(clientMessage);
                out.flush();
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}