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
	private int				x;
	private int				y;
	protected int			typeCode;
	protected GameHandler	game;
	protected boolean		destructable;

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

	public boolean isVisible() {
		return visible;
	}

	public String getPos() {
		return "" + x + " " + y;
	}
	
	protected Point getPoint() {
		return new Point(x, y);
	}

	public boolean isAt(int x, int y) {
		if (this.x == x && this.y == y)
			return true;
		return false;
	}
}
