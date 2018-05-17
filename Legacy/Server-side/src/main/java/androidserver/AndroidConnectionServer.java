package androidserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AndroidConnectionServer implements Runnable
{
	private ServerSocket server;
	
	public AndroidConnectionServer() throws IOException
	{
		server = new ServerSocket(8000);
		Thread t1 = new Thread(this);
		t1.start();
	}
	
	public void run() 
	{
		while(true)
		{
			try {
				Socket s1 = server.accept();
				new Client(s1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	

}
