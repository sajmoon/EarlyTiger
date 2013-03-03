package pps.et.client;

public class ClientChatHandler {
	private String nick;
	ClientConnectionHandler csh;
	
	public ClientChatHandler(String nick){
		this.nick = nick;
		try {
			csh = new ClientConnectionHandler("192.168.2.9", 4711);
			csh.start();
		} catch (Exception e) {
			// TODO: handle exception
		}
		csh.send("nick " + nick);
	}

}
