package pps.et.server;

import pps.et.logic.GameHandler;
import pps.et.logic.entity.Entity;

public class EntityController implements Runnable {
	private GameHandler game;
	
	public EntityController(GameHandler game) {
		this.game = game;
	}
	
	@Override
	public void run() {
		while (true) {
			for (Entity e : game.getEntities()) {
				System.out.println(e.getName());
			}
			
		}	
	}
}
