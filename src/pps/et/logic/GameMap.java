package pps.et.logic;

import java.io.Serializable;

import pps.et.server.Server;

public class GameMap implements Serializable {
	private static final long serialVersionUID = 1955586305740049084L;
	int[][] map;
	private int mapSize = 20;
	
	public GameMap() {
		map = new int[mapSize][mapSize];
		
		populateMap();
	}
	
	private void populateMap() {
		map[5][2] = 1;
		map[5][3] = 1;
		map[5][4] = 1;
		map[5][5] = 1;
		map[4][5] = 1;
		map[3][5] = 1;
		map[7][7] = 1;
		map[7][8] = 1;
		map[9][8] = 1;
		map[5][8] = 1;
		map[6][8] = 1;
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
}

