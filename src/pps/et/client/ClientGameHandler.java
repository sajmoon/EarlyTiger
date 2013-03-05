package pps.et.client;

public class ClientGameHandler {
	private String nick;
	ClientConnectionHandler csh;
	
	public ClientGameHandler(String nick){
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
