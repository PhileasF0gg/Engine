package map;

public class Overlay {

    /* Tiles that are put into an overlay object will be draw on a higher layer than the player.*/

    private int tX, tY, tID;


    public Overlay(int tileID, int tileX, int tileY) {
        tX = tileX;
        tY = tileY;
        tID = tileID;
    }

    public int getTileID() {
        return tID;
    }

    public int getTileX() {
        return tX;
    }

    public int getTileY() {
        return tY;
    }
}
