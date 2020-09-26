package main.java;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public enum Food {
    APPLE("Apple",PetType.ROUND,35, "images/food/apple.png"),
    CRACKER("Cracker",PetType.SQUARE,25, "images/food/cracker.png"),
    CARROT("Carrot",PetType.TRIANGLE,30, "images/food/carrot.png");

    private final String name;
    private final PetType bestFor;
    private final int value;
    private ImageIcon imageIcon;

    Food(String name, PetType bestFor, int value, String imagePath) {
        this.name = name;
        this.bestFor = bestFor;
        this.value = value;
        try {
            Image image = ImageIO.read(getClass().getClassLoader().getResource(imagePath));
            imageIcon = new ImageIcon(image.getScaledInstance(48,48, Image.SCALE_SMOOTH));
        } catch (Exception e) {
            // if image failed to load, empty icon will be created
            System.out.println(name + " IMAGE PROBLEM\nEmpty image will be created.");
            imageIcon = new ImageIcon(new BufferedImage(48,48,BufferedImage.TYPE_INT_ARGB));
            e.printStackTrace();
        }
    }

    private static Food[] values = values();
    public static Food[] getValues() {
        return values;
    }

    public String toString() {
        return name;
    }
    // returns PetType for which this food is the best
    public PetType getBestFor() {
        return bestFor;
    }
    // returns health restore value for the food
    public int getValue() {
        return value;
    }
    // returns icon for the food
    public ImageIcon getIcon() {
        return imageIcon;
    }
}
