package magikgoldgame;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Orb {
    private int x, y, width, height;
    private int damage, hitboxX, hitboxY;
    private boolean isVisible = false;
    Image orbpic;
    Shape hitbox;
    
public Orb (int a, int b) throws SlickException {
    this.x = a; 
    this.y = b; 
    this.isVisible = false; 
    this.orbpic = new Image ("res/orbs/Ninja_12.png"); 
    this.hitbox = new Rectangle (a, b, 32, 32); 
    }
    
//    Orb() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDamage() {
        return damage;
    }

    public int getHitboxX() {
        return hitboxX;
    }

    public int getHitboxY() {
        return hitboxY;
    }

    public boolean isIsVisible() {
        return isVisible;
    }

    public Image getOrbpic() {
        return orbpic;
    }

    public Shape getHitbox() {
        return hitbox;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHitboxX(int hitboxX) {
        this.hitboxX = hitboxX;
    }

    public void setHitboxY(int hitboxY) {
        this.hitboxY = hitboxY;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void setOrbpic(Image orbpic) {
        this.orbpic = orbpic;
    }

    public void setHitbox(Shape hitbox) {
        this.hitbox = hitbox;
    }

    boolean isVisible() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}