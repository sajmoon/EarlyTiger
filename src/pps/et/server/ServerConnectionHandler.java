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
	
	public ServerConnectionHandler(Socket client) {
		try {
			out = new PrintWriter(client.getOutputStream(), true);
			in 	= new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			System.out.println("Client connected");
			
		} catch (Exception e) {
			
		}
	}
	
	private String processInput(String input) {
		return "wwwwaaaat tjaooli";
	}

	public void run() {
		System.out.println("run");
		
		try {
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			    outputLine = processInput(inputLine);
			    out.println(outputLine);
			    if (outputLine.equals("Bye."))
			    	break;
			}
			System.out.println("slut");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
