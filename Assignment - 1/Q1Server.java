import java.net.*;
import java.io.*;

class Q1Server {
    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(8235);
            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String str1 = "", str2 = "";
            while (!str1.equals("bye")) {
                str1 = dataInputStream.readUTF();
                System.out.println("Client : " + str1);

//                if (str1.equals("bye")) {
//                    System.out.println("====> ( On Server File ) : " + str1 + " || " + str2);
//                    continue;
//                }

                str2 = bufferedReader.readLine();
                dataOutputStream.writeUTF(str2);
                dataOutputStream.flush();
            }
            dataInputStream.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}