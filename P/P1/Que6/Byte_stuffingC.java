import java.net.*;  
import java.io.*; 
class Byte_stuffing
{
	public static void main(String args[]) throws Exception
	{
		Socket s=new Socket("localhost",3333);  
        DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		System.out.println("Enter the string");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
		String a=br.readLine(); 
		char flag='F';
		char esc='E';
		String stuffmsg="";
		System.out.println("msg= "+ a);
		System.out.println("flag= "+ flag);
		System.out.println("esc= "+ esc);
		for(int i=0;i<a.length();i++)
		{
			if(a.charAt(i)=='F' || a.charAt(i)=='E')
			{
				stuffmsg=stuffmsg+'E'+a.charAt(i);
			}
			else
			{
				stuffmsg=stuffmsg+a.charAt(i);
			}
		}
		stuffmsg="F"+stuffmsg+"F";
		System.out.println("stuffmsg= "+ stuffmsg);
       
	    
	
dout.writeUTF(stuffmsg);  
dout.flush();  
dout.close();  
s.close();  
}
}
  
	
 
