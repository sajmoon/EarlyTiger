package pps.et.logic;

public class Player {

	int x;
	int y;
	int team; // 0 or 1
	String nick;
	int id;
	
	
	public Player(int id, String nick, int x, int y) {
		this.id 	= id;
		this.x 		= x;
		this.y 		= y;
		this.team 	= team;
		this.nick 	= nick;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String input) {
		nick = input;
	}

	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	@Deprecated
	public synchronized void move(String direction) {
		// TODO check if valid move
		if (direction.equals("R"))
			x++;
		else if (direction.equals("L"))
			x--;
		else if (direction.equals("U"))
			y++;
		else if (direction.equals("D"))
			y--;
		else 
			System.err.println("ERROR: unknown direction");
		
	}
	
	public String getPos() {
		return "" + x + " " + y;
	}

	public boolean isAt(int x, int y) {
		if (this.x == x && this.y == y)
			return true;
		return false;
	}
	
	public int getID() {
		return id;
	}

	public void setID(int newID) {
		id = newID;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
}
