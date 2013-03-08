package pps.et.server.tasks;

import pps.et.logic.Player;

public class ChangeNick extends Task {
	public ChangeNick(Player p) {
		super(p);
	}

	@Override
	public void consume() {
		server.sendToAll("player " + player.getID() + " nick " + player.getNick());
	}
}
