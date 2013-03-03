package pps.et.server;

public class GameHandler {
	GameMap map;
	Server server;
	
	public GameHandler(Server s) {
		server = s;
	}
	
	public void sendChat(String msg) {
		server.sendToAll(msg);
	}
	
}
