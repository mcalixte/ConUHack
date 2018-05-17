package androidserver;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable
{
	private Socket connection;
	private Scanner read;
	protected String name;
	public Client(Socket x) throws IOException
	{
		connection = x;
		Thread t2 = new Thread(this);
		read = new Scanner(connection.getInputStream());
		name = read.nextLine();
		t2.start();
	}
	
	public void run()
	{
		while(true)
		{
			if(read.hasNext())
			{
				String key = read.next();
				processRequest(key);
			}
		}
		
		
	}
	
	private void processRequest(String key)
	{
		
	}

}
