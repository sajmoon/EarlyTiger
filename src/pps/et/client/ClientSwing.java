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

		SwingUtilities.invokeLater(this);
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
			player.move("L");
			connection.send("move L");
		} else if (e.getKeyCode() == 38) {
			player.move("U");
			connection.send("move U");
		} else if (e.getKeyCode() == 39) { 
			player.move("R");
			connection.send("move R");
		} else if (e.getKeyCode() == 40) {
			player.move("D");
			connection.send("move D");
		}
	}

	public void updateView() {
		for (int i = 0; i < map.getSize(); i++) {
			for (int j = 0; j < map.getSize(); j++) {
				if (player.isAt(i, j)) {
					labels[j][i].setText("&");
				} else if (game.playerAt(i, j)) {
					labels[j][i].setText("#");
				} else {
					labels[j][i].setText("");
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//    	System.out.println(e.getKeyCode());
	}
}
