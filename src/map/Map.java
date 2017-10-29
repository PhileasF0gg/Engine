package map;

import java.awt.*;

public class Map {

    private static TileMap map = new TileMap(10, 10);

    public void update() {

    }

    public void draw(Graphics g) {
        for(int ix = 0; ix < map.getWidth(); ix++) {
            for(int iy = 0; iy < map.getHeight(); iy++) {
                if(map.getTileAt(ix, iy) != 0) {
                    g.setColor(Color.GREEN);
                    g.fillRect(ix * map.TILE_WIDTH, iy * map.TILE_HEIGHT, map.TILE_WIDTH, map.TILE_HEIGHT);
                }
                g.setColor(Color.WHITE);
                g.drawRect(ix * map.TILE_WIDTH, iy * map.TILE_HEIGHT, map.TILE_WIDTH, map.TILE_HEIGHT);
            }
        }
    }
}
