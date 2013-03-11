package pps.et.logic.entity;

import pps.et.logic.GameHandler;
import pps.et.logic.Player;

public class Barrier extends Entity {

	public Barrier(Player p, GameHandler g, int x, int y) {
		super(p, g, x, y);
		type = "Barrier";
		typeCode = 5;
		destructable = true;
		canWalkOn = false;
	}

	@Override
	public void action() {
		
	}

	@Override
	public void action(Player p) {
	}

	@Override
	public boolean attack() {
		remove();
		return true;
	}
}
