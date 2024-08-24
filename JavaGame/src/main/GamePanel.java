package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs;
	private int xDelta = 0, yDelta = 0;

    public GamePanel() {
        // Initialize game components here if needed
    	mouseInputs = new MouseInputs();
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Clear the panel and call the superclass's method
        g.fillRect(100 + xDelta, 100 + yDelta, 200, 50);  // Draw the rectangle
    }
}
