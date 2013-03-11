package pps.et.logic;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import pps.et.logic.entity.Box;
import pps.et.logic.entity.Damage;
import pps.et.logic.entity.Entity;
import pps.et.logic.entity.Mine;
import pps.et.logic.entity.Wall;

public class GameMap {
	private int mapSize = 20;
	private ArrayList<Entity> entityList;
	private HashMap<Point, Entity> map;
	private GameHandler game;
	
	public static final int FLOOR = 0;
	public static final int WALL = 1;
	
	private int	lastEntityID = 0;
	
	public GameMap(GameHandler g) {
		map 		= new HashMap<Point, Entity>();
		entityList 	= new ArrayList<Entity>();
		
		game = g;
		
		populateMap();
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
			e = new Box(player, game, x, y);
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

	private void populateMap() {
		addEntity(null, "Wall", 3, 2);
		addEntity(null, "Wall", 5, 3);
		addEntity(null, "Wall", 5, 4);
		addEntity(null, "Wall", 5, 5);
		addEntity(null, "Wall", 4, 5);
		addEntity(null, "Wall", 3, 5);
		addEntity(null, "Wall", 7, 7);
		addEntity(null, "Wall", 7, 8);
		addEntity(null, "Wall", 9, 8);
		addEntity(null, "Wall", 5, 8);
		addEntity(null, "Wall", 6, 8);
		
		addEntity(null, "Box", 12, 12);
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
		System.out.println("Can attack?" + x + " " + y);
		Entity e = map.get(new Point(x, y));
		if (e != null) {
			System.out.println("yes");
			return e.isDestructable();
		}	
		return true;
	}

	public void removeEntity(Entity entity, Point at) {
		map.remove(at);
	}
}
