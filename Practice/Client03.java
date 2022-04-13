import java.io.*;
import java.net.*;
import java.util.*;

class Client03 {
    public static void main(String[] args) throws Exception {
        try {

            Socket socket = new Socket("localhost", 8080);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            String string = "";
            Scanner scanner = new Scanner(System.in);

            System.out.print("You : ");
            string = scanner.nextLine();

            dataOutputStream.writeUTF(string);
            dataOutputStream.flush();

            string = dataInputStream.readUTF();
            System.out.println("Server : " + string);

            dataOutputStream.close();
            dataInputStream.close();
            socket.close();


        } catch(Exception error) {
            System.out.println("Error: " + error);
        }
    }
}