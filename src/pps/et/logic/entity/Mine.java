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
			this.range = 3;
		else
			this.range = owner.getLevel() + 1;
		setActivationTime(5);
		
		if(owner != null)
			System.out.println("[" + owner.getNick() + "] Placed a mine.");
	}
	
	public void action() {
		// Mine goes off.
		this.remove();
		
		// Middle to left
		for (int i = 0; i < range; i++) {
			if (!game.map.canAttack((int)getPoint().getX()-i, (int)getPoint().getY()))
				break;
			game.attack( owner, (int)getPoint().getX()-i, (int)getPoint().getY(), damage);
		}
		
		// Middle + 1 to right
		for (int i = 1; i < range; i++) {
			if (!game.map.canAttack((int)getPoint().getX()+i, (int)getPoint().getY()))
				break;
			game.attack( owner, (int)getPoint().getX()+i, (int)getPoint().getY(), damage);
		}
		
		// Middle down
		for (int i = 1; i < range; i++) {
			if (!game.map.canAttack((int)getPoint().getX(), (int)getPoint().getY()-i))
				break;
			game.attack( owner, (int)getPoint().getX(), (int)getPoint().getY()-i, damage);
		}
		
		// Middle up
		for (int i = 1; i < range; i++) {
			if (!game.map.canAttack((int)getPoint().getX(), (int)getPoint().getY()+i))
				break;
			game.attack( owner, (int)getPoint().getX(), (int)getPoint().getY()+i, damage);
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
