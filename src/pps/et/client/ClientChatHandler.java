package pps.et.client;

public class ClientChatHandler {
	private String nick;
	ClientConnectionHandler csh;
	
	public ClientChatHandler(String nick){
		this.nick = nick;
		try {
			csh = new ClientConnectionHandler("localhost", 4711);
			csh.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
		csh.send("nick " + nick);
	}

}
