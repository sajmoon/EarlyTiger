package pps.et.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
	static int port = 4711;
	ServerSocket server;
	ArrayList<ServerConnectionHandler> connections;
	public static int mapSize = 10;
	GameHandler game;
	
	public static void main(String[] args) throws IOException {
		Server s = new Server();
		
	}
	
	public Server() throws IOException {
		System.out.println("Starting server");
		
		connections = new ArrayList<ServerConnectionHandler>();
		game = new GameHandler(this);
		
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
	
	// Listens to connections and add it to the arraylist
	public void listen(){
		System.out.println("Waiting for connections..");
		
		Socket tempSocket = null;
		boolean running = true;
		
		try {
			while (running) {
				if((tempSocket = server.accept()) != null){
					System.out.println("Accepted: " + tempSocket.getInetAddress());
					ServerConnectionHandler c = new ServerConnectionHandler(tempSocket, game);
					connections.add(c);
					Thread t = new Thread(c);
					
					t.start();
					
					System.out.println("started thread");
					
				}
			}
		} catch (Exception e) {
			System.err.println("Listen error");
		}

	}
	
	public void sendToAll(String msg) {
		for (int i = 0; i < connections.size(); i++) {
			connections.get(i).send(msg);
		}
			
	}
}
