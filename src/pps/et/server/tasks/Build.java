package pps.et.server.tasks;

import pps.et.logic.Player;


public class Build extends Task {
	private String what;
	private String x;
	private String y;
	
	public Build(Player p, String what, String x, String y) {
		super(p);
		this.what 	= what;
		this.x 		= x;
		this.y		= y;
	}

	@Override
	public void consume() {
		System.out.println("Build " + what + " at " + x + " " + y);
	}
}
