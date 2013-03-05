package pps.et.server;

import java.util.LinkedList;

import pps.et.logic.GameHandler;
import pps.et.server.tasks.Task;

public class TaskHandler implements Runnable {
	private boolean RUNNING = true;
	private LinkedList<Task> tasks;
	public GameHandler game;
	public Server server; 
	
	public TaskHandler(GameHandler g, Server s) {
		tasks 	= new LinkedList<Task>();
		game 	= g;
		server 	= s;
	}
	
	public synchronized void addTask(Task t) {
		t.game 		= game;
		t.server	= server;
		
		tasks.add(t);
	}
	
	public synchronized Task getTask() {
		if (tasks.isEmpty())
			return null;
		return tasks.poll();
	}

	public void run() {
		while (RUNNING) {
			
			if (!tasks.isEmpty())
				tasks.removeFirst().consume();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
