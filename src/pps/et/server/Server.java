package pps.et.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
	static int port = 4711;
	static ServerSocket server;
	Thread t;
	
	public static void main(String[] args) {
		System.out.println("Starting server");
		
		Socket client;
		
		try {
			server = new ServerSocket(port);
			System.out.println("Connected to port: " + port);
			
			listen();
			
		} catch (IOException e) {
			System.out.println("Could not connect on port");
		}	
	}
	
	public static void listen(){
		Socket tempSocket = null;
		try {
			if((tempSocket = server.accept()) != null){
				System.out.println("Accepted: " + tempSocket.getInetAddress());
				ServerConnectionHandler c = new ServerConnectionHandler(tempSocket);
				
				c.run();
				System.out.println("started thread");
				
			}
		} catch (Exception e) {
			System.err.println("Listen error");
		}

	}
}
