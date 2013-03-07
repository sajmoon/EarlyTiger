package pps.et.logic;

import java.io.Serializable;
import java.util.ArrayList;

import pps.et.logic.entity.Entity;
import pps.et.logic.entity.Mine;

public class GameMap implements Serializable {
	private static final long serialVersionUID = 1955586305740049084L;
	int[][] map;
	private int mapSize = 20;
	private Entity[][] entities;
	
	public final int FLOOR = 0;
	public final int WALL = 1;
	public GameMap() {
		map = new int[mapSize][mapSize];
		entities = new Entity[mapSize][mapSize];
		
		populateMap();
	}
	
	public Entity addEntity(Player player, String what, int x, int y) {
		Entity e = new Mine(player);
		entities[x][y] = e;
		return e;
	}
	
	private void populateMap() {
		map[3][2] = WALL;
		map[5][3] = WALL;
		map[5][4] = WALL;
		map[5][5] = WALL;
		map[4][5] = WALL;
		map[3][5] = WALL;
		map[7][7] = WALL;
		map[7][8] = WALL;
		map[9][8] = WALL;
		map[5][8] = WALL;
		map[6][8] = WALL;
	}
	
	public String toString() {
		System.out.println("map tostring");
		StringBuffer sb = new StringBuffer();
		sb.append(map.length);
		sb.append(" ");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				sb.append(map[i][j] );
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	
	public void fromString(String input) {
		String[] inputs = input.split(" ");
		
		int mapSize = Integer.parseInt( inputs[0] );
		
		map = new int[mapSize][mapSize];
		
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = Integer.parseInt(inputs[i*j+1]);
			}
		}
	}

	public int getSize() {
		return map.length;
	}
	
	public int getTileCode(int x, int y) {
		return map[x][y];
	}
	
	public int at(int i, int j) {
		return map[i][j];
	}

	public boolean walkableTile(int x, int y) {
		if (getTileCode(x,y) == FLOOR)
			return true;
		
		return false;
	}
	
	public boolean hasEntity(int i, int j) {
		if (entities[i][j] != null)
			return true;
		return false;
	}
}
