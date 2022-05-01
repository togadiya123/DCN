import java.net.*;  
import java.io.*; 
class bit_stuffing
{
	public static void main(String args[]) throws Exception
	{
			Socket s=new Socket("localhost",3333);  
			DataInputStream din=new DataInputStream(s.getInputStream());  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
	    		System.out.println("Enter the string as 1 or 0");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
			String data=br.readLine(); 
			String flag="01111110";
			String esc="0";
			int count=0;
			String stuffdata="";
			String destuff="";
			for(int i=0; i<data.length(); i++)
			{
				if(data.charAt(i)=='1')
				{
					count++;
					stuffdata=stuffdata+data.charAt(i);
					
				}
				else
				{
					stuffdata=stuffdata+data.charAt(i);
					count=0;
				    
					
				}
				if(count==5)
				{
					stuffdata=stuffdata+'0';
					count=0;
					
					
				}
				
		    }
			stuffdata=flag+stuffdata+flag;
			System.out.println("flag="+flag);
			System.out.println("esc="+esc);
			System.out.println("stuffdata="+stuffdata);
			
			dout.writeUTF(stuffdata);  
dout.flush();  
dout.close();  
s.close();  
}
}
		
			
			