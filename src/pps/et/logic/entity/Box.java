package pps.et.logic.entity;

import pps.et.logic.GameHandler;
import pps.et.logic.Player;

public class Box extends Entity {

	public Box(Player p, GameHandler g, int x, int y) {
		super(p, g, x, y);
		typeCode = 4;
		type = "Box";
	}

	public void action() {
		// Timedelayed action
		
	}
	
	public void action(Player p) {
		// triggered
		
		System.out.println("Picked up a box");
		p.levelUp();
		makeInvisible();
		
		this.remove();
		
		
	}
}
