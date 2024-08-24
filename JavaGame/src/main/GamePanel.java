package main;

import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    public GamePanel() {
        // Initialize game components here if needed
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Clear the panel and call the superclass's method
        g.fillRect(100, 100, 200, 50);  // Draw the rectangle
    }
}
