package map;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Tile {
    private static ArrayList<Tile> tiles = new ArrayList<>(); // Holds all the tile objects.
    private int id; // Holds the ID value for the tile.
    private int uID;
    private BufferedImage texture;
    private boolean solid = false, overlay = false, underlay = false;

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
        tiles.get(24).solid = true;
        tiles.get(25).solid = true;
        tiles.get(26).solid = true;
        tiles.get(27).solid = true;
        tiles.get(28).solid = true;
        tiles.get(29).solid = true;
        tiles.get(33).solid = true;
        tiles.get(34).solid = true;
        tiles.get(35).solid = true;
        tiles.get(37).solid = true;
        tiles.get(38).solid = true;

        for(int i = 14; i <= 33; i++) {
            tiles.get(i).overlay = true;
            tiles.get(i).useUnderlay(1);
        }

        tiles.get(30).useUnderlay(39);
        tiles.get(31).useUnderlay(39);
        tiles.get(32).useUnderlay(39);
        tiles.get(34).useUnderlay(1);
        tiles.get(35).useUnderlay(39);
        tiles.get(36).useUnderlay(39);
        tiles.get(37).useUnderlay(39);
        tiles.get(38).useUnderlay(1);
    }

    public int getId() {
        return id; // Returns the ID value of the tile.
    }

    public int getUnderlayID() {
        return uID; // Returns the underlay ID.
    }

    public void useUnderlay(int underlayID) {
        // Allows a separate back layer for another tile.
        underlay = true;
        uID = underlayID;
    }

    public boolean hasUnderlay() {
        return underlay;
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
