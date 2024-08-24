package main;

import javax.swing.JFrame;

public class GameWindow {
    private JFrame jframe;

    public GameWindow(GamePanel gamePanel) {
        jframe = new JFrame();
        jframe.setSize(400, 400);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);  // Add the GamePanel to the JFrame
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);  // Make sure the JFrame is visible
    }
}
