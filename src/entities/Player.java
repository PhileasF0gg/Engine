package entities;

import main.InputHandler;
import map.TileMap;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    private int speed;
    private int TileLocX, TileLocY; // X and Y location on the tile map.

    public Player(int startX, int startY) {
        super(startX, startY);
        w = 25;
        h = 25;
        speed = 5;
    }

    @Override
    public void update() {
        TileLocX = x / TileMap.TILE_WIDTH;
        TileLocY = y / TileMap.TILE_HEIGHT;
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

    public int getTileLocX() {
        return TileLocX; // Returns the X location on the tile map.
    }

    public int getTileLocY() {
        return TileLocY; // Returns the Y location on the tile map.
    }

    @Override
    public void draw(Graphics g, int offsetX, int offsetY) {
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x + offsetX, y + offsetY, w, h);
    }

}
