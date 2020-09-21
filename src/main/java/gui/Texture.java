package main.java.gui;

import java.awt.image.BufferedImage;

public class Texture {
    // singleton
    private static Texture instance = new Texture();
    public static Texture getInstance() {
        if (instance == null) {
            instance = new Texture();
        }
        return instance;
    }
    private Texture() {
        BufferedImageLoader loader = new BufferedImageLoader();
        petSheet = loader.loadImage("/main\\resources\\images\\pets\\petSheet.png");
        ps = new SpriteSheet(petSheet);

        getTextures();
    }

    private final int IMAGE_SIDE = 264;

    private SpriteSheet ps;
    private BufferedImage petSheet;

    private void getTextures() {
        // square baby
        pet[0] = ps.grabImage(1,1,IMAGE_SIDE,IMAGE_SIDE); // square baby unhappy stay
        pet[1] = ps.grabImage(1,2,IMAGE_SIDE,IMAGE_SIDE); // square baby unhappy move1
        pet[2] = ps.grabImage(1,3,IMAGE_SIDE,IMAGE_SIDE); // square baby unhappy move2

        pet[3] = ps.grabImage(2,1,IMAGE_SIDE,IMAGE_SIDE); // square baby upset stay
        pet[4] = ps.grabImage(2,2,IMAGE_SIDE,IMAGE_SIDE); // square baby upset move1
        pet[5] = ps.grabImage(2,3,IMAGE_SIDE,IMAGE_SIDE); // square baby upset move2

        pet[6] = ps.grabImage(3,1,IMAGE_SIDE,IMAGE_SIDE); // square baby neutral stay
        pet[7] = ps.grabImage(3,2,IMAGE_SIDE,IMAGE_SIDE); // square baby neutral move1
        pet[8] = ps.grabImage(3,3,IMAGE_SIDE,IMAGE_SIDE); // square baby neutral move2

        pet[9] = ps.grabImage(4,1,IMAGE_SIDE,IMAGE_SIDE); // square baby glad stay
        pet[10] = ps.grabImage(4,2,IMAGE_SIDE,IMAGE_SIDE); // square baby glad move1
        pet[11] = ps.grabImage(4,3,IMAGE_SIDE,IMAGE_SIDE); // square baby glad move2

        pet[12] = ps.grabImage(5,1,IMAGE_SIDE,IMAGE_SIDE); // square baby happy stay
        pet[13] = ps.grabImage(5,2,IMAGE_SIDE,IMAGE_SIDE); // square baby happy move1
        pet[14] = ps.grabImage(5,3,IMAGE_SIDE,IMAGE_SIDE); // square baby happy move2

        pet[15] = ps.grabImage(1,4,IMAGE_SIDE,IMAGE_SIDE); // square baby dead
        pet[16] = ps.grabImage(2,4,IMAGE_SIDE,IMAGE_SIDE); // square baby eat1
        pet[17] = ps.grabImage(3,4,IMAGE_SIDE,IMAGE_SIDE); // square baby eat2
        pet[18] = ps.grabImage(4,4,IMAGE_SIDE,IMAGE_SIDE); // square baby play1
        pet[19] = ps.grabImage(5,4,IMAGE_SIDE,IMAGE_SIDE); // square baby play2

        // square child
        pet[20] = ps.grabImage(1,5,IMAGE_SIDE,IMAGE_SIDE); // square child unhappy stay
        pet[21] = ps.grabImage(1,6,IMAGE_SIDE,IMAGE_SIDE); // square child unhappy move1
        pet[22] = ps.grabImage(1,7,IMAGE_SIDE,IMAGE_SIDE); // square child unhappy move2

        pet[23] = ps.grabImage(2,5,IMAGE_SIDE,IMAGE_SIDE); // square child upset stay
        pet[24] = ps.grabImage(2,6,IMAGE_SIDE,IMAGE_SIDE); // square child upset move1
        pet[25] = ps.grabImage(2,7,IMAGE_SIDE,IMAGE_SIDE); // square child upset move2

        pet[26] = ps.grabImage(3,5,IMAGE_SIDE,IMAGE_SIDE); // square child neutral stay
        pet[27] = ps.grabImage(3,6,IMAGE_SIDE,IMAGE_SIDE); // square child neutral move1
        pet[28] = ps.grabImage(3,7,IMAGE_SIDE,IMAGE_SIDE); // square child neutral move2

        pet[29] = ps.grabImage(4,5,IMAGE_SIDE,IMAGE_SIDE); // square child glad stay
        pet[30] = ps.grabImage(4,6,IMAGE_SIDE,IMAGE_SIDE); // square child glad move1
        pet[31] = ps.grabImage(4,7,IMAGE_SIDE,IMAGE_SIDE); // square child glad move2

        pet[32] = ps.grabImage(5,5,IMAGE_SIDE,IMAGE_SIDE); // square child happy stay
        pet[33] = ps.grabImage(5,6,IMAGE_SIDE,IMAGE_SIDE); // square child happy move1
        pet[34] = ps.grabImage(5,7,IMAGE_SIDE,IMAGE_SIDE); // square child happy move2

        pet[35] = ps.grabImage(1,8,IMAGE_SIDE,IMAGE_SIDE); // square child dead
        pet[36] = ps.grabImage(2,8,IMAGE_SIDE,IMAGE_SIDE); // square child eat1
        pet[37] = ps.grabImage(3,8,IMAGE_SIDE,IMAGE_SIDE); // square child eat2
        pet[38] = ps.grabImage(4,8,IMAGE_SIDE,IMAGE_SIDE); // square child play1
        pet[39] = ps.grabImage(5,8,IMAGE_SIDE,IMAGE_SIDE); // square child play2

        // square adult
        pet[40] = ps.grabImage(1,9,IMAGE_SIDE,IMAGE_SIDE); // square adult unhappy stay
        pet[41] = ps.grabImage(1,10,IMAGE_SIDE,IMAGE_SIDE); // square adult unhappy move1
        pet[42] = ps.grabImage(1,11,IMAGE_SIDE,IMAGE_SIDE); // square adult unhappy move2

        pet[43] = ps.grabImage(2,9,IMAGE_SIDE,IMAGE_SIDE); // square adult upset stay
        pet[44] = ps.grabImage(2,10,IMAGE_SIDE,IMAGE_SIDE); // square adult upset move1
        pet[45] = ps.grabImage(2,11,IMAGE_SIDE,IMAGE_SIDE); // square adult upset move2

        pet[46] = ps.grabImage(3,9,IMAGE_SIDE,IMAGE_SIDE); // square adult neutral stay
        pet[47] = ps.grabImage(3,10,IMAGE_SIDE,IMAGE_SIDE); // square adult neutral move1
        pet[48] = ps.grabImage(3,11,IMAGE_SIDE,IMAGE_SIDE); // square adult neutral move2

        pet[49] = ps.grabImage(4,9,IMAGE_SIDE,IMAGE_SIDE); // square adult glad stay
        pet[50] = ps.grabImage(4,10,IMAGE_SIDE,IMAGE_SIDE); // square adult glad move1
        pet[51] = ps.grabImage(4,11,IMAGE_SIDE,IMAGE_SIDE); // square adult glad move2

        pet[52] = ps.grabImage(5,9,IMAGE_SIDE,IMAGE_SIDE); // square adult happy stay
        pet[53] = ps.grabImage(5,10,IMAGE_SIDE,IMAGE_SIDE); // square adult happy move1
        pet[54] = ps.grabImage(5,11,IMAGE_SIDE,IMAGE_SIDE); // square adult happy move2

        pet[55] = ps.grabImage(1,12,IMAGE_SIDE,IMAGE_SIDE); // square adult dead
        pet[56] = ps.grabImage(2,12,IMAGE_SIDE,IMAGE_SIDE); // square adult eat1
        pet[57] = ps.grabImage(3,12,IMAGE_SIDE,IMAGE_SIDE); // square adult eat2
        pet[58] = ps.grabImage(4,12,IMAGE_SIDE,IMAGE_SIDE); // square adult play1
        pet[59] = ps.grabImage(5,12,IMAGE_SIDE,IMAGE_SIDE); // square adult play2
    }

    public BufferedImage[] pet = new BufferedImage[60];
    public BufferedImage getPetImage(int index) {
        return pet[index];
    }
    public BufferedImage[] getPetImage(int ... indexes) {
        BufferedImage[] result = new BufferedImage[indexes.length];
        for (int i = 0; i < indexes.length; i++) {
            result[i] = pet[indexes[i]];
        }
        return result;
    }
}
