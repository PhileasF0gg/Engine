package map;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tile {
    private static ArrayList<Tile> tiles = new ArrayList<Tile>(); // Holds all the tile objects.
    private int id; // Holds the ID value for the tile.
    private BufferedImage texture;
    private boolean solid = false, overlay = false;

    static {
        init_tiles();
    }

    public Tile(BufferedImage texture) {
        tiles.add(this);
        id = tiles.lastIndexOf(this);
        this.texture = texture;
    }

    public static void init_tiles() {
        for(int i = 0; i < Textures.tileTextures.length; i++) {
            new Tile(Textures.tileTextures[i]); // Creates a tile object for every tile texture.
        }
        tiles.get(0).solid = true;
        tiles.get(11).solid = true;
        tiles.get(12).solid = true;
    }

    public int getId() {
        return id;
    }

    public boolean isSolid() {
        return solid;
    }

    public boolean isOverlay() {
        return overlay;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public static Tile getTileById(int id) {
        return tiles.get(id); // Returns the tile matching the given id.
    }
}
