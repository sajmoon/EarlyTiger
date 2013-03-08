package pps.et.logic.entity;

import pps.et.logic.GameHandler;
import pps.et.logic.Player;

public class Mine extends Entity {
	private int damage;
	private int range;
	
	public Mine(Player p, GameHandler g, int x, int y) {
		super(p, g, x, y);
		type = "Mine";
		damage = 100;
		typeCode = 2;
		range = 2;
		setActivationTime(10);
		System.out.println("[" + owner.getNick() + "] Placed a mine.");
	}
	
	public void action() {
		// Mine goes off.
		System.out.println(getIdentifier() + " goes BOOM! ");

		for (int i = (int)getPoint().getX() - 2; i < (int)getPoint().getX() + 2; i++) {
			game.attack( i, (int)getPoint().getY(), damage);
		}
		
		for (int i = (int)getPoint().getY() - 2; i < (int)getPoint().getY() + 2; i++) {
			game.attack( (int)getPoint().getX(), i, damage);
		}
		
		makeInvisible();
	}
}
