package pps.et.logic.entity;

import pps.et.logic.Player;

public class Mine extends Entity {
	public Mine(Player p) {
		super(p);
		type = "Mine";
		setActivationTime(10);

		System.out.println("[" + owner.getNick() + "] Placed a mine.");
	}
	
	public void activate() {
		// Mine goes off.
		System.out.println(getIdentifier() + " goes BOOM!");
		
	}
}
