package pps.et.logic.entity;

import java.awt.Point;

import pps.et.logic.GameHandler;
import pps.et.logic.Player;

public abstract class Entity {
	protected Player		owner;
	private long			createdAt;
	private long			activeIn;
	protected String		type;
	private boolean			hasBeenActivated;
	private int				id;
	private boolean			visible;
	protected int				x;
	protected int				y;
	protected int			typeCode;
	protected GameHandler	game;
	protected boolean		destructable;
	protected boolean 	canWalkOn;

	public Entity(Player p, GameHandler g, int x, int y) {
		owner = p;
		createdAt = System.currentTimeMillis();
		activeIn = 0;
		type = "Entity";
		hasBeenActivated = true;
		visible = true;
		this.x = x;
		this.y = y;
		typeCode = 0;
		game = g;
		destructable = true;
		canWalkOn = true;
	}

	public boolean isDestructable() {
		return destructable;
	}
	
	public void setID(int input) {
		id = input;
	}

	protected String getIdentifier() {
		return "[" + type + "-" + getID() + "]";
	}

	protected void setActivationTime(int seconds) {
		activeIn = seconds * 1000;
		hasBeenActivated = false;
	}

	public String getType() {
		return type;
	}

	// TODO This should probably not be here
	// Fulhack, as its called in Swedish
	public int getTypeCode() {
		if (isVisible())
			return typeCode;
		return 0;
	}

	protected void makeInvisible() {
		visible = false;
	}
	
	protected void remove() {
		game.map.removeEntity(new Point(x, y));
	}

	public boolean canActivate() {
		if (!hasBeenActivated
				&& System.currentTimeMillis() > (createdAt + activeIn)) {
			hasBeenActivated = true;
			return true;
		}
		return false;
	}

	public int getID() {
		return id;
	}

	/**
	 * What this entity does. If its a bomb it explodes and kills stuff in this
	 * method.
	 */
	public abstract void action();
	
	// Triggered when touched.
	public abstract void action(Player p);
	
	public abstract boolean attack();

	public boolean isVisible() {
		return visible;
	}

	public String getPos() {
		return "" + x + " " + y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	protected Point getPoint() {
		return new Point(x, y);
	}

	public boolean isAt(int x, int y) {
		if (this.x == x && this.y == y)
			return true;
		return false;
	}

	public boolean isWalkable() {
		return canWalkOn;
	}
	
	public long createdAt(){
		return createdAt;
	}
	
	public boolean ignoreDrawing(){
		if(System.currentTimeMillis() > (activeIn + createdAt))
			return true;
		
		return false;
	}
	
}
