package main.java;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public enum Food {
    APPLE("Apple",PetType.ROUND,35,"/main\\resources\\images\\food\\apple.png"),
    CRACKER("Cracker",PetType.SQUARE,25,"/main\\resources\\images\\food\\cracker.png"),
    CARROT("Carrot",PetType.TRIANGLE,30,"/main\\resources\\images\\food\\carrot.png");

    private String name;
    private PetType bestFor;
    private int value;
    private ImageIcon image;

    Food(String name, PetType bestFor, int value, String imagePath) {
        this.name = name;
        this.bestFor = bestFor;
        this.value = value;
        try {
            image = new ImageIcon(ImageIO.read(getClass().getResource(imagePath)));
        } catch (IOException e) {
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
    public ImageIcon getImage() {
        return image;
    }
}
