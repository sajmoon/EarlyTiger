package pps.et.client;
import java.io.*;
import java.net.Socket;

public class ClientConnectionHandler extends Thread{
	
	private Socket s;
	private PrintStream out;
	private BufferedReader indata;
	private boolean active;
	private String text;
	
	static BufferedReader in = null;

	
	public ClientConnectionHandler(String ip, int port){
		
		active = true;
		indata = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			s = new Socket(ip,port);
			System.out.println("Connected");
		} catch (Exception e) {
			System.err.println("Connection refused");
		}				
		
		try {
			out = new PrintStream(s.getOutputStream());	
		} catch (Exception e) {
			System.err.println("Init error:" + e.getLocalizedMessage());
		}
	}

	public void run(){
		while(s.isConnected()){
			// Listen if something is sent from the server
			try{
				if(s.getInputStream().available() > 0){
					in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					String data = in.readLine();
					processInput(data);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Closing");
	}
	
	
	private void processInput(String data) {
		
	}

	public void send(String message){
		System.err.println("Sending: "+ message);
		out.println(message);
	}
}
