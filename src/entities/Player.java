package entities;

import main.InputHandler;
import map.TileMap;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player extends Entity {

    private int speed = 3;
    private int tileLocX, tileLocY; // X and Y location on the tile map.
    private int destX, destY, dirX, dirY; // The X and Y destinations for the player to go.
    private boolean upCollide, downCollide, leftCollide, rightCollide, moving;

    public Player(int tileX, int tileY) {
        super(tileX * TileMap.TILE_WIDTH, tileY * TileMap.TILE_HEIGHT);
        w = 25;
        h = 25;
        x += (TileMap.TILE_WIDTH / 2) - (w / 2); // Centres the player on its starting tile.
        y += (TileMap.TILE_HEIGHT / 2) - (h / 2); // Centres the player on its staring tile.
        destX = x; // Sets the destination X to the starting point to prevent unnecessary movement.
        destY = y; // Sets the destination Y to the starting point to prevent unnecessary movement.
    }

    @Override
    public void update() {
        tileLocX = x / TileMap.TILE_WIDTH;
        tileLocY = y / TileMap.TILE_HEIGHT;

        if(InputHandler.upPressed() && y == destY && x == destX && !upCollide) { // If there is no collision one tile up.
            destY -= TileMap.TILE_HEIGHT; // A new destination is created for one tile up.
            dirY = -1;
            dirX = 0;
        }
        if(InputHandler.downPressed() && y == destY && x == destX && !downCollide) { // If there is no collision one tile down.
            destY += TileMap.TILE_HEIGHT; // A new destination is created for one tile down.
            dirY = 1;
            dirX = 0;
        }
        if(InputHandler.leftPressed() && y == destY && x == destX && !leftCollide) { // If there is no collision one tile left.
            destX -= TileMap.TILE_WIDTH; // A new destination is created for one tile left.
            dirX = -1;
            dirY = 0;
        }
        if(InputHandler.rightPressed() && y == destY && x == destX && !rightCollide) { // If there is no collision one tile right.
            destX += TileMap.TILE_WIDTH; // A new destination is created for one tile right.
            dirX = 1;
            dirY = 0;
        }

        moving = false;

        if(x < destX && dirX == 1) {
            x += speed;
            moving = true;
        }else if(x > destX && dirX == -1) {
            x -= speed;
            moving = true;
        }

        if(y < destY && dirY == 1) {
            y += speed;
            moving = true;
        }else if(y > destY && dirY == -1) {
            y -= speed;
            moving = true;
        }

        if(!moving) {
            if(x != destX || y != destY) { // If the player did not reach the destination successfully.
                x = destX; // Jumps the player to the correct X coordinate.
                y = destY; // Jumps the player to the correct Y coordinate.
            }
        }
    }

    public void blockLeft(boolean block) {
        leftCollide = block;
    }

    public void blockRight(boolean block) {
        rightCollide = block;
    }

    public void blockUp(boolean block) {
        upCollide = block;
    }

    public void blockDown(boolean block) {
        downCollide = block;
    }

    public int getTileLocX() {
        return tileLocX; // Returns the X location on the tile map.
    }

    public int getTileLocY() {
        return tileLocY; // Returns the Y location on the tile map.
    }

    public int getDestX() {
        return destX; // Returns X destination.
    }

    public int getDestY() {
        return destY; // Returns Y destination.
    }

    public int getDirX() {
        return dirX; // Returns the X direction.
    }

    public int getDirY() {
        return dirY; // Returns the Y direction.
    }

    public String getCollisions() {
        return "L: " +  leftCollide + ", R: "
                + rightCollide + ", U: " + upCollide + ", D: " + downCollide; // Returns details about the players collision.
    }

    @Override
    public void draw(Graphics g, int offsetX, int offsetY) {
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x + offsetX, y + offsetY, w, h);
    }

}
