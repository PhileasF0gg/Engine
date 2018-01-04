package map;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Textures {

    public static BufferedImage tileTextures[]; // Holds all of the tile textures corresponding to their ID values.

    public static void initTextures() {
        tileTextures = new BufferedImage[39]; // Sets the amount of textures in use.
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
            tileTextures[14] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof0.png"));
            tileTextures[15] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof1.png"));
            tileTextures[16] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof2.png"));
            tileTextures[17] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof3.png"));
            tileTextures[18] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof4.png"));
            tileTextures[19] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof5.png"));
            tileTextures[20] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof6.png"));
            tileTextures[21] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof7.png"));
            tileTextures[22] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof8.png"));
            tileTextures[23] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof9.png"));
            tileTextures[24] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof10.png"));
            tileTextures[25] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof11.png"));
            tileTextures[26] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof12.png"));
            tileTextures[27] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof13.png"));
            tileTextures[28] = ImageIO.read(Textures.class.getResourceAsStream("/house_roof14.png"));
            tileTextures[29] = ImageIO.read(Textures.class.getResourceAsStream("/house_main0.png"));
            tileTextures[30] = ImageIO.read(Textures.class.getResourceAsStream("/house_main1.png"));
            tileTextures[31] = ImageIO.read(Textures.class.getResourceAsStream("/house_main2.png"));
            tileTextures[32] = ImageIO.read(Textures.class.getResourceAsStream("/house_main3.png"));
            tileTextures[33] = ImageIO.read(Textures.class.getResourceAsStream("/house_main4.png"));
            tileTextures[34] = ImageIO.read(Textures.class.getResourceAsStream("/house_main5.png"));
            tileTextures[35] = ImageIO.read(Textures.class.getResourceAsStream("/house_main6.png"));
            tileTextures[36] = ImageIO.read(Textures.class.getResourceAsStream("/house_main7.png"));
            tileTextures[37] = ImageIO.read(Textures.class.getResourceAsStream("/house_main8.png"));
            tileTextures[38] = ImageIO.read(Textures.class.getResourceAsStream("/house_main9.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
