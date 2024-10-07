package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import gameStates.Gamestate;
import main.GamePanel;
import static utilz.Constants.Directions.*;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // This can remain empty as keyTyped is not used in this case
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	switch(Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().keyReleased(e);
			break;
		case PLAYING:
			gamePanel.getGame().getMenu().keyReleased(e);
			break;
		default:
			break;
    	
    	}
    	
    	
       
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	switch(Gamestate.state) {
		case MENU:
			gamePanel.getGame().getMenu().keyPressed(e);
			break;
		case PLAYING:
			gamePanel.getGame().getMenu().keyPressed(e);
			break;
		default:
			break;
    	
    	}
        
    }
}
