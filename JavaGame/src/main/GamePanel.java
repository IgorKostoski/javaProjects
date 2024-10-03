package main;

import java.awt.Color;
import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;
import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs;
	
	private Game game;

	
	
	
	

    public GamePanel(Game game) {
    	
        // Initialize game components here if needed
    	
    	mouseInputs = new MouseInputs(this);
    	this.game = game;
 
    	
    	setPanelSize();
    	addKeyListener(new KeyboardInputs(this));
    	addMouseListener(mouseInputs);
    	addMouseMotionListener(mouseInputs);
    		
    	
    }



	private void setPanelSize() {
    	Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT); 
    	
    	
    	setPreferredSize(size);
    	
    	System.out.println("size: " + GAME_WIDTH + " : " + GAME_HEIGHT); 
    	
    	
    }
    

	
	public void updateGame() {

		
	}
   


   

    @Override
    public void paintComponent(Graphics g) {
    	
    	
        super.paintComponent(g);  // Clear the panel and call the superclass's method
        
       
        game.render(g);
        

        
    
    }
    
    public Game getGame() {
    	return game;
    }
    
	
    


    
   
    

}
