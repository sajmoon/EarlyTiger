package pps.et.client;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.image.BufferedImage;

class ClientSwingRewrite {
    public static void main(String[] args) {
        PaintWindow window = new PaintWindow();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.start();
    }
}


class PaintWindow extends JFrame {
    
	PaintPanel canvas = new PaintPanel();
    
    public PaintWindow() {
        
    	
    	//--- create the buttons
        JButton connectButton = new JButton("Connect");
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//TODO
            }});
        
        
        //Doesn't work?
        connectButton.setSize(10, 10);
        
        JButton disconnectButton = new JButton("Disconnect");
        disconnectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//TODO
            }});
        
        JLabel chatPane = new JLabel();
        chatPane.setBackground(Color.white);
        chatPane.setAlignmentY(TOP_ALIGNMENT);
        chatPane.setText("Welcome to the game.");
        
        JTextField chatInput = new JTextField(">");
      
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1));
        buttonPanel.add(connectButton);
        buttonPanel.add(disconnectButton);
        buttonPanel.add(chatPane);
        buttonPanel.add(chatInput);
        
        
        Container content = this.getContentPane();
        
        content.setLayout(new BorderLayout());
        content.add(canvas     , BorderLayout.CENTER);
        content.add(buttonPanel, BorderLayout.EAST);
        
        
        this.setTitle("PPS13Project");
        this.pack();
    }
    
    public void start(){
        canvas.run();
    }
}


class PaintPanel extends JPanel implements MouseListener, 
                                           MouseMotionListener, 
                                           Runnable,
                                           KeyListener {

	int pX = 20;
	int pY = 80;
	
	
    private int _currentStartX = 0;  
    private int _currentStartY = 0;
    
    private BufferedImage _bufImage = null;
    
    private static final int SIZE = 600;
    
    public PaintPanel() {
    	
        setPreferredSize(new Dimension(SIZE, SIZE));
        setBackground(Color.white);
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        
        this.addKeyListener(this);
         
        this.addMouseListener(this); 
        this.addMouseMotionListener(this);
        
        
    }
    
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;  // downcast to Graphics2D
        if (_bufImage == null) {
            //--- This is the first time, initialize _bufImage
            int w = this.getWidth();
            int h = this.getHeight();
            _bufImage = (BufferedImage)this.createImage(w, h);
            Graphics2D gc = _bufImage.createGraphics();
            gc.setColor(Color.white);
            gc.fillRect(0, 0, w, h); // fill in background
        }
        g2.drawImage(_bufImage, null, 0, 0);  // draw previous shapes
        
        draw(g2);
    }
    
    
    private void draw(Graphics2D g2) {	
    	g2.setColor(Color.white);
    	g2.fillRect(0, 0, this.getWidth(), this.getHeight());
    	
    	g2.setColor(Color.black);
    	g2.fillOval(pX, pY, 10, 10);
    	
    }

    public void mousePressed(MouseEvent e) {
        _currentStartX = e.getX(); 
        _currentStartY = e.getY();
       
        System.out.println(e.getClickCount());
        
        Graphics2D grafarea = _bufImage.createGraphics();
        
        draw(grafarea);
        
        this.repaint();            // show new shape
        
    }

    public void mouseDragged(MouseEvent e) {
    }
    
   
    public void mouseReleased(MouseEvent e) {
        

    }    
    
    
    public void mouseMoved   (MouseEvent e) {}
    public void mouseEntered (MouseEvent e) {}
    public void mouseExited  (MouseEvent e) {}
    public void mouseClicked (MouseEvent e) {}


    
    /**
     * This should repaint it all
     */
	@Override
	public void run() {
		while(true){
			if (_bufImage != null){
				
				Graphics2D grafarea = _bufImage.createGraphics();
			        
				
		        draw(grafarea);
				
				this.repaint();
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}




	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 37 || e.getKeyCode() == 65) {
			// left or a
			pX -= 10;
		} else if (e.getKeyCode() == 38 || e.getKeyCode() == 87) {
			// up or w
			pY -= 10;
		} else if (e.getKeyCode() == 39 || e.getKeyCode() == 68) {
			// 	right or d
			pX += 10;
		} else if (e.getKeyCode() == 40 || e.getKeyCode() == 83) {
			// down or s
			pY += 10;
		} else if (e.getKeyCode() == 27) {
			//escape
			System.exit(0);
		} else if (e.getKeyCode() == 32) {
			// Space
		} else if (e.getKeyCode() == 10) {
			// enter
		} else if (e.getKeyCode() == 84) {
			// t
			// for talk/chat
		} else if (e.getKeyCode() == 66) {
			// build
		} else {
			System.out.println("Keypres: " + e.getKeyCode());
		}
	
	}


	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());	
	}
}