package pps.et.logic.entity;

import pps.et.logic.Player;

public abstract class Entity {
	protected Player	owner;
	private long		createdAt;
	private long		activeIn;
	protected String	name;

	public Entity(Player p) {
		owner = p;
		createdAt = System.currentTimeMillis();
		activeIn = 0;
	}

	protected void setActivationTime(int seconds) {
		activeIn = seconds * 1000;
	}

	public String getName() {
		return name;
	}
}
