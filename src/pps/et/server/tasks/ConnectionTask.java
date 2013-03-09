package pps.et.server.tasks;

import pps.et.logic.Player;
import pps.et.logic.entity.Entity;

public class ConnectionTask extends Task {
	public ConnectionTask(Player p) {
		super(p);
	}

	@Override
	public void consume() {
		server.sendToPlayer(player, "you id " + player.getID()); // update player id client side.
		
		String text = "player connected " + player.getID() + " " + player.getNick() + " " + player.getTeam();
		
		server.send(text);
		
		for (Player p : this.game.players) {
			String t = "player connected " + p.getID() + " " + p.getNick() + " " + player.getTeam();
			server.sendToPlayer(player, t);
			
			String pos = "player " + p.getID() + " at " + p.getPos();
			server.sendToPlayer(player, pos);
		}
		
		for (Entity e : game.getEntities()) {
			server.sendToPlayer(player, "player " + player.getID() + " build " + e.getType() + " at " + e.getPos());
		}
	}
}
