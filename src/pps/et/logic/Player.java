package pps.et.logic;

public class Player {

	int x;
	int y;
	int team; // 0 or 1
	String nick;
	
	public Player(String nick) {
		x 		= 0;
		y 		= 0;
		team 	= 0;
		this.nick = nick;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String input) {
		nick = input;
	}
}
