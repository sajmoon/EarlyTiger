package pps.et.server.tasks;

import pps.et.logic.Player;


public class DisconnectedTask extends Task {

	public DisconnectedTask(Player p) {
		super(p);
	}

	@Override
	public void consume() {
		String text = "player " + player.getID() + " disconnected";
		server.send(text);
		game.disconnectedUser(player);
	}
}
