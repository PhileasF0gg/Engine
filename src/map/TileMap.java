package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

    public void load(String directory) { // Loads the tilemap from a specified text file.
        try {
            Scanner fileScanner = new Scanner(new File(directory)); // Creates a scanner that scans the file specified.
            width = fileScanner.nextInt(); // Sets the width to the first int value.
            height = fileScanner.nextInt(); // Sets the height to the second int value.

            for(int iy = 0; iy < height; iy++) {
                for(int ix = 0; ix < width; ix++) {
                    if(fileScanner.hasNext()) {
                        tiles[ix][iy] = fileScanner.nextInt();
                        System.out.printf("tile [x: %d, y: %d] [ID value: %d]\n", ix, iy, tiles[ix][iy]);
                    }
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
