package pps.et.server;

import java.io.Serializable;

public class GameMap implements Serializable {
	private static final long serialVersionUID = 1955586305740049084L;
	int[][] map;
	
	public GameMap() {
		map = new int[Server.mapSize][Server.mapSize];
		
		populateMap();
	}
	
	private void populateMap() {
		map[5][2] = 1;
		map[5][3] = 1;
		map[5][4] = 1;
		map[5][5] = 1;
	}
	
	public String toString() {
		System.out.println("map tostring");
		StringBuffer sb = new StringBuffer();
		sb.append("GameMap: ");
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
}
