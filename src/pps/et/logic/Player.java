package pps.et.logic;

public class Player {

	int x;
	int y;
	int team; // 0 or 1
	String nick;
	
	public Player(String nick, int x, int y) {
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
		if (direction == "r")
			x++;
		if (direction == "l")
			x--;
		if (direction == "u")
			y++;
		if (direction == "d")
			y--;
	}
	
	public String getPos() {
		return "x:" + x + " y:" + y;
	}
}
