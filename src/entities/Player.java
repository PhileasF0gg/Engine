package entities;

import main.InputHandler;
import map.Textures;
import map.TileMap;
import java.awt.*;

public class Player extends Entity {

    private int speed = 3;
    private int tileLocX, tileLocY; // X and Y location on the tile map.
    private int destX, destY, dirX, dirY; // The X and Y destinations for the player to go.
    private boolean upCollide, downCollide, leftCollide, rightCollide, moving;
    private int animID = 0;
    private Animate anim;

    public Player(int tileX, int tileY) {
        super(tileX * TileMap.TILE_WIDTH, tileY * TileMap.TILE_HEIGHT);
        w = 25;
        h = 25;
        x += (TileMap.TILE_WIDTH / 2) - (w / 2); // Centres the player on its starting tile.
        y += (TileMap.TILE_HEIGHT / 2) - (h / 2); // Centres the player on its staring tile.
        destX = x; // Sets the destination X to the starting point to prevent unnecessary movement.
        destY = y; // Sets the destination Y to the starting point to prevent unnecessary movement.
        anim = new Animate(4);
    }

    @Override
    public void update() {
        tileLocX = x / TileMap.TILE_WIDTH;
        tileLocY = y / TileMap.TILE_HEIGHT;

        anim.update();

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

        if(dirX == 1) {
            animID = 6;
        }else if(dirX == -1) {
            animID = 3;
        }else if(dirY == 1) {
            animID = 0;
        }else if(dirY == -1) {
            animID = 9;
        }

        moving = false;

        if(x < destX && dirX == 1) {
            if (x + speed > destX) {
                x += speed - ((x + speed) - destX);
                // If the player is about to over step the destination then the speed is lowered by overstep.
            }else {
                x += speed;
            }
            if(!anim.isActive()) {
                anim.start();
            }
            animateRight();
            moving = true;
        }else if(x > destX && dirX == -1) {
            if(x - speed < destX) {
                x -= speed + (x - speed) - destX;
                // If the player is about to over step the destination then the speed is lowered by overstep.
            }else {
                x -= speed;
            }
            if(!anim.isActive()) {
                anim.start();
            }
            animateLeft();
            moving = true;
        }
        if(y < destY && dirY == 1) {
            if (y + speed > destY) {
                y += speed - ((y + speed) - destY);
                // If the player is about to over step the destination then the speed is lowered by overstep.
            }else {
                y += speed;
            }
            if(!anim.isActive()) {
                anim.start();
            }
            animateDown();
            moving = true;
        }else if(y > destY && dirY == -1) {
            if(y - speed < destY) {
                y -= speed + (y - speed) - destY;
                // If the player is about to over step the destination then the speed is lowered by overstep.
            }else {
                y -= speed;
            }
            if(!anim.isActive()) {
                anim.start();
            }
            animateUp();
            moving = true;
        }

        if(!moving) {
            anim.stop();
            if(x != destX || y != destY) { // If the player did not reach the destination successfully.
                x = destX; // Jumps the player to the correct X coordinate.
                y = destY; // Jumps the player to the correct Y coordinate.
            }
        }
    }

    private void animateLeft() {
        if(anim.getAnimPhase() == 0) {
            animID = 4;
        }else if(anim.getAnimPhase() == 1) {
            animID = 3;
        }else if(anim.getAnimPhase() == 2) {
            animID = 5;
        }else if(anim.getAnimPhase() == 3) {
            animID = 3;
        }
    }

    private void animateRight() {
        if(anim.getAnimPhase() == 0) {
            animID = 7;
        }else if(anim.getAnimPhase() == 1) {
            animID = 6;
        }else if(anim.getAnimPhase() == 2) {
            animID = 8;
        }else if(anim.getAnimPhase() == 3) {
            animID = 6;
        }
    }

    private void animateUp() {
        if(anim.getAnimPhase() == 0) {
            animID = 10;
        }else if(anim.getAnimPhase() == 1) {
            animID = 9;
        }else if(anim.getAnimPhase() == 2) {
            animID = 11;
        }else if(anim.getAnimPhase() == 3) {
            animID = 9;
        }
    }

    private void animateDown() {
        if(anim.getAnimPhase() == 0) {
            animID = 1;
        }else if(anim.getAnimPhase() == 1) {
            animID = 0;
        }else if(anim.getAnimPhase() == 2) {
            animID = 2;
        }else if(anim.getAnimPhase() == 3) {
            animID = 0;
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
        //.setColor(Color.DARK_GRAY);
        //g.fillOval(x + offsetX, y + offsetY, w, h);
        g.drawImage(Textures.playerTextures[animID],
                ((x + (w/2)) - TileMap.TILE_WIDTH/2) + offsetX,
                ((y + (h/2)) - TileMap.TILE_HEIGHT/2) - TileMap.TILE_HEIGHT + offsetY,
                TileMap.TILE_WIDTH, TileMap.TILE_HEIGHT * 2, null);
    }

}
