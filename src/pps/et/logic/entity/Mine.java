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
		canWalkOn = false;
		
		if(owner == null)
			this.range = 2;
		else
			this.range = owner.getLevel();
		setActivationTime(5);
		
		if(owner != null)
			System.out.println("[" + owner.getNick() + "] Placed a mine.");
	}
	
	public void action() {
		// Mine goes off.
		this.remove();
		
		for (int i = (int)getPoint().getX() - range; i < (int)getPoint().getX() + range + 1; i++) {
			game.attack( owner, i, (int)getPoint().getY(), damage);
		}
		
		for (int i = (int)getPoint().getY() - range; i < (int)getPoint().getY() + range + 1; i++) {
			game.attack( owner, (int)getPoint().getX(), i, damage);
		}
		
		makeInvisible();
	}

	@Override
	public void action(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean attack() {
		// if attacked. Explode!
		action();
		return true;
	}
}
