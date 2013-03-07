package pps.et.logic.entity;

import pps.et.logic.Player;

public abstract class Entity {
	protected Player	owner;
	private long		createdAt;
	private long		activeIn;
	protected String	type;
	private boolean 	hasBeenActivated;

	public Entity(Player p) {
		owner = p;
		createdAt = System.currentTimeMillis();
		activeIn = 0;
		type = "Entity";
		hasBeenActivated = false;
	}

	protected void setActivationTime(int seconds) {
		activeIn = seconds * 1000;
	}

	public String getType() {
		return type;
	}

	public boolean canActivate() {
		if (!hasBeenActivated
				&& System.currentTimeMillis() > (createdAt + activeIn))  {
			hasBeenActivated = true;
			return true;
		}	
		return false;
	}
}
