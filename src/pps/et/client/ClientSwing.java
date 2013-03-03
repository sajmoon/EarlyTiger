package pps.et.client;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import pps.et.logic.GameMap;
import pps.et.logic.Player;

public class ClientSwing implements Runnable, KeyListener{
	private Client client;
	private Player player;
	ArrayList<JLabel> labels;
	GameMap map;
	
	@Override
	public void run() {

		ImageIcon sky = new ImageIcon ("/home/sten/Code/EarlyTiger/bin/tile.png");

		JPanel grid = new JPanel();
		grid.setLayout(new GridLayout(map.getSize(), map.getSize()));
		for (int i = 0; i < map.getSize(); i++) {
			for (int n = 0; n < map.getSize(); n++) {
				JLabel j = new JLabel();
				j.setOpaque(true);
				int tileCode = map.getTileCode(i, n);
				if (tileCode == 0)
					j.setBackground(Color.blue);
				else if (tileCode == 1)
					j.setBackground(Color.white);
				grid.add(j);
				labels.add(j);
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

	public ClientSwing(Client client, Player player){
		this.client = client;
		this.player = player;
		SwingUtilities.invokeLater(this);
		labels = new ArrayList<JLabel>();
		map = new GameMap();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//    	System.out.println(e.getKeyCode());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 37) {
			player.move("L");

		} else if (e.getKeyCode() == 38) {
			player.move("U");
		} else if (e.getKeyCode() == 39) { 
			player.move("R");
		} else if (e.getKeyCode() == 40) {
			player.move("D");
		} else{

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//    	System.out.println(e.getKeyCode());
	}
}
