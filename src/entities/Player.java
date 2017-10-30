package entities;

import main.InputHandler;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    private int speed;

    public Player(int startX, int startY) {
        super(startX, startY);
        w = 25;
        h = 25;
        speed = 5;
    }

    @Override
    public void update() {
        if(InputHandler.upPressed()) {
            y -= speed;
        }
        if(InputHandler.downPressed()) {
            y += speed;
        }
        if(InputHandler.leftPressed()) {
            x -= speed;
        }
        if(InputHandler.rightPressed()) {
            x += speed;
        }
    }

    @Override
    public void draw(Graphics g, int offsetX, int offsetY) {
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x + offsetX, y + offsetY, w, h);
    }

}
