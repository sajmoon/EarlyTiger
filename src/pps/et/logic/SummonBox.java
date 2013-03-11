package pps.et.logic;

import pps.et.server.tasks.Task;

public class SummonBox extends Task {
	private int x;
	private int y;
	
	public SummonBox(Player p, int x, int y) {
		super(p);
		this.x = x;
		this.y = y;
	}

	@Override
	public void consume() {
		game.build(null, "Box", x, y);
		server.sendToAll("entity " + x + " "+  y + " box");
	}

}
