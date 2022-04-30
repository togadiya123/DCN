import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

class p6_client {

    public static void main(String args[]) throws Exception {
        try {
            DatagramSocket ds1 = new DatagramSocket();

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter msg: ");
            String msg = sc.nextLine();

            String kstring = "sahildcnsahildcn";
            SecretKey key = new SecretKeySpec(kstring.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            String cmsg = new String(cipher.doFinal(msg.getBytes()));
            System.out.println("\nCipher msg = " + cmsg);


            InetAddress ip = InetAddress.getByName("localhost");
            DatagramPacket dp1 = new
                    DatagramPacket(cmsg.getBytes(), cmsg.length(), ip, 6363);
            ds1.send(dp1);

            DatagramSocket ds2 = new DatagramSocket(6565);
            byte[] buf = new byte[500];
            DatagramPacket dp2 = new DatagramPacket(buf, 500);
            ds2.receive(dp2);

            String msg1 = new String(buf);
            3111 - Kumbhani Sanket

            System.out.println("server:" + msg1);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

		import java.net.*;import java.io.*;
                import java.util.Scanner;import java.security.*;
                import javax.crypto.*;import javax.crypto.spec.*;

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
