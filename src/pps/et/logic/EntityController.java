package pps.et.logic;

import pps.et.logic.entity.Entity;
import pps.et.server.TaskHandler;
import pps.et.server.tasks.EntityAction;

public class EntityController implements Runnable {
	private GameHandler game;
	private TaskHandler tasks;
	
	public EntityController(GameHandler game, TaskHandler th) {
		this.game = game;
		tasks = th;
	}
	
	@Override
	public void run() {
		while (true) {
			for (Entity e : game.getEntities()) {
				if (e.canActivate()) {
					e.action();
					tasks.addTask(new EntityAction(null, e));
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
