package map;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Textures {

    public static BufferedImage tileTextures[];

    public static void initTextures() {
        tileTextures = new BufferedImage[2];
        try {
            tileTextures[1] = ImageIO.read(Textures.class.getResourceAsStream("/grass.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
