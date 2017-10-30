package map;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Textures {

    public static BufferedImage tileTextures[]; // Holds all of the tile textures corresponding to their ID values.

    public static void initTextures() {
        tileTextures = new BufferedImage[3]; // Sets the amount of textures in use.
        try {
            tileTextures[1] = ImageIO.read(Textures.class.getResourceAsStream("/grass.png"));
            tileTextures[2] = ImageIO.read(Textures.class.getResourceAsStream("/dirt.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
