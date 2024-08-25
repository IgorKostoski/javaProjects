package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs;
	private int xDelta = 100, yDelta = 100;
	private int frames = 0;
	private long lastCheck = 0;

    public GamePanel() {
        // Initialize game components here if needed
    	mouseInputs = new MouseInputs(this);
    	addKeyListener(new KeyboardInputs(this));
    	addMouseListener(mouseInputs);
    	addMouseMotionListener(mouseInputs);
    		
    	
    }
    
    public void changeXDelta(int value) {
    	this.xDelta  += value;
    	
    }
    
    public void changeYDelta(int value) {
    	this.yDelta += value;
    	
    }
    
    public void setRectPos(int x, int y) {
    	this.xDelta = x;
    	this.yDelta = y;
    	
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Clear the panel and call the superclass's method
        g.fillRect(xDelta,yDelta, 200, 50);  // Draw the rectangle
        frames++;
        if(System.currentTimeMillis()- lastCheck >= 1000) {
        	lastCheck = System.currentTimeMillis();
        	System.out.println("FPS: " + frames);
        	frames = 0;
        }
        repaint();
    }
}
