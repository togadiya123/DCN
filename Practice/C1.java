import java.io.*;
import java.util.*;
import java.net.*;

class C1 {
    public static void main(String[] args) throws Exception {
        try {
            Socket socket = new Socket("localhost", 6565);

            System.out.println("Connected to server");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            String serverMessage = "";
            String clientMessage = "";

            while(true) {
                serverMessage = in.readUTF();
                System.out.println("Server: "+BitStuffingDecode(serverMessage));

                System.out.print("You: ");
                clientMessage = scanner.nextLine();
                out.writeUTF(BitStuffingEncode(clientMessage));
                out.flush();
            }


        } catch(Exception e) {
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
        return flag+ newMessage + flag;
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