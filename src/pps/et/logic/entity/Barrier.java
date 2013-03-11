package pps.et.logic.entity;

import java.util.Random;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean attack() {
		remove();
		Random r = new Random();
		if (r.nextInt(10)<2) {
			game.build(null, "Box", x, y);
			return false;
		}
		return true;
	}
}
