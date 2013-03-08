package pps.et.logic.entity;

import pps.et.logic.Player;

public class Mine extends Entity {
	public Mine(Player p, int x, int y) {
		super(p, x, y);
		type = "Mine";
		typeCode = 2;
		setActivationTime(10);
		System.out.println("[" + owner.getNick() + "] Placed a mine.");
	}
	
	public void action() {
		// Mine goes off.
		System.out.println(getIdentifier() + " goes BOOM! " + this.isVisible());
		makeInvisible();
		System.out.println(getIdentifier() + " is no more! " + this.isVisible());
	}
}
