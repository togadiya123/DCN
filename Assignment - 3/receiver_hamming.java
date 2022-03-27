import java.net.*; import java.io.*;
import java.util.Scanner; import java.lang.Math; import java.util.Arrays;

class receiver_hamming
{
    public static void main(String args[]) throws Exception
    {
        try{

            DatagramSocket ds1 = new DatagramSocket(6363); System.out.println("server listening on localhost:6363"); byte[] buf = new byte[500];
            DatagramPacket dp1 = new DatagramPacket(buf,500); ds1.receive(dp1);
            ds1.close();

            String data = new String(dp1.getData(),0,dp1.getLength()); System.out.println("Received msg = "+ data);
// int a = Integer.parseInt(data);
// System.out.println(a); int totalbits = data.length(); int rbits = 3;
            int databits = totalbits - rbits;
// System.out.println(totalbits); int rhcode[] = new int[totalbits+1];

//storing data into array for(int i=0;i<totalbits;i++)
            {
                rhcode[i] = data.charAt(i) - '0';
            }
            System.out.println("***** Received Code : *****"); for(int i=0;i<totalbits;i++)
            {
                System.out.print("rhcode["+i+"] : "+rhcode[i]+"\t");
            }
            System.out.println();

//create array to store errorbits int errorindex[] = new int[rbits];

            for(int i=1,x=0,e=0; i<=totalbits; i++)

            {
                if(Math.pow(2,x)==i)
                {
                    int counter = 0;

                    for(int sindex=i; sindex<=totalbits; sindex=sindex+i+i)
                    {
                        for(int index=sindex,cinc=1; index<=totalbits && cinc<=i; index++,cinc++)
                        {


                            "+hcode[index]);

//System.out.println("p["+index+"] :

                            if(rhcode[index] == 1)
                            {

                                counter++;
                            }
                        }
                    }
                    if(counter % 2 != 0)
                    {
                        errorindex[e]=i; e++;
                    }
                    x++;
                }
            }

//check if any error is there or not int sum=0;
            System.out.print("\n errorIndex array values:"); for(int i=0;i<rbits;i++)
            {
                System.out.print(" "+ errorindex[i]);

                sum = sum + errorindex[i];
            }

//if sum < 0 then no error else error if(sum>0)
            {
                System.out.println("\n Error at index: "+ sum);
//correct error, flip the bit at error index (0 to 1) & (1 to 0) if(rhcode[sum]==0)
                rhcode[sum]=1; else
                rhcode[sum]=0;
            }
else
            {
                System.out.println("\nNo error in hamming code.");
            }

            System.out.print("\n final received hamming code: "); for(int i=totalbits; i>=1; i--)
            {
                System.out.print(rhcode[i]);
            }
            System.out.println();

//extarct data from hamming code int rdata[] = new int[databits+1]; for(int i=1,x=1,d=0; i<=totalbits; i++)
            {
                if(Math.pow(2,x)==i)
                {
                    x++;
                }

                else
                {
                    rdata[d] = rhcode[i]; d++;
                }
            }

            System.out.print("\n received Data: "); for(int i = databits; i>=1; i--)
            {
                System.out.print(rdata[i]);
            }
            System.out.println();
        }catch(Exception e)
        {System.out.println(e);}
    }

}