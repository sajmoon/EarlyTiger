package pps.et.client;

import pps.et.logic.Player;

public class Client extends Thread{
	
	static private ClientGameHandler cch;
	static private ClientSwing cs;
	
	
	public Client(){
	}
	
	public static void main(String[] args) {
		System.out.println("Loading Early Tiger (ET)..");
		
		Client c = new Client();
		String nick = "Random";
		
		if (args.length > 1) {
			nick = args[0];
		}
		

		Player p = new Player(0, nick, 0, 0);
		
		cch = new ClientGameHandler(nick);
		
		
		cs = new ClientSwing(c, p, cch);
		
	}

    public void movePlayer(String direction){
    	System.out.println(direction);
    	cch.csh.send("move " + direction);
    }

}
