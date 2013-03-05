package pps.et.client;

import pps.et.logic.ConnectionInterface;
import pps.et.logic.GameHandler;
import pps.et.logic.Player;

public class Client implements ConnectionInterface {
	static private ClientSwing cs;
	
	static private ClientConnectionHandler cch;
	static private GameHandler game;
	public Client(){
	}
	
	public static void main(String[] args) {
		System.out.println("Loading Early Tiger (ET)..");
		
		Client client = new Client();
		String nick = "Random";
		
		if (args.length > 1) {
			nick = args[0];
		}
		
		game = new GameHandler(client);
		Player p = new Player(0, nick, 0, 0);
//		game.addPlayer(player);
		
		try {
			cch = new ClientConnectionHandler("localhost", 4711, game, p);
			
			Thread t = new Thread(cch);
			t.start();
			
			// Set nick
			cch.send("nick " + nick);
				
		} catch (Exception e) {
			System.err.println("Error connectiong to server");
		}
		
		cs = new ClientSwing(cch, p, game);
		
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
