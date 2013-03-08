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
		/*
		Exception in thread "Thread-3" java.util.ConcurrentModificationException
		at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:782)
		at java.util.ArrayList$Itr.next(ArrayList.java:754)
		at pps.et.logic.EntityController.run(EntityController.java:33)
		at java.lang.Thread.run(Thread.java:679)
		*/
		
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
