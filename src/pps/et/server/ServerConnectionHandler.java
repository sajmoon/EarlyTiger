package pps.et.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import pps.et.logic.Player;

public class ServerConnectionHandler implements Runnable {
	PrintWriter out;
	String inputLine, outputLine;
	BufferedReader in;
	Socket clientSocket;
	
	GameHandler game;
	Player player;
	
	public ServerConnectionHandler(Socket client, GameHandler game) {
		
		this.game = game;
		clientSocket = client;
		player = new Player("unknown", 0, 0);
		
		try {
			out = new PrintWriter(client.getOutputStream(), true);
			in 	= new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			System.out.println("Client connected");
			
		} catch (Exception e) {
			
		}
	}
	
	private void processInput(String input) {
		String[] args = input.split(" ");
		// nick sdad
		// chat g tasdlajsdlakjdaa
		// chat l dakjsdlakjdlasd
		
		// map
		
		// go r/l/u/d xpos/ypos
		System.out.println("process");
		if (args[0].startsWith("nick")) {
			setNick(input);
			game.sendChat(this, "nick changed");
		} else if (args[0].startsWith("map")) {
			sendMap();
		} else if (args[0].startsWith("chat")) {
			game.sendChat(this, "chat sent");
		} else if (args[0].equals("move")) {
			game.movePlayer(player, args[1]);
		} else {
			game.sendChat(this, input);
		}
	}

	public void run() {
		System.out.println("run");
		
		try {
			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			    processInput(inputLine);
			}
			System.out.println("Client " + getNick() + " disconnected");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void send(String msg) {
		out.println(msg);
		out.flush();
	}
	
	public String getNick() {
		return player.getNick();
	}
	
	public void setNick(String newName) {
		player.setNick(newName);
	}

	public void sendMap() {
		try {
			System.out.println("Send map");
			out.println(game.map.toString());
		} catch (Exception e) {
			System.out.println("error sending map");
		}
	}
}
