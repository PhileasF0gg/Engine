package map;

public class TileMap {

    public static final int TILE_WIDTH = 50, TILE_HEIGHT = 50; // Width and height of the tiles (in pixels).
    private int width, height, tiles[][];

    public TileMap(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width][height];
        setAll(1);
    }

    public void setAll(int id) { // Sets all of the tiles to one ID.
        for(int ix = 0; ix < width; ix ++) {
            for(int iy = 0; iy < height; iy ++) {
                tiles[ix][iy] = id;
            }
        }
    }

    public int getTileAt(int x, int y) {
        return tiles[x][y]; // Returns the tile ID at the specified coordinates.
    }

    public int getWidth() {
        // Returns the amount of tiles wide the map is.
        return width;
    }

    public int getHeight() {
        // Returns the amount of tiles high the map is.
        return height;
    }

}
