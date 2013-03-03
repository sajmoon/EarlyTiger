package pps.et.server;

import pps.et.logic.GameMap;

public class GameHandler {
	GameMap map;
	Server server;
	
	public GameHandler(Server s) {
		map = new GameMap();
		server = s;
	}
	
	public void sendChat(ServerConnectionHandler connection, String msg) {
		String output = "|" +  connection.getNick() + "| " + msg;
		server.sendToAll(output);
	}

	public GameMap getMap() {
		return map;
	}
	
}
