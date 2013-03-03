package pps.et.server;

public class GameMap {

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
}
