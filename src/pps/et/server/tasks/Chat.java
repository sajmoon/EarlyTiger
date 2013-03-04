package pps.et.server.tasks;

import pps.et.logic.Player;

public class Chat extends Task {
	private String text;
	
	public Chat(Player p, String msg) {
		super(p);
		text = msg;
	}

	@Override
	public void consume() {
		server.sendToAllBut(player, text);
	}
}
