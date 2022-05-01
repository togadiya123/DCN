import java.net.*;  
import java.io.*;  

class ParityBitS
{
	public static void main(String args[])
	{
	       try
	       {
	    	  Scanner sc = new Scanner(System.in);
	    	  System.out.println("Enter a Message :");
	    	  String msg = sc.nextLine();
	    	  
	    	  String sendmsg = "";
	    	  int counter = 0 ;
	    	  String temp = "";
	    	  //String temp2 = "";
	    	  
	    	  for(int i = 0; i<msg.length(); i++)
	    	  {
	    		    char ch = msg.charAt(i);
	    		    temp = Integer.toBinaryString(ch);
	    		   	System.out.println(msg.charAt(i) + " = " + temp);
	    		    temp = temp + evenParity(temp);
	    		    sendmsg = sendmsg + temp;
	    		    
	    		    System.out.println("With Parity Bit " + msg.charAt(i) + " = " + temp);
	    			
	    			
	    	  } 
		System.out.println("destuff= "+ destuff);
		din.close();
		ss.close();
		}
		catch (Exception e)
	{
		System.out.println(e);
	}
}
}