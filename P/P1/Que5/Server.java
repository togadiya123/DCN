import java.net.*;  
import java.io.*;  
class Server
{  
	public static void main(String args[])throws Exception
	{  
		try
		{
			ServerSocket ss=new ServerSocket(3333); 
			int counter=0;
	
	while(true)
		{
		Socket s=ss.accept(); 
		counter++;
		System.out.println("CLIENT"+counter+" connected"); 
		clientThread obj=new clientThread(s);
		obj.start();
	}
	}
	catch(Exception e)
	{
  		System.out.println(e);
	}
	}
}
class clientThread extends Thread
{
	Socket s;
	int clientno;
	String str=""; 
	clientThread(Socket s1)
	{
		s=s1;
		
	}
	public void run()
	{	
	try
	{	
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
 
		while(!str.equals("stop"))
		{  
			str=din.readUTF();  
			System.out.println("client says: "+str);  
		}  
		din.close();  
		dout.close();  
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
}
}