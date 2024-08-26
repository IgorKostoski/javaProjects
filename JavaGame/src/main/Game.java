package main;

public class Game implements Runnable{

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;

    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }
    
    private void startGameLoop() {
    	gameThread = new Thread(this);
    	gameThread.start();
    }
    
    @Override
    public void run() {
    	
    	double timePerFrame = 1000000000 / FPS_SET;
    	double timePerUpdate = 1000000000 / UPS_SET;
    	long lastFrame = System.nanoTime();
    	long now = System.nanoTime();
    	
    	long previousTime = System.nanoTime();
    	
    	int frames = 0;
    	int updates = 0;
    	long lastCheck = System.currentTimeMillis();
    	
    	double deltaU = 0;
    	
    	
    	
    	while(true) {
    		
    		now = System.nanoTime();
    		long currentTime = System.nanoTime();
    		
    		deltaU += (currentTime - previousTime) / timePerUpdate;
    		
    		previousTime = currentTime;
    		
    		if(deltaU >= 1) {
    			updates++;
    			deltaU--;
    		}
    		
    		
    		
    		
    		if(now - lastFrame >= timePerFrame) {
    			
    			
    			gamePanel.repaint();
    			lastFrame = now;
    			 frames++;
    			
    		}
    		
    		
    		 
    	        if(System.currentTimeMillis()- lastCheck >= 1000) {
    	        	lastCheck = System.currentTimeMillis();
    	        	System.out.println("FPS: " + frames + "| UPS : " 
    	        			+updates);
    	        	frames = 0;
    	        	updates = 0;
    	        }
    		
    	}
    	
    }

   
}
