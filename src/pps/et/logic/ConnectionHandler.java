package pps.et.logic;

public interface ConnectionHandler extends Runnable {

	public void send(String text);

	public void quit();
}
