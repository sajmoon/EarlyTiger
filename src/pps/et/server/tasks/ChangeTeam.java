package pps.et.server.tasks;

import pps.et.logic.Player;

public class ChangeTeam extends Task {

	public ChangeTeam(Player p) {
		super(p);
	}

	@Override
	public void consume() {
		server.sendToAll("player " + player.getID() + " team " + player.getTeam());
	}
}
