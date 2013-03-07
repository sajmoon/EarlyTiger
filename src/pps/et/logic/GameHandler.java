package pps.et.logic;

import java.util.ArrayList;

import javax.swing.JLabel;

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

	public synchronized void movePlayer(Player player, String direction) {

		System.out.println("movePlayer");
		if (direction.equals("R"))
			doMove(player, player.getX() + 1, player.getY());
		else if (direction.equals("L"))
			doMove(player, player.getX() - 1 , player.getY());
		else if (direction.equals("U"))
			doMove(player, player.getX(), player.getY() + 1);
		else if (direction.equals("D"))
			doMove(player, player.getX(), player.getY() - 1);
		else 
			System.err.println("ERROR: unknown direction");



		//server.sendToAll("[" + player.getNick() + "] moved");
	}

	public void disconnectedUser(Player p) {
		players.remove(p);
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

	public String playerIdAt(int x, int y) {
		for (Player p : players) {
			if (p.x == x && p.y == y) {
				return p.getNick();
			}
		}
		return "";
	}

	public void disconnectedUserByID(int id) {
		System.out.println("disconnect by id");
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getID() == id) {
				System.out.println("remove player from game");
				players.remove(i);
			}	
		}
	}

	private void doMove(Player p,int x, int y){
		System.out.println("doMove x:" + x + " y: " + y);
		if(x >= 0 && x < map.getSize() && y >= 0 && y < map.getSize()){
			if(map.walkableTile(x,y)){
				p.setPos(x,y);
			}else
				System.out.println("Not valid move");
		}
			
				
	}
}
