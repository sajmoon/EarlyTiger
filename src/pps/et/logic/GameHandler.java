package pps.et.logic;

import java.util.ArrayList;

import pps.et.server.Server;

public class GameHandler {
	public GameMap map;
	ConnectionInterface connector;
	public ArrayList<Player> players;
	
	public GameHandler(ConnectionInterface i) {
		map = new GameMap();
		players = new ArrayList<Player>();
		connector = i;
	}
	
	public GameMap getMap() {
		return map;
	}
	
	public void addPlayer(Player p) {
		System.out.println("newplayer added" + p.getID() + " size: " + players.size());
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

	public boolean playerAt(int i, int n) {
		for (Player p : players) {
			if ( (p.x == i) && (p.y == n) ) {
				return true;
			}
		}
		return false;
	}
}
