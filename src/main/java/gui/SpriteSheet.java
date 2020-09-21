package main.java.gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpriteSheet {

    private BufferedImage image;

    public SpriteSheet (BufferedImage image) {
        this.image = image;
    }
    public BufferedImage grabImage(int col, int row, int width, int height) {
        BufferedImage img = image.getSubimage((col*width)-width,(row*height)-height,width,height);
        return img;
    }

}
