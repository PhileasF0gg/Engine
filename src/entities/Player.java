package entities;

import main.InputHandler;
import map.TileMap;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    private int speed = 5;
    private int tileLocX, tileLocY; // X and Y location on the tile map.
    private int destX, destY; // The X and Y destinations for the player to go.
    private boolean upCollide, downCollide, leftCollide, rightCollide;

    public Player(int tileX, int tileY) {
        super(tileX * TileMap.TILE_WIDTH, tileY * TileMap.TILE_HEIGHT);
        w = 25;
        h = 25;
        x += (TileMap.TILE_WIDTH / 2) - (w / 2); // Centres the player on its starting tile.
        y += (TileMap.TILE_HEIGHT / 2) - (h / 2); // Centres the player on its staring tile.
        destX = x; // Sets the destination X to the starting point to prevent unnecessary movement.
        destY = y; // Sets the destination Y to the starting point to prevent unnecessary movement.
        speed = 5;
    }

    @Override
    public void update() {
        tileLocX = x / TileMap.TILE_WIDTH;
        tileLocY = y / TileMap.TILE_HEIGHT;
        if(InputHandler.upPressed() && y == destY && !upCollide) {
            destY -= TileMap.TILE_HEIGHT;
        }
        if(InputHandler.downPressed() && y == destY && !downCollide) {
            destY += TileMap.TILE_HEIGHT;
        }
        if(InputHandler.leftPressed() && x == destX && !leftCollide) {
            destX -= TileMap.TILE_WIDTH;
        }
        if(InputHandler.rightPressed() && x == destX && !rightCollide) {
            destX += TileMap.TILE_WIDTH;
        }

        if(x < destX) {
            x += speed;
        }else if(x > destX) {
            x -= speed;
        }

        if(y < destY) {
            y += speed;
        }else if(y > destY) {
            y -= speed;
        }

    }

    public int getTileLocX() {
        return tileLocX; // Returns the X location on the tile map.
    }

    public int getTileLocY() {
        return tileLocY; // Returns the Y location on the tile map.
    }

    @Override
    public void draw(Graphics g, int offsetX, int offsetY) {
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x + offsetX, y + offsetY, w, h);
    }

}
