package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {
	
	private MouseInputs mouseInputs;
	private float xDelta = 100, yDelta = 100;
	private BufferedImage img;
	private BufferedImage[] idleAni;
	
	
	
	
	
	

	
	
	

    public GamePanel() {
    	
        // Initialize game components here if needed
    	
    	mouseInputs = new MouseInputs(this);
    	
    	importImg();
    	loadAnimations();
    	
    	setPanelSize();
    	addKeyListener(new KeyboardInputs(this));
    	addMouseListener(mouseInputs);
    	addMouseMotionListener(mouseInputs);
    		
    	
    }
    
    private void loadAnimations() {
		idleAni = new BufferedImage[5];
		
		for(int i=0; i< idleAni.length; i++) {
			idleAni[i] = img.getSubimage(i*64, 0, 64, 40);		}
	}











	private void importImg() {
		InputStream is = getClass().getResourceAsStream("/player_sprites.png");
		
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	private void setPanelSize() {
    	Dimension size = new Dimension(1280, 800); 
    	setMinimumSize(size);
    	setPreferredSize(size);
    	setMaximumSize(size);
    	
    }
    
    public void changeXDelta(int value) {
    	this.xDelta  += value;
    	
    }
    
    public void changeYDelta(int value) {
    	this.yDelta += value;
    	
    }
  
    
    public void setRectPost(int x, int y) {
    	this.xDelta = x;
    	this.yDelta = y;
    }
   

    @Override
    public void paintComponent(Graphics g) {
    	
    	
        super.paintComponent(g);  // Clear the panel and call the superclass's method
        
        
        g.drawImage(idleAni[2], (int)xDelta,(int) yDelta,128,80, null);
        
    
    }
    
   
    

}
