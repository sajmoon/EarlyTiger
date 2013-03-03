package pps.et.client;

public class ClientChatHandler {
	private String nick;
	private ClientConnectionHandler csh;
	
	public ClientChatHandler(String nick){
		this.nick = nick;
		System.out.println("Nick skapat");
		try {
			csh = new ClientConnectionHandler("192.168.2.9", 4711);
			csh.start();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public static void main(String[] args) {
		ClientChatHandler cch = new ClientChatHandler("Charlie");
		cch.csh.send("nicka Charlie");
		cch.csh.send("Ett meddelande");
	}

}
