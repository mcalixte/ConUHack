package server;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import androidserver.AndroidConnectionServer;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args)
	{
		try {
			new AndroidConnectionServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpringApplication.run(Application.class, args);
	}

}
