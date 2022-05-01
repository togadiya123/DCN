import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

class p6_server {
    public static void main(String args[]) throws Exception {

        try {
            DatagramSocket ds1 = new DatagramSocket(6363);
            byte[] buf = new byte[500];
            DatagramPacket dp1 = new DatagramPacket(buf, 500);
            ds1.receive(dp1);
            ds1.close();

            String cmsg = new String(dp1.getData(), 0, dp1.getLength());
            System.out.println("Received msg = " + cmsg);
            DatagramSocket ds2 = new DatagramSocket();
            String kstring = "sahildcnsahildcn";
            SecretKey key = new SecretKeySpec(kstring.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);

            String dcmsg = new String(cipher.doFinal(cmsg.getBytes()));
            System.out.println("\nDe-Cipher msg = " + dcmsg);


            InetAddress ip = InetAddress.getByName("localhost");
            DatagramPacket dp2 = new
                    DatagramPacket(dcmsg.getBytes(), dcmsg.length(), ip, 6565);
            ds2.send(dp2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
