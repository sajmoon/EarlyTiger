package pps.et.logic;

import java.util.ArrayList;

import pps.et.server.Server;

public class GameHandler {
	public GameMap map;
	ConnectionInterface connector;
	ArrayList<Player> players;
	
	public GameHandler(ConnectionInterface i) {
		map = new GameMap();
		players = new ArrayList<Player>();
		connector = i;
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
		
		//server.sendToAll("[" + player.getNick() + "] moved");
	}

	public void disconnectedUser(Player p) {
		players.remove(p);
		//connector.disconnectedUser(p);
	}

	public void setPos(int playerId, int x, int y) {
		for (Player p : players) {
			if (p.getID() == playerId) {
				p.x = x;
				p.y = y;
			}
		}
	}
	
	public void send(String text) {
		connector.send(text);
	}
}
