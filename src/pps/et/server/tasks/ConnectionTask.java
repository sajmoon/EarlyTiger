package pps.et.server.tasks;

import pps.et.logic.Player;

public class ConnectionTask extends Task {

	public ConnectionTask(Player p) {
		super(p);
	}

	@Override
	public void consume() {
		String text = "player connected " + player.getID() + " " + player.getNick();
//		server.sendToPlayer(player, "connected " + player.getID());
		server.sendToAll(text);
	}

}
