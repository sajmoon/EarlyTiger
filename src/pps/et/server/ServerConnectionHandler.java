package pps.et.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnectionHandler implements Runnable {
	PrintWriter out;
	String inputLine, outputLine;
	BufferedReader in;
	GameHandler game;
	
	public ServerConnectionHandler(Socket client, GameHandler game) {
		this.game = game;
		
		try {
			out = new PrintWriter(client.getOutputStream(), true);
			in 	= new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			System.out.println("Client connected");
			
		} catch (Exception e) {
			
		}
	}
	
	private String processInput(String input) {
		// chat g tasdlajsdlakjdaa
		// chat l dakjsdlakjdlasd
		
		// map
		
		// go r/l/u/d xpos/ypos
		System.out.println("process");
		
		if (input.startsWith("map")) {
			return "map";
		} else if (input.startsWith("chat")) {
			return "chat sent";
		} else {
			return "wwwwaaaat tjaooli";
		}
	}

	public void run() {
		System.out.println("run");
		
		try {
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			    outputLine = processInput(inputLine);
			    send(outputLine);
			    if (outputLine.equals("Bye."))
			    	break;
			}
			System.out.println("slut");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		out.println(msg);
	}
}
