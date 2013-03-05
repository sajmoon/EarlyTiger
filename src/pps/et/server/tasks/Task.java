package pps.et.server.tasks;

import pps.et.logic.GameHandler;
import pps.et.logic.Player;
import pps.et.server.Server;

public abstract class Task {
	Player player;
	public GameHandler game;
	public Server server;

	public Task(Player p) {
		player = p;
	}

	public abstract void consume();
}
