package utilz;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static final String PLAYER_ATLAS = "player_sprites.png";
	public static final String LEVEL_ATLAS = "outside_sprites.png";
	
	
	
	
    
    public static BufferedImage GetSpriteAtlas(String fileName) {
        BufferedImage img = null; // Local variable to hold the image
        
        InputStream is = LoadSave.class.getResourceAsStream("/" +  fileName);
        
        try {
            // Assign the result of ImageIO.read to img
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close(); // Close the InputStream
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return img; // Return the loaded image
    }
}
