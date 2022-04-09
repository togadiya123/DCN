import java.io.*;
import java.net.*;
import java.util.*;

class Client02 {
    public static void main(String[] args) throws Exception {
        try {

            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress inetAddress = InetAddress.getByName("localhost");

            Scanner scanner = new Scanner(System.in);
            System.out.print("You : ");
            String clientMessage = scanner.nextLine();

            DatagramPacket datagramPacket = new DatagramPacket(clientMessage.getBytes(), clientMessage.length(), inetAddress, 8080);
            datagramSocket.send(datagramPacket);
            datagramPacket.setData(new byte[1024]);

            datagramSocket.receive(datagramPacket);
            System.out.print("Server : " + new String(datagramPacket.getData()));



        } catch(Exception error) {
            System.out.println("Error: " + error);
        }
    }
}