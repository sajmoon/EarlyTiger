package pps.et.server.tasks;

import pps.et.logic.Player;
import pps.et.logic.entity.Entity;


public class EntityAction extends Task {
	Entity entity;
	public EntityAction(Player p, Entity e) {
		super(p);
		entity = e;
	}

	@Override
	public void consume() {
		String pos = entity.getPos();
		
		entity.action();
		server.sendToAll("entity " + entity.getPos() + " action");
	}
}
