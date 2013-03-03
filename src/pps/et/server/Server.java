package pps.et.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
	static int port = 4711;
	static ServerSocket server;
	static ArrayList<ServerConnectionHandler> connections;
	
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Starting server");
		
		connections = new ArrayList<ServerConnectionHandler>();
		
		try {
			server = new ServerSocket(port);
			System.out.println("Connected to port: " + port);
			
			listen();
			
		} catch (IOException e) {
			System.out.println("Could not connect on port");
		} finally {
			server.close();
		}
	}
	
	public static void listen(){
		System.out.println("Waiting for connections..");
		
		Socket tempSocket = null;
		try {
			if((tempSocket = server.accept()) != null){
				System.out.println("Accepted: " + tempSocket.getInetAddress());
				ServerConnectionHandler c = new ServerConnectionHandler(tempSocket);
				connections.add(c);
				Thread t = new Thread(c);
				
				t.start();
				
				System.out.println("started thread");
				
			}
		} catch (Exception e) {
			System.err.println("Listen error");
		}

	}
}
