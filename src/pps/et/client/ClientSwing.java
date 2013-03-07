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
				String text = "";
				if (game.playerAt(i, n)) {
					text = "#";
				}
				if (player.isAt(i, n)) {
					System.out.println("player at this tile");
					text = "@";
				}

				JLabel j = new JLabel(text, SwingConstants.CENTER);
				j.setOpaque(true);
				int tileCode = map.getTileCode(i, n);
				j.setForeground(Color.red);

				if (tileCode == 0)
					j.setBackground(Color.blue);
				else if (tileCode == 1)
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
				Thread.sleep(100);
				// TODO Detta borde vi kunna göra med en flagga. 
				// Typ att nära det ändras i någon klass så sätts den till true etc
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
		if(e.getKeyCode() == 37 || e.getKeyCode() == 65) {
			// left or a
			game.movePlayer(player, "L");
			connection.send("move L");
		} else if (e.getKeyCode() == 38 || e.getKeyCode() == 87) {
			// up or w
			game.movePlayer(player, "U");
			connection.send("move U");
		} else if (e.getKeyCode() == 39 || e.getKeyCode() == 68) {
			// 	right or d
			game.movePlayer(player, "R");
			connection.send("move R");
		} else if (e.getKeyCode() == 40 || e.getKeyCode() == 83) {
			// down or s
			game.movePlayer(player, "D");
			connection.send("move D");
		} else if (e.getKeyCode() == 27) {
			//escape
		} else if (e.getKeyCode() == 32) {
			// Space
		} else if (e.getKeyCode() == 10) {
			// enter
		} else {
			System.out.println("Keypres: " + e.getKeyCode());
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
