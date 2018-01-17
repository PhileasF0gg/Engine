package entities;

import java.awt.*;

public abstract class Entity {
    protected int x, y, w, h; // X and Y positions as well as width and height of the entity.

    public Entity(int startX, int startY) {
        x = startX;
        y = startY;
    }

    public abstract void update();
    public abstract void draw(Graphics g, int offsetX, int offsetY, float scaleFactor);

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
