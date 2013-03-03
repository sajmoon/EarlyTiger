package pps.et.client;

public class Client extends Thread{
	
	static private ClientChatHandler cch;
	static private ClientSwing cs;
	
	
	public Client(){
	}
	
	public static void main(String[] args) {
		Client c = new Client();
		cs = new ClientSwing(c);
		cch = new ClientChatHandler("Charlie");
		
	}

    public void movePlayer(String direction){
    	System.out.println(direction);
    	cch.csh.send("move "+direction);
    }

}
