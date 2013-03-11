package pps.et.server;

import pps.et.logic.Player;
import pps.et.server.tasks.Task;

public class LevelUp extends Task {
	int level;
	public LevelUp(Player p) {
		super(p);
	}

	@Override
	public void consume() {
		player.levelUp();
		server.sendToAll("player " + player.getID() + " level " + player.getLevel());
		
	}

}
