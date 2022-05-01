import java.util.*;
import java.io.*;
import java.net.*;

class C2 {
    public static void main(String[] args) throws Exception {
        try {
            DatagramSocket socket = new DatagramSocket();

            Scanner scanner = new Scanner(System.in);
            String serverMessage = "";
            String clientMessage = "";

            DatagramPacket packet = new DatagramPacket(clientMessage.getBytes(), clientMessage.length(), InetAddress.getLocalHost(), 6565);
            while (true){
                System.out.print("You : ");
                clientMessage = scanner.nextLine();
                packet.setData(clientMessage.getBytes());
                socket.send(packet);
                packet.setData(new byte[1024]);

                socket.receive(packet);
                serverMessage = new String(packet.getData());
                System.out.println("Server : " + serverMessage);
            }

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}