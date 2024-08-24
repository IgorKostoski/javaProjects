package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs;

    public GamePanel() {
        // Initialize game components here if needed
    	mouseInputs = new MouseInputs();
    	addKeyListener(new KeyboardInputs());
    	addMouseListener(mouseInputs);
    	addMouseMotionListener(mouseInputs);
    		
    	
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Clear the panel and call the superclass's method
        g.fillRect(100, 100, 200, 50);  // Draw the rectangle
    }
}
