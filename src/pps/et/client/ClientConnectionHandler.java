package pps.et.client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import pps.et.logic.ConnectionHandler;
import pps.et.logic.GameHandler;

public class ClientConnectionHandler implements ConnectionHandler{
	
	private Socket 			s;
	private PrintStream  	out;
	private BufferedReader indata;
	private boolean 		active;
	private String 			text;
	private GameHandler 	game;
	
	static BufferedReader in = null;

	
	public ClientConnectionHandler(String ip, int port, GameHandler game){
		this.game 	= game;
		
		active 		= true;
		indata 		= new BufferedReader(new InputStreamReader(System.in));
		
		try {
			s = new Socket(ip,port);
			System.out.println("Connected");
		} catch (Exception e) {
			System.err.println("Connection refused");
		}				
		
		try {
			out = new PrintStream(s.getOutputStream());	
		} catch (Exception e) {
			System.err.println("Init error:" + e.getLocalizedMessage());
		}
	}

	public void run(){
		while(s.isConnected()){
			// Listen if something is sent from the server
			try{
				if(s.getInputStream().available() > 0){
					in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					String data = in.readLine();
					processInput(data);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Closing connection to server");
	}
	
	
	private void processInput(String data) {
		System.out.println("got: " + data);
		String[] inputs = data.split(" ");
		if (inputs[0].equals("player")) {
			if (inputs[2].equals("at")) {
				// "player :id at :x :y
				int playerId = Integer.parseInt(inputs[1]);
				int x = Integer.parseInt(inputs[3]);
				int y = Integer.parseInt(inputs[4]);
				game.setPos(playerId, x, y);
			}
		}
		
	}

	public void send(String message){
		System.err.println("Sending: "+ message);
		out.println(message);
	}
}
