package pps.et.logic;

import java.util.Random;

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
		 * Fixed with concurrant datastructures in gamemap.
		Exception in thread "Thread-3" java.util.ConcurrentModificationException
		at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:782)
		at java.util.ArrayList$Itr.next(ArrayList.java:754)
		at pps.et.logic.EntityController.run(EntityController.java:33)
		at java.lang.Thread.run(Thread.java:679)
		*/
		Random r = new Random();
		while (true) {
			for (Entity e : game.getEntities()) {
				if (e.canActivate()) {
					tasks.addTask(new EntityAction(null, e));
					if (e.getType().equals("Mine")) {
						if (r.nextInt(10)<3)
							tasks.addTask(new SummonBox(null, e.getX(), e.getY()));
					}
				}
			}
			try {
				Thread.sleep(20);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}	
	}
}
