package pps.et.logic;

public class Player {

	int x;
	int y;
	private int team; // 0 or 1
	private String nick;
	private int id;
	private int health;
	private boolean alive;
	private int level;
	
	public Player(int id, String nick, int team, int x, int y) {
		this.id 	= id;
		this.x 		= x;
		this.y 		= y;
		this.team 	= team;
		this.nick 	= nick;
		this.health = 100;
		this.alive = true;
		this.level = 1;
	}
	
	public String getNick() {
		if (alive)
			return nick;
		return "X-" + nick;	
	}
	
	public void setNick(String input) {
		nick = input;
		System.out.println("new nick!: " + nick);
	}

	public void setPos(int x, int y){
		this.x = x;
		this.y = y;
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

	public int getTeam() {
		return team;
	}
	
	private void setAsDead() {
		alive = false;
	}

	public void attack(int damage) {
		health -= damage;
		if (health <= 0) {
			setAsDead();
		}
	}

	public boolean isAlive(){
		return alive;
	}
	
	public boolean canMove() {
		if (alive)
			return true;
		return false;
	}

	public void levelUp() {
		this.level++;
	}
	
	public int getLevel() {
		return level;
	}
}
