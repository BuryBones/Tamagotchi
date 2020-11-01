package main.java.gui;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BufferedImageLoader {

    private BufferedImage image;

    public BufferedImage loadImage(String path) {
        try {
            image = ImageIO.read(getClass().getClassLoader().getResource(path));
            //            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
