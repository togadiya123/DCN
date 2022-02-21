import java.io.*;
import java.net.*;
import java.util.*;

class Q1Server {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket ss = new ServerSocket(6565);
            System.out.println("Server is listening at localhost 6565.");

            Socket s = ss.accept();

            DataInputStream is = new DataInputStream(s.getInputStream());
            DataOutputStream os = new DataOutputStream(s.getOutputStream());
            String clientMsg = "", serverMsg = "";
            Scanner s1 = new Scanner(System.in);

            while (true) {
                clientMsg = is.readUTF();
                System.out.println("Client : " + clientMsg);

                if (clientMsg.equals("bye"))
                    break;

                System.out.print("You    : ");
                serverMsg = s1.nextLine();
                os.writeUTF(serverMsg);
                os.flush();
            }
            os.close();
            is.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
