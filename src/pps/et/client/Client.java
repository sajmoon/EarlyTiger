package pps.et.client;

import pps.et.logic.Player;

public class Client extends Thread{
	
	static private ClientChatHandler cch;
	static private ClientSwing cs;
	
	
	public Client(){
	}
	
	public static void main(String[] args) {
		Client c = new Client();
		String nick = "Random";
		
		if (args.length > 1) {
			nick = args[0];
		}
		
		cch = new ClientChatHandler(nick);
		
		Player p = new Player(0, "Test", 0, 0);
		
		cs = new ClientSwing(c, p, cch);
		
	}

    public void movePlayer(String direction){
    	System.out.println(direction);
    	cch.csh.send("move " + direction);
    }

}
