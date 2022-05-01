import java.util.*;
import java.io.*;
import java.net.*;

class S2 {
    public static void main(String[] args) throws Exception {
        try {
            DatagramSocket socket = new DatagramSocket(6565);

            Scanner scanner = new Scanner(System.in);
            String serverMessage = "";
            String clientMessage = "";

            DatagramPacket packet = new DatagramPacket(new byte[1024], 1024,InetAddress.getLocalHost(), 6565);

            while (true){
                System.out.println("++++++++++++++");

                socket.receive(packet);

                clientMessage = new String(packet.getData());
                System.out.println("Client : " + clientMessage);

                System.out.print("You : ");
                serverMessage = scanner.nextLine();
                packet.setData(serverMessage.getBytes());
                socket.send(packet);
                packet.setData(new byte[1024]);
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}