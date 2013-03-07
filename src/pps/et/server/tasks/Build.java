package pps.et.server.tasks;

import pps.et.logic.Player;


public class Build extends Task {
	private String what;
	private int x;
	private int y;
	
	public Build(Player p, String what, int x, int y) {
		super(p);
		this.what 	= what;
		this.x 		= x;
		this.y		= y;
	}

	@Override
	public void consume() {
		System.out.println("Build " + what + " at " + x + " " + y);
		game.build(player, what, x, y);
		server.sendToAllBut(player, "player " + player.getID() + " build " + what + " at " + x + " " + y);	
	}
}
