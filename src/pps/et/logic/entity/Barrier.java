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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void action(Player p) {
		// TODO Auto-generated method stub
		
	}
}
