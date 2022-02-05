import java.net.*;
import java.io.*;

class Q1Client {
    public static void main(String args[]) {
        try {
            Socket socket = new Socket("localhost", 8235);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String str1 = "", str2 = "";
            while (!str1.equals("bye")) {
                str1 = bufferedReader.readLine();
                dataOutputStream.writeUTF(str1);
                dataOutputStream.flush();
                str2 = dataInputStream.readUTF();

//                if(str1.equals("bye"))
//                {
//                    System.out.println("====> ( On Client File ) : "+str1+" || "+str2);
//                    continue;
//                }

                System.out.println("Server : " + str2);
            }

            dataOutputStream.close();
            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}