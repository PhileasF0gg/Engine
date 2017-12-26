package map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Textures {

    public static BufferedImage tileTextures[]; // Holds all of the tile textures corresponding to their ID values.

    public static void initTextures() {
        tileTextures = new BufferedImage[4]; // Sets the amount of textures in use.
        try {
            tileTextures[1] = ImageIO.read(Textures.class.getResourceAsStream("/grass.png"));
            tileTextures[2] = ImageIO.read(Textures.class.getResourceAsStream("/dirt.png"));
            tileTextures[3] = ImageIO.read(Textures.class.getResourceAsStream("/stone.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
