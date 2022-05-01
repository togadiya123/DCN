import java.net.*;  
import java.io.*;  

class Bit_stuff_server
{
	public static void main(String args[]) throws Exception{  
	
		try{
		ServerSocket ss=new ServerSocket(3333); 
		Socket s=ss.accept();
		DataInputStream din=new DataInputStream(s.getInputStream());  
		String stuffdata=(String)din.readUTF();
		String destuff="";
		int count=0;
			for(int i=8;i<stuffdata.length()-8;i++)
			{
				if(stuffdata.charAt(i)=='1')
				{
					count++;
					destuff=destuff+stuffdata.charAt(i);
				}
				else
				{
					count=0;
					destuff=destuff+stuffdata.charAt(i);
				}
				if(count==5)
				{
					i++;
				}
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