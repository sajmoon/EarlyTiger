package pps.et.logic.entity;

import pps.et.logic.Player;

public class Mine extends Entity {
	public Mine(Player p) {
		super(p);
		setActivationTime(10);
		
		System.out.println("[" + owner.getNick() +" ] Placed a mine.");
	}
}
