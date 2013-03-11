package pps.et.logic.entity;

import pps.et.logic.GameHandler;
import pps.et.logic.Player;

public class Damage extends Entity {

	public Damage(Player p, GameHandler g, int x, int y) {
		super(p, g, x, y);
		type = "Damage";
		setActivationTime(2); //visa skade ett tag bara
		typeCode = 3;
		if (owner != null)
			System.out.println("[" + owner.getNick() + "] Inflictied damage at " + x + " " + y);
	}

	@Override
	public void action() {
		//TODO Should be removed instead of just invisible
		remove();
		//makeInvisible();
	}

	@Override
	public void action(Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean attack() {
		return true;
	}
}
