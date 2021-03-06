package pps.et.server.tasks;

import pps.et.logic.Player;

public class Move extends Task {
	private String direction;
	
	public Move(Player p, String dir) {
		super(p);
		direction = dir;
	}
	
	@Override
	public void consume() {
		game.movePlayer(player, direction);
		//player.move(direction);
		server.sendToAll("player " + player.getID() + " at " + player.getPos());
	}
}
