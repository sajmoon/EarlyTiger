package pps.et.logic.entity;

import pps.et.logic.GameHandler;
import pps.et.logic.Player;

public class Wall extends Entity {

	public Wall(Player p, GameHandler g, int x, int y) {
		super(p, g, x, y);
		typeCode = 1;
		type = "Wall";
		destructable = false;
		canWalkOn = false;
	}

	@Override
	public void action() {
		// A wall does nothing.
	}
}
