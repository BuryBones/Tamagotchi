package main.java;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public enum Food {
    // for IDE
    APPLE("Apple",PetType.ROUND,35, "/main/resources/images/food/apple.png"),
    CRACKER("Cracker",PetType.SQUARE,25, "/main/resources/images/food/cracker.png"),
    CARROT("Carrot",PetType.TRIANGLE,30, "/main/resources/images/food/carrot.png");

    // for build
//    APPLE("Apple",PetType.ROUND,35, "images/food/apple.png"),
//    CRACKER("Cracker",PetType.SQUARE,25, "images/food/cracker.png"),
//    CARROT("Carrot",PetType.TRIANGLE,30, "images/food/carrot.png");

    private String name;
    private PetType bestFor;
    private int value;
    private ImageIcon imageIcon;

    Food(String name, PetType bestFor, int value, String imagePath) {
        this.name = name;
        this.bestFor = bestFor;
        this.value = value;
        try {
            // for build
//            image = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource(imagePath)));

            // for IDE
            Image image = ImageIO.read(getClass().getResource(imagePath));
            imageIcon = new ImageIcon(image.getScaledInstance(48,48, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            // TODO: Exception handling
            System.out.println(name + " IMAGE PROBLEM");
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
    public PetType getBestFor() {
        return bestFor;
    }
    public int getValue() {
        return value;
    }
    public ImageIcon getIcon() {
        return imageIcon;
    }
}
