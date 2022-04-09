import java.io.*;
import java.net.*;
import java.util.*;

class Server02 {
    public static void main(String[] args) throws Exception{
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8080);
            System.out.println("Server is running...");

            byte[] buffer = new byte[1024];

            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);

            System.out.println("Client : " + new String(datagramPacket.getData()));

            Scanner scanner = new Scanner(System.in);
            System.out.print("You : ");
            String string = scanner.nextLine();

            DatagramPacket datagramPacket2 = new DatagramPacket(string.getBytes(), string.getBytes().length, datagramPacket.getAddress(), datagramPacket.getPort());
            datagramSocket.send(datagramPacket2);

        } catch(Exception error) {
            System.out.println("Error: " + error);
        }
    }
}