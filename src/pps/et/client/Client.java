package pps.et.client;

import pps.et.logic.ConnectionInterface;
import pps.et.logic.GameHandler;
import pps.et.logic.Player;

public class Client implements ConnectionInterface {
	static private ClientSwing cs;
	
	static private ClientConnectionHandler cch;
	static private GameHandler game;
	static private String host;
	static private int port = 4711;
	
	public Client(){
		
	}
	
	/**
	 * Start a client
	 * @param args :host :nick
	 */
	public static void main(String[] args) {
		System.out.println("Loading Early Tiger (ET)..");
		
		Client client = new Client();
		String nick = "Random";
		
		if (args.length > 0)
			host = args[0];
		else
			host = "localhost";
		
		if (args.length > 1)
			nick = args[1];		
		
		game = new GameHandler(client);
		Player p = new Player(0, nick, 0, 0);
		
		try {
			
			System.out.println("Connecting to " + host + ":" + port);
			cch = new ClientConnectionHandler(host, port, game, p);
			
			Thread t = new Thread(cch);
			t.start();
			
			// Set nick
			cch.send("nick " + nick);
				
		} catch (Exception e) {
			System.err.println("Error connectiong to server");
		}
		
		cs = new ClientSwing(cch, p, game);
		
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			System.out.println("no sleep");
		}
		
		Thread swing = new Thread(cs);
		swing.start();
		
	}

    public void movePlayer(String direction){
    	System.out.println(direction);
    	//game.send("move " + direction);
    }

	@Override
	public void send(String text) {
		cch.send(text);
	}
}
