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

import pps.et.logic.GameMap;
import pps.et.logic.Player;

public class ClientSwing implements Runnable, KeyListener{
	private Client client;
	private Player player;
	private ClientChatHandler cch;
	JLabel[][] labels;
	GameMap map;
	
	@Override
	public void run() {

		ImageIcon sky = new ImageIcon ("/home/sten/Code/EarlyTiger/bin/tile.png");

		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(map.getSize(), map.getSize()));
		for (int i = map.getSize() -1; i >= 0; i--) {
			System.out.println("s");
			for (int n = 0; n < map.getSize(); n++) {
				String text = "";
				if (player.at(i, n)) {
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
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ClientSwing(Client client, Player player, ClientChatHandler cch){
		this.client = client;
		this.player = player;
		this.cch 	=  cch;
		SwingUtilities.invokeLater(this);
		map = new GameMap();
		labels = new JLabel[map.getSize()][map.getSize()];
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//    	System.out.println(e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 37) {
			player.move("L");
			cch.csh.send("move L");
		} else if (e.getKeyCode() == 38) {
			player.move("U");
			cch.csh.send("move U");
		} else if (e.getKeyCode() == 39) { 
			player.move("R");
			cch.csh.send("move R");
		} else if (e.getKeyCode() == 40) {
			player.move("D");
			cch.csh.send("move D");
		}
		
		
		for (int i = 0; i < map.getSize(); i++) {
			for (int j = 0; j < map.getSize(); j++) {
				if (player.at(i, j)) {
					labels[j][i].setText("@");
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
