package pps.et.logic.entity;

import pps.et.logic.Player;

public class Mine implements Entity {
	private Player owner;
	
	public Mine(Player p) {
		System.out.println("Buld mine!");
		owner = p;
	}
}
