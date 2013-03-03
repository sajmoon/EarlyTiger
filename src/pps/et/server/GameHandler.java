package pps.et.server;

import java.util.ArrayList;

import pps.et.logic.GameMap;
import pps.et.logic.Player;

public class GameHandler {
	public GameMap map;
	Server server;
	ArrayList<Player> players;
	
	public GameHandler(Server s) {
		map = new GameMap();
		players = new ArrayList<Player>();
		server = s;
	}
	
	public void sendChat(ServerConnectionHandler connection, String msg) {
		String output = "|" +  connection.getNick() + "| " + msg;
		server.sendToAll(output);
	}

	public GameMap getMap() {
		return map;
	}
	
	public void addPlayer(Player p) {
		players.add(p);
	}

	public void movePlayer(Player player, String string) {
		//TODO check validity of move
		player.move(string);
	}
	
}
