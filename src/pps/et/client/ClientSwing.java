package pps.et.client;


import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ClientSwing implements Runnable, KeyListener{
	private Client client;
	
    @Override
    public void run() {
       
    	
    	JFrame f = new JFrame("PPS13");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setPreferredSize(new Dimension(1024, 800));
        
        f.setLayout(new GridLayout(1,1));
        f.addKeyListener(this);
        f.pack();

        f.setVisible(true);
    }
 
    public ClientSwing(Client client){
    	this.client = client;

    	SwingUtilities.invokeLater(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//    	System.out.println(e.getKeyCode());
    }

	@Override
    public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 37)
			client.movePlayer("L");
		else if (e.getKeyCode() == 38) 
			client.movePlayer("U");
		else if (e.getKeyCode() == 39) 
			client.movePlayer("R");
		else if (e.getKeyCode() == 40) 
			client.movePlayer("D");
		else{
			
		}
	}

	@Override
    public void keyReleased(KeyEvent e) {
//    	System.out.println(e.getKeyCode());
    }
}
