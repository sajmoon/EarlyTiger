package pps.et.logic;

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
				if (e.canActivate()) {
					e.activate();
				}
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}	
	}
}
