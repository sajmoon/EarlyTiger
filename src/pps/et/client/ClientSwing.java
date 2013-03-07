package pps.et.client;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import pps.et.logic.ConnectionHandler;
import pps.et.logic.GameHandler;
import pps.et.logic.GameMap;
import pps.et.logic.Player;

public class ClientSwing implements Runnable, KeyListener{
	//private Client client;
	private ConnectionHandler connection;
	private Player player;
	private GameHandler game;
	JLabel[][] labels;
	GameMap map;

	public ClientSwing(ClientConnectionHandler connection, Player player, GameHandler game){
		this.connection	= connection;
		this.player 	= player;
		this.game 		= game;
		this.map 		= game.getMap();

		labels = new JLabel[map.getSize()][map.getSize()];

		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(map.getSize(), map.getSize()));
		for (int i = map.getSize() -1; i >= 0; i--) {
			for (int n = 0; n < map.getSize(); n++) {
				
				JLabel j = new JLabel("", SwingConstants.CENTER);
				j.setOpaque(true);
				int tileCode = map.getTileCode(n, i);
				j.setForeground(Color.red);

				if (tileCode == map.FLOOR)
					j.setBackground(Color.blue);
				else if (tileCode == map.WALL)
					j.setBackground(Color.white);
				grid.add(j);
				labels[i][n] = j;
			}
		}
		JFrame frame = new JFrame("PPS13");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(640, 400));
		frame.add(grid);
		frame.pack();
		frame.addKeyListener(this);

		frame.setVisible(true);
		

	}

	@Override
	public void run() {
		while (true) {
			updateView();
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//    	System.out.println(e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 37) {
			game.movePlayer(player, "L");
			connection.send("move L");
		} else if (e.getKeyCode() == 38) {
			game.movePlayer(player, "U");
			connection.send("move U");
		} else if (e.getKeyCode() == 39) { 
			game.movePlayer(player, "R");
			connection.send("move R");
		} else if (e.getKeyCode() == 40) {
			game.movePlayer(player, "D");
			connection.send("move D");
		}
	}

	public void updateView() {
		for (int i = 0; i < map.getSize(); i++) {
			for (int j = 0; j < map.getSize(); j++) {
				labels[j][i].setText( game.playerIdAt(i, j) );
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//    	System.out.println(e.getKeyCode());
	}
}
