import java.net.*; import java.io.*;
import java.util.Scanner; import java.lang.Math;

class sender_hamming
{
    public static void main(String args[]) throws Exception
    {
        try{
            DatagramSocket ds1 = new DatagramSocket();

            Scanner sc = new Scanner(System.in); System.out.print("Enter Length of data:"); int databits = sc.nextInt();

            int rbits = 0; System.out.println("\nCalculating rbits:"); while(Math.pow(2,rbits) < databits+rbits+1)
            {


                1");

                System.out.println("2^" + rbits + " < " +databits+" + "+rbits+" +

                        rbits++;
            }


            int totalbits = databits + rbits; System.out.println("\nData bits: "+databits); System.out.println("Redundent Bits: "+rbits); System.out.println("Total Bits: "+totalbits);

//create array and store the data int data[] = new int[databits+1];

//data stored in reverse order System.out.println("\nEnter data into array:"); for(int i=databits; i>=1; i--)
            {
                data[i] = sc.nextInt();
            }
            System.out.println();

//printing array
            System.out.println("\n *****data array:*****"); for(int i=1;i<=databits; i++)
            {

                System.out.print("\tdata["+i+"] = "+data[i]);
            }
            System.out.println();

//create array & store hamming code int hcode[] = new int[totalbits+1];

//set values in hamming code
            for(int i=1, x=0, k=1; i<=totalbits; i++)
            {
                if(Math.pow(2, x) == i)
                {
                    hcode[i] = 0; x++;
                }
                else
                {
                    hcode[i]=data[k]; k++;
                }
            }
//printing hcode array
            System.out.println("\n *****hcode array:*****"); for(int i=1;i<=totalbits;i++)
            {
                System.out.print("\thcode["+i+"] = "+hcode[i]);
            }
            System.out.println();

//calculating value of rbits for(int i=1,x=0; i<=totalbits;i++)
            {
                if(Math.pow(2,x)==i)

                {
                    int counter = 0; System.out.println("\nrbits index : "+i);

                    for(int sindex=i; sindex<=totalbits; sindex=sindex+i+i)
                    {
                        for(int index=sindex,cinc=1; index<=totalbits && cinc<=i; index++,cinc++)
                        {
                            System.out.print("\tp["+index+"] : "+hcode[index]); if(hcode[index] == 1)
                        {
                            counter++;
                        }
                        }
                    }
                    if(counter % 2 != 0)
                    {
                        hcode[i]=1;
                    }
                    else
                    {
                        hcode[i]=0;
                    }
                    x++;
                }
            }

//print final hamming code System.out.print("\n hamming code:\t"); String store = "";
            for(int i=totalbits; i>=1; i--)
            {

                System.out.print(hcode[i]);
                store += Integer.toString(hcode[i]);
            }
            System.out.println();
            InetAddress ip = InetAddress.getByName("localhost"); DatagramPacket dp1 = new
                    DatagramPacket(store.getBytes(),store.length(),ip,6363); ds1.send(dp1);

        }catch(Exception e)
        {System.out.println(e);}
    }

}