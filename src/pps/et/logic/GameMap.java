package pps.et.logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import pps.et.logic.entity.Barrier;
import pps.et.logic.entity.Box;
import pps.et.logic.entity.Damage;
import pps.et.logic.entity.Entity;
import pps.et.logic.entity.Mine;
import pps.et.logic.entity.Wall;

public class GameMap {
	private int mapSize = 61;
	private CopyOnWriteArrayList<Entity> entityList;
	private ConcurrentHashMap<Point, Entity> map;
	private GameHandler game;
	
	public static final int FLOOR = 0;
	public static final int WALL = 1;
	
	private int	lastEntityID = 0;
	
	public GameMap(GameHandler g) {
		map 		= new ConcurrentHashMap<Point, Entity>();
		entityList 	= new CopyOnWriteArrayList<Entity>();
		
		game = g;
		
		//populateMap();
	}
	
	public void addEntity(Player player, String what, int x, int y) {
		Entity e = null;
		Point p = new Point(x, y);
		if (what.equals("Mine")) {
			e = new Mine(player, game, x, y);
			
		} else if (what.equals("Wall")) {
			e = new Wall(player, game, x, y);
		} else if (what.equals("Damage")) {
			e = new Damage(player, game, x, y);
		} else if (what.equals("Box")) {
			System.out.println("Build box at " + x + " " + y);
			e = new Box(player, game, x, y);
		} else if (what.equals("Barrier")) {
			e = new Barrier(player, game, x, y);
		} else {
			System.out.println("No such thing to build.");
			return; // So nothing to do but end here.
		}
		
		e.setID(getNextEntityID());
		entityList.add(e);
		map.put(p, e);
	}
	
	private synchronized int getNextEntityID() {
		lastEntityID++;
		return lastEntityID;
	}

	public void populateMap() {
		
		
		for (int i = 0; i < mapSize; i++) {
			addEntity(null, "Wall", 0, i);
			addEntity(null, "Wall", mapSize-1, i);
			addEntity(null, "Wall", i, 0);
			addEntity(null, "Wall", i, mapSize -1);
			
			for (int j = 0; j < mapSize; j++) {
				if (i%2 == 0 && j%2 == 0) {
					addEntity(null, "Wall", j,i);
				}
			}
		}
		
		for (int i = 1; i < mapSize-1; i++) {
			for (int j = 5; j < mapSize - 5; j++) {
				if (i%2 != 0 || j%2 != 0)
					addEntity(null, "Barrier", i,j);
				
			}
		}
		
		
//		addEntity(null, "Wall", 3, 2);
//		addEntity(null, "Wall", 5, 3);
//		addEntity(null, "Wall", 5, 4);
//		addEntity(null, "Wall", 5, 5);
//		addEntity(null, "Wall", 4, 5);
//		addEntity(null, "Wall", 3, 5);
//		addEntity(null, "Wall", 7, 7);
//		addEntity(null, "Wall", 7, 8);
//		addEntity(null, "Wall", 9, 8);
//		addEntity(null, "Wall", 5, 8);
//		addEntity(null, "Wall", 6, 8);
//		
//		addEntity(null, "Box", 12, 12);
	}
	
	public int getSize() {
		return mapSize;
	}
	
	private Entity getEntity(int x, int y) {
		return map.get(new Point(x,y));
	}
	
	public int getTileCode(int x, int y) {
		Entity e = map.get(new Point(x, y));
		if (e == null) 
			return 0;
		return e.getTypeCode();
	}
	
	public boolean walkableTile(int x, int y) {
		Entity e = getEntity(x, y);
		if (e == null)
			return true;
		
		return getEntity(x,y).isWalkable();
	}
	
	public boolean hasEntity(int x, int y) {
		Entity e = map.get(new Point(x, y));
		if (e == null)
			return false;
		
		if (e.isVisible()) {
			return true;
		}
		return false;
	}

	/**
	 * Returns a unmodifiableList
	 * for sync reasons
	 * @return
	 */
	public synchronized List<Entity> getEntities() {
        return Collections.unmodifiableList((new ArrayList<Entity>(entityList)));
    }
	
	public void activateEntity(Player p, int x, int y) {
		Entity e = map.get(new Point(x, y));
		
		if ( e == null)
			return;
		
		if (p == null)
			e.action();
		
		e.action(p);
	}

	public boolean canAttack(int x, int y) {
		Entity e = map.get(new Point(x, y));
		if (e != null) {
			return e.isDestructable();
		}	
		return true;
	}

	public void removeEntity(Point at) {
		map.remove(at);
		for (Entity e : getEntities()) {
			if (e.isAt(at.x, at.y))
				entityList.remove(e);
		}
	}

	// true if thing destroyed
	public boolean attack(Player by, int x, int y, int damage) {
		Player p = game.getPlayerAt(x, y);
		
		if (p!= null)
			p.attack(damage);
		
		Entity e = map.get(new Point(x,y));
		if (e != null) {
			if (e.isDestructable()) {
				return e.attack();
			}
		}
		return true;
	}
}
