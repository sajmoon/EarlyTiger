package pps.et.logic.entity;

import pps.et.logic.Player;

public abstract class Entity {
	protected Player	owner;
	private long		createdAt;
	private long		activeIn;
	protected String	type;
	private boolean		hasBeenActivated;
	private int			id;

	public Entity(Player p) {
		owner = p;
		createdAt = System.currentTimeMillis();
		activeIn = 0;
		type = "Entity";
		hasBeenActivated = false;
	}

	public void setID(int input) {
		id = input;
	}

	protected String getIdentifier() {
		return "[" + type + "-" + getID() + "]";
	}

	protected void setActivationTime(int seconds) {
		activeIn = seconds * 1000;
	}

	public String getType() {
		return type;
	}

	public boolean canActivate() {
		if (!hasBeenActivated
				&& System.currentTimeMillis() > (createdAt + activeIn)) {
			hasBeenActivated = true;
			return true;
		}
		return false;
	}

	private int getID() {
		return id;
	}

	public abstract void activate();
}
