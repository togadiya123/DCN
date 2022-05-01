import java.io.*;
import java.util.*;
import java.net.*;

class S1 {
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket serverSocket = new ServerSocket(6565);
            Socket socket = serverSocket.accept();

            System.out.println("Connection established");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream  out = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            String serverMessage = "";
            String clientMessage = "";

            while(true) {
                System.out.print("You: ");
                serverMessage = scanner.nextLine();

                out.writeUTF(BitStuffingEncode(serverMessage));
                out.flush();

                clientMessage = in.readUTF();
                System.out.println("Client: " + BitStuffingDecode(clientMessage));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static String BitStuffingEncode(String message) {
        String flag = "01111110";
        int count = 0;
        String newMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (ch == '1') {
                count++;
                if (count == 5) {
                   newMessage = newMessage +  ch + '0';
                   count = 0;
                } else {
                    newMessage += ch;
                }
            } else {
                newMessage += ch;
                count = 0;
            }
        }
        return flag + newMessage + flag;
    }
    static String BitStuffingDecode(String message) {
        int count = 0;
        String newMessage = "";

        for (int i = 8; i < message.length()-8; i++) {
            char ch = message.charAt(i);
            if (ch == '1') {
                count++;
                if (count == 5) {
                    newMessage += ch;
                    i++;
                    count = 0;
                } else {
                    newMessage += ch;
                }
            } else {
                newMessage += ch;
                count = 0;
            }
        }

        return newMessage;

    }
}