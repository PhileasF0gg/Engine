package map;

import entities.Player;
import main.Engine;
import main.InputHandler;
import main.Main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Map {

    private static ArrayList<TileMap> maps = new ArrayList<TileMap>(); // Holds all of the TileMap objects.
    private int offsetX, offsetY, currentMap;
    private Player p;

    public Map() {
        Textures.initTextures();
        maps.add(new TileMap(10, 10)); // (Map ID: 0) is just a test map.
        maps.get(0).load("res/test.tm"); // Loads the test map file.
        currentMap = -1; // The game will not try to render if the map value is smaller than 0.
        p = new Player(10, 10);
    }

    public void update() {
        p.update();
        setFocusPoint(p.getX(), p.getY());
    }

    public void setCurrentMap(int index) {
        // Sets the current map that is on screen.
        if(index >= 0 && index < maps.size()) {
            currentMap = index;
        }
    }

    private void setFocusPoint(int x, int y) {
        // The players view will follow the specified focus point.
        offsetX = (Engine.WIDTH / 2) - x;
        offsetY = (Engine.HEIGHT / 2) - y;
    }

    public void draw(Graphics g) {
        if(currentMap >= 0) { // Makes sure the map number is not a negative number as they do not exist.
            TileMap m = maps.get(currentMap);
            for (int ix = 0; ix < m.getWidth(); ix++) {
                for (int iy = 0; iy < m.getHeight(); iy++) {
                    if (m.getTileAt(ix, iy) != 0) {
                        g.drawImage(Tile.getTileById(m.getTileAt(ix, iy)).getTexture(),
                                (ix * m.TILE_WIDTH) + offsetX,
                                (iy * m.TILE_HEIGHT) + offsetY,
                                m.TILE_WIDTH, m.TILE_HEIGHT,
                                null);
                        // The tile texture is drawn depending on its ID value.
                    }
                    if(InputHandler.isDevMode()) {
                        g.setColor(Color.WHITE);
                        if(ix == (p.getX() + (p.getW() / 2)) / m.TILE_WIDTH && iy == (p.getY() + (p.getH() / 2)) / m.TILE_HEIGHT) {
                            // Draws a yellow patch under the player in developer mode.
                            g.setColor(Color.YELLOW);
                            g.fillRect((ix * m.TILE_WIDTH) + offsetX, (iy * m.TILE_HEIGHT) + offsetY, m.TILE_WIDTH, m.TILE_HEIGHT);
                        }
                        g.drawRect((ix * m.TILE_WIDTH) + offsetX, (iy * m.TILE_HEIGHT) + offsetY, m.TILE_WIDTH, m.TILE_HEIGHT);
                        // A white grid is overlaid over the map for testing purposes.
                    }
                }
            }
        }
        p.draw(g, offsetX, offsetY);
    }

    public String getPlayerLoc() {
        return "X: " + p.getX() + ", Y: " + p.getY() +
                ", Tile X: " + p.getTileLocX() + ", Tile Y: " + p.getTileLocY(); // Returns a string containing the location of the player.
    }

}
