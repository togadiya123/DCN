import java.io.*;
import java.net.*;
import java.util.*;

class Q1Client {
    public static void main(String[] args) throws Exception {
        try {
            Socket s = new Socket("localhost", 6565);

            DataInputStream is = new DataInputStream(s.getInputStream());
            DataOutputStream os = new DataOutputStream(s.getOutputStream());
            String clientMsg = "", serverMsg = "";
            Scanner s1 = new Scanner(System.in);

            while (true) {
                System.out.print("You    : ");
                clientMsg = s1.nextLine();
                os.writeUTF(clientMsg);
                os.flush();

                if (clientMsg.equals("bye")) {
                    break;
                }


                serverMsg = is.readUTF();
                System.out.println("server : " + serverMsg);


            }
            os.close();
            is.close();
            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
