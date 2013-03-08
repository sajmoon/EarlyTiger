package pps.et.logic.entity;

import pps.et.logic.Player;

public class Wall extends Entity {

	public Wall(Player p, int x, int y) {
		super(p, x, y);
		typeCode = 1;
		type = "Wall";
	}

	@Override
	public void action() {
		// A wall does nothing.
	}
}
