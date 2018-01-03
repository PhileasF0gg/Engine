package map;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Textures {

    public static BufferedImage tileTextures[]; // Holds all of the tile textures corresponding to their ID values.

    public static void initTextures() {
        tileTextures = new BufferedImage[14]; // Sets the amount of textures in use.
        try {
            tileTextures[1] = ImageIO.read(Textures.class.getResourceAsStream("/grass.png"));
            tileTextures[2] = ImageIO.read(Textures.class.getResourceAsStream("/dirt.png"));
            tileTextures[3] = ImageIO.read(Textures.class.getResourceAsStream("/dirt_tl.png"));
            tileTextures[4] = ImageIO.read(Textures.class.getResourceAsStream("/dirt_tr.png"));
            tileTextures[5] = ImageIO.read(Textures.class.getResourceAsStream("/dirt_bl.png"));
            tileTextures[6] = ImageIO.read(Textures.class.getResourceAsStream("/dirt_br.png"));
            tileTextures[7] = ImageIO.read(Textures.class.getResourceAsStream("/dirt_sl.png"));
            tileTextures[8] = ImageIO.read(Textures.class.getResourceAsStream("/dirt_sr.png"));
            tileTextures[9] = ImageIO.read(Textures.class.getResourceAsStream("/dirt_t.png"));
            tileTextures[10] = ImageIO.read(Textures.class.getResourceAsStream("/dirt_b.png"));
            tileTextures[11] = ImageIO.read(Textures.class.getResourceAsStream("/stone.png"));
            tileTextures[12] = ImageIO.read(Textures.class.getResourceAsStream("/rock.png"));
            tileTextures[13] = ImageIO.read(Textures.class.getResourceAsStream("/tall_grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
