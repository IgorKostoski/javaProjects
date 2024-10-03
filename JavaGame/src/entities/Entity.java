package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {

    protected float x, y;
    protected int width, height;
    
    protected Rectangle hitbox;

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        
        initHitbox(x, y, width, height); // Initialize hitbox
    }
    
    protected void drawHitbox(Graphics g) {
        // For debugging the hitbox
        g.setColor(Color.PINK);
        g.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
    }
    
    protected void initHitbox(float x, float y, float width, float height) {
        hitbox = new Rectangle((int)x, (int)y, (int)width, (int)height);
    }
    
    protected void updateHitbox() {
        hitbox.x = (int)x;
        hitbox.y = (int)y;
    }
    
    public Rectangle getHitbox() {
        return hitbox;
    }
}
