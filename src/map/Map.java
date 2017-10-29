package map;

import main.Engine;
import main.Main;

import java.awt.*;
import java.util.ArrayList;

public class Map {

    private static ArrayList<TileMap> maps = new ArrayList<TileMap>();
    private int offsetX, offsetY, currentMap;

    public Map() {
        maps.add(new TileMap(10, 10));
        currentMap = -1; // The game will not try to render if the map value is smaller than 0.
    }

    public void update() {

    }

    public void setCurrentMap(int index) {
        if(index >= 0 && index < maps.size()) {
            currentMap = index;
        }
    }

    private void setFocusPoint(int x, int y) {
        offsetX = (Engine.WIDTH / 2) - x;
        offsetY = (Engine.HEIGHT / 2) - y;
    }

    public void draw(Graphics g) {
        if(currentMap >= 0) {
            TileMap m = maps.get(currentMap);
            for (int ix = 0; ix < m.getWidth(); ix++) {
                for (int iy = 0; iy < m.getHeight(); iy++) {
                    if (m.getTileAt(ix, iy) != 0) {
                        g.setColor(Color.GREEN);
                        g.fillRect((ix * m.TILE_WIDTH) + offsetX, (iy * m.TILE_HEIGHT) + offsetY, m.TILE_WIDTH, m.TILE_HEIGHT);
                    }
                    g.setColor(Color.WHITE);
                    g.drawRect((ix * m.TILE_WIDTH) + offsetX, (iy * m.TILE_HEIGHT) + offsetY, m.TILE_WIDTH, m.TILE_HEIGHT);
                }
            }
        }
    }
}
