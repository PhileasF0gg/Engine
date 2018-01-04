package map;

import entities.Player;
import main.*;

import java.awt.*;
import java.util.ArrayList;

public class Map {

    private static ArrayList<TileMap> maps = new ArrayList<TileMap>(); // Holds all of the TileMap objects.
    private float offsetX, offsetY;
    private int currentMap;
    private Player p;
    private ArrayList<Overlay> overlayedTiles;

    public Map() {
        Textures.initTextures();
        maps.add(new TileMap(20, 20)); // (Map ID: 0) is just a test map.
        maps.get(0).load("res/test.tm"); // Loads the test map file.
        currentMap = -1; // The game will not try to render if the map value is smaller than 0.
        p = new Player(0, 0);
    }

    public void update() {
        checkPlayerCollision();
        p.update();
        setFocusPoint(p.getX(), p.getY());
    }

    private void checkPlayerCollision() {
        if(p.getTileLocX() - 1 >= 0 && !Tile.getTileById(maps.get(currentMap)
                .getTileAt(p.getTileLocX() - 1, p.getTileLocY())).isSolid()) {
            p.blockLeft(false);
        }else {
            p.blockLeft(true);
        }

        if(p.getTileLocX() + 1 < maps.get(currentMap).getWidth() && !Tile.getTileById(maps.get(currentMap)
                .getTileAt(p.getTileLocX() + 1, p.getTileLocY())).isSolid()) {
            p.blockRight(false);
        }else {
            p.blockRight(true);
        }

        if(p.getTileLocY() - 1 >= 0 && !Tile.getTileById(maps.get(currentMap)
                .getTileAt(p.getTileLocX(), p.getTileLocY() - 1)).isSolid()) {
            p.blockUp(false);
        }else {
            p.blockUp(true);
        }

        if(p.getTileLocY() + 1 < maps.get(currentMap).getHeight() && !Tile.getTileById(maps.get(currentMap)
                .getTileAt(p.getTileLocX(), p.getTileLocY() + 1)).isSolid()) {
            p.blockDown(false);
        }else {
            p.blockDown(true);
        }


    }

    public void setCurrentMap(int index) {
        // Sets the current map that is on screen.
        if(index >= 0 && index < maps.size()) {
            currentMap = index;
        }
    }

    private void setFocusPoint(int x, int y) {
        // The players view will follow the specified focus point.
        //offsetX = (Engine.WIDTH / 2) - x;
        float jumpX = 0, jumpY = 0;
        if(offsetX > (Engine.WIDTH / 2) - x) {
            jumpX = (offsetX - ((Engine.WIDTH / 2) - x)) / 20;
            offsetX -= jumpX;
        }
        if(offsetX < (Engine.WIDTH / 2) - x) {
            jumpX = (((Engine.WIDTH / 2) - x) - offsetX) / 20;
            offsetX += jumpX;
        }
        //offsetY = (Engine.HEIGHT / 2) - y;
        if(offsetY > (Engine.HEIGHT / 2) - y) {
            jumpY = (offsetY - ((Engine.HEIGHT / 2) - y)) / 20;
            offsetY -= jumpY;
        }
        if(offsetY < (Engine.HEIGHT / 2) - y) {
            jumpY = (((Engine.HEIGHT / 2) - y) - offsetY) / 20;
            offsetY += jumpY;
        }
    }

    public void draw(Graphics g) {
        if(currentMap >= 0) { // Makes sure the map number is not a negative number as they do not exist.
            TileMap m = maps.get(currentMap);
            overlayedTiles = new ArrayList<Overlay>();
            for (int ix = 0; ix < m.getWidth(); ix++) {
                for (int iy = 0; iy < m.getHeight(); iy++) {
                    if (m.getTileAt(ix, iy) != 0) {
                        if(!Tile.getTileById(m.getTileAt(ix, iy)).isOverlay()) {
                            g.drawImage(Tile.getTileById(m.getTileAt(ix, iy)).getTexture(),
                                    (ix * m.TILE_WIDTH) + (int)offsetX,
                                    (iy * m.TILE_HEIGHT) + (int)offsetY,
                                    m.TILE_WIDTH, m.TILE_HEIGHT,
                                    null);
                            // The tile texture is drawn depending on its ID value.
                        }else {
                            overlayedTiles.add(new Overlay(m.getTileAt(ix, iy), ix, iy));
                        }

                        if(Tile.getTileById(m.getTileAt(ix, iy)).hasUnderlay()) {
                            g.drawImage(Tile.getTileById(Tile.getTileById(m.getTileAt(ix, iy)).getUnderlayID()).getTexture(),
                                    (ix * m.TILE_WIDTH) + (int)offsetX,
                                    (iy * m.TILE_HEIGHT) + (int)offsetY,
                                    m.TILE_WIDTH, m.TILE_HEIGHT,
                                    null); // Draws a tile as an underlay.
                        }
                    }
                    if(InputHandler.isDevMode()) {
                        g.setColor(Color.WHITE);
                        if(ix == (p.getX() + (p.getW() / 2)) / m.TILE_WIDTH && iy == (p.getY() + (p.getH() / 2)) / m.TILE_HEIGHT) {
                            // Draws a yellow patch under the player in developer mode.
                            g.setColor(Color.YELLOW);
                            g.fillRect((ix * m.TILE_WIDTH) + (int)offsetX, (iy * m.TILE_HEIGHT) + (int)offsetY, m.TILE_WIDTH, m.TILE_HEIGHT);
                        }
                        g.drawRect((ix * m.TILE_WIDTH) + (int)offsetX, (iy * m.TILE_HEIGHT) + (int)offsetY, m.TILE_WIDTH, m.TILE_HEIGHT);
                        // A white grid is overlaid over the map for testing purposes.
                    }
                }
            }
        }
        p.draw(g, (int)offsetX, (int)offsetY);
        drawOverlay(g);
    }

    private void drawOverlay(Graphics g) {
        for(int i = 0; i < overlayedTiles.size(); i++) {
            Overlay o = overlayedTiles.get(i);
            g.drawImage(Tile.getTileById(o.getTileID()).getTexture(), (o.getTileX() * TileMap.TILE_WIDTH) + (int)offsetX,
                    (o.getTileY() * TileMap.TILE_HEIGHT) + (int)offsetY,
                    TileMap.TILE_WIDTH, TileMap.TILE_HEIGHT, null); // Draws a tile that is on a higher layer than the player.
        }
    }

    public String getPlrLoc() {
        return "X: " + p.getX() + ", Y: " + p.getY() +
                ", Tile X: " + p.getTileLocX() + ", Tile Y: " + p.getTileLocY(); // Returns a string containing the location of the player.
    }

    public String getPlrMovement() {
        return "X dir: " + p.getDirX() + ", X dest: " + p.getDestX() +
                ", Y dir: " + p.getDirY() + ", Y dest: " + p.getDestY(); // Returns a string containing details about the movement of the player.
    }

    public String getPlrCollision() {
        return "(Collisions) " + p.getCollisions();
    }

}
