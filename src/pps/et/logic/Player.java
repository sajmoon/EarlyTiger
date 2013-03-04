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

	public void move(String direction) {
		System.out.println("'" + direction + "'");
		if (direction.equals("R"))
			x++;
		else if (direction.equals( "L"))
			x--;
		else if (direction.equals( "U"))
			y++;
		else if (direction.equals("D"))
			y--;
		else 
			System.err.println("not");
		
		
		System.out.println("player pos: " + getPos());
	}
	
	public String getPos() {
		return "x:" + x + " y:" + y;
	}

	public boolean at(int x, int y) {
		if (this.x == x && this.y == y)
			return true;
		return false;
	}

	public Object getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getID() {
		return id;
	}
}
