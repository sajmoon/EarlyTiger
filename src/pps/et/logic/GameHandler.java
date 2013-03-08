package pps.et.logic;

import java.util.ArrayList;
import java.util.List;

import pps.et.logic.entity.Entity;

public class GameHandler {
	public GameMap map;
	ConnectionInterface connector;
	public ArrayList<Player> players;

	public GameHandler(ConnectionInterface i) {
		map = new GameMap(this);
		players = new ArrayList<Player>();
		connector = i;
	}

	public GameMap getMap() {
		return map;
	}

	public void addPlayer(Player p) {
		System.out.println("[" + p.getNick() + "(" + p.getID() + ")] joined the game.");
		players.add(p);
	}

	public synchronized void movePlayer(Player player, String direction) {
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
	}
	
	private void addEntity(Player player, String what, int x, int y) {
		map.addEntity(player, what, x, y);
	}

	public void disconnectedUser(Player p) {
		players.remove(p);
	}
	
	public Player getPlayer(int playerId) {
		for (Player p : players) {
			if (p.getID() == playerId) {
				return p;
			}
		}
		return null;
	}

	public void setPos(int playerId, int x, int y) {
		for (Player p : players) {
			if (p.getID() == playerId) {
				p.setPos(x, y);
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

	private Player getPlayerAt(int x, int y) {
		for (Player p : players ) {
			if (p.x == x && p.y == y) {
				return p;
			}
		}
		return null;
	}
	
	public String playerIdAt(int x, int y) {
		Player p = getPlayerAt(x, y);
		if (p != null)
			return p.getNick();
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
	
	public void EntityAction(int x, int y) {
		map.activateEntity(x, y);
	}

	private void doMove(Player p,int x, int y) {
		if (!p.canMove())
			return;
		
		if(x >= 0 && x < map.getSize() && y >= 0 && y < map.getSize()){
			if(map.walkableTile(x,y)){
				p.setPos(x,y);
			}else
				System.out.println("[GAME] Not a valid move");
		}
	}

	public void build(Player player, String what, int x, int y) {
		addEntity(player, what, x, y);
	}

	
	public synchronized List<Entity> getEntities() {
		return map.getEntities();
	}
	
	/**
	 * Inflict damage on a point
	 * @params by
	 * @param x
	 * @param y
	 * @param damage
	 */
	public void attack(Player by, int x, int y , int damage) {
		
		if (map.canAttack(x, y)) {
			Player p = getPlayerAt(x, y);
			
			if (p!= null)
				p.attack(damage);
			
			addEntity(by, "Damage", x, y );
		}
	}
}
