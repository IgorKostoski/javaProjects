package main;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

    public GamePanel() {
        // Initialize game components here if needed
    	addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
    	});
    		
    	
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Clear the panel and call the superclass's method
        g.fillRect(100, 100, 200, 50);  // Draw the rectangle
    }
}
