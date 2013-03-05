package pps.et.client;

import pps.et.logic.GameMap;

public class ClientGameHandler {
	private String nick;
	private GameMap map;
	ClientConnectionHandler csh;
	
	public ClientGameHandler(String nick){
		map = new GameMap();
		this.nick = nick;
		try {
			csh = new ClientConnectionHandler("localhost", 4711);
			Thread t = new Thread(csh);
			t.start();
			
			// Set nick
			csh.send("nick " + nick);
				
		} catch (Exception e) {
			System.err.println("Error connectiong to server");
		}
	}

	public GameMap getMap() {
		return map;
	}
}
