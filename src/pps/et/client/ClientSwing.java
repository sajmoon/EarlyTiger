package pps.et.client;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

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
	
	// GUI stuff
	private JFrame frame;
	private JPopupMenu popupMenu;

	public ClientSwing(final ClientConnectionHandler connection, final Player player, final GameHandler game){
		this.connection	= connection;
		this.player 	= player;
		this.game 		= game;
		this.map 		= game.getMap();

		labels = new JLabel[map.getSize()][map.getSize()];

		frame = new JFrame("PPS13");
		frame.setLayout(new BorderLayout());

		JPanel gameGrid = new JPanel();
		
		// Build menus
		ActionListener buildMenuActionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		    	  connection.send("build " + actionEvent.getActionCommand() + " at " + player.getPos());
		    	  game.build(player, actionEvent.getActionCommand());
		        }
		      };
		
		createBuildPopup(buildMenuActionListener);
		
		gameGrid.setLayout(new GridLayout(map.getSize(), map.getSize()));
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
				gameGrid.add(j);
				labels[i][n] = j;
			}
		}
		
		// create the status bar panel and shove it down the bottom of the frame
		JPanel statusPanel = new JPanel();
		statusPanel.setLayout(new GridLayout(1,3));
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		statusPanel.setPreferredSize(new Dimension(frame.getWidth(), 16));
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		
		JLabel statusLabel = new JLabel("status");
		JLabel ammoLabel = new JLabel("Ammo");
		JLabel healthLabel = new JLabel("Health");
		
		statusPanel.add(statusLabel, BorderLayout.WEST);
		statusPanel.add(ammoLabel, BorderLayout.CENTER);
		statusPanel.add(healthLabel, BorderLayout.EAST);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(640, 400));
		frame.add(gameGrid);
		frame.pack();
		frame.addKeyListener(this);

		frame.add(statusPanel, BorderLayout.SOUTH);
		
		frame.setVisible(true);
		

	}

	private void createBuildPopup(ActionListener menuActionListener) {
		popupMenu = new JPopupMenu();
		JMenuItem m1 = new JMenuItem("Turret");
		JMenuItem m2 = new JMenuItem("Timemine");
		JMenuItem m3 = new JMenuItem("Proxymine");
		JMenuItem m4 = new JMenuItem("Cottage");
		JMenuItem m5 = new JMenuItem("Desk");
		
		m1.addActionListener(menuActionListener);
		m2.addActionListener(menuActionListener);
		m3.addActionListener(menuActionListener);
		m4.addActionListener(menuActionListener);
		m5.addActionListener(menuActionListener);
		
		popupMenu.add(m1);
		popupMenu.add(m2);
		popupMenu.add(m3);
		popupMenu.add(m4);
		popupMenu.add(m5);
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
			connection.quit();
		} else if (e.getKeyCode() == 32) {
			// Space
		} else if (e.getKeyCode() == 10) {
			// enter
		} else if (e.getKeyCode() == 84) {
			// t
			// for talk/chat
		} else if (e.getKeyCode() == 66) {
			// build
			popupMenu.show(frame, 400, 200);
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
