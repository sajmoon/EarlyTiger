package pps.et.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import pps.et.logic.ConnectionHandler;
import pps.et.logic.Player;
import pps.et.server.tasks.Chat;
import pps.et.server.tasks.ConnectionTask;
import pps.et.server.tasks.DisconnectedTask;
import pps.et.server.tasks.Move;

public class ServerConnectionHandler implements ConnectionHandler {
	private PrintWriter out;
	private String inputLine, outputLine;
	private BufferedReader in;
	private Socket clientSocket;
	
	TaskHandler th;
	
	Player player;
	
	public ServerConnectionHandler(Socket client, TaskHandler taskHandler, Player p) {
		th 				= taskHandler;
		
		clientSocket 	= client;
		player 			= p;
		
		try {
			out 		= new PrintWriter(client.getOutputStream(), true);
			in 			= new BufferedReader(new InputStreamReader(client.getInputStream()));
			
			taskHandler.addTask(new ConnectionTask(p));
			
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
		if (args[0].startsWith("nick")) {
			setNick(input);
			th.addTask(new Chat(player, "nich changed"));
		} else if (args[0].startsWith("map")) {
			sendMap();
		} else if (args[0].startsWith("chat")) {
			System.arraycopy(args, 1, args, 0, args.length-1);
			th.addTask(new Chat(player, args.toString()));
		} else if (args[0].equals("move")) {
			th.addTask(new Move(player, args[1]));
		} else {
			System.out.println("unknwon command: " + args[0]);
		}
	}

	public void run() {
		
		try {
			while ((inputLine = in.readLine()) != null) {
			    processInput(inputLine);
			}
			System.out.println("Client " + getNick() + " disconnected");
			th.addTask(new DisconnectedTask(player));
			//game.disconnectedUser(player);
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
			//out.println(game.map.toString());
		} catch (Exception e) {
			System.out.println("error sending map");
		}
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		
	}
}
