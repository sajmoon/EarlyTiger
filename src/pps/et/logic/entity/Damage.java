package pps.et.logic.entity;

import pps.et.logic.GameHandler;
import pps.et.logic.Player;

public class Damage extends Entity {

	public Damage(Player p, GameHandler g, int x, int y) {
		super(p, g, x, y);
		setActivationTime(5); //visa skade ett tag bara
		typeCode = 3;
		System.out.println("[" + owner.getNick() + "] Inflictied damage at " + x + " " + y);
	}

	@Override
	public void action() {
		//TODO Should be removed instead of just invisible
		makeInvisible();
	}
}
