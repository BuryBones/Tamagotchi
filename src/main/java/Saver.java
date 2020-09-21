package main.java;

import java.io.*;
import java.util.ArrayList;

public class Saver {

    private SaveObj saveFile;

    public void prepareSaveFile(Pet pet, boolean spawnCooldown, long timerStartTime,
                                long spawnCooldownTaskStartTime, boolean canGrow, long growTaskStartTime) {
        long currentTime = System.currentTimeMillis();
        System.out.println("current " + currentTime);
        System.out.println("timerStartTime " + timerStartTime);
        // millis until timer task would be triggered
        long witherDelay = currentTime - timerStartTime;
        System.out.println("prepare save, witherDelay: " + witherDelay);
        long spawnDelay = currentTime - spawnCooldownTaskStartTime;
        long growthDelay = currentTime - growTaskStartTime;
        System.out.println("prepare save, growthDelay: " + witherDelay);
        saveFile = new SaveObj(pet, currentTime, spawnCooldown, witherDelay, spawnDelay, canGrow, growthDelay);
    }
    public void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("saveFile.tam"))) {
            oos.writeObject(saveFile);
            System.out.println("Saving complete!");
        } catch (IOException e) {
            // TODO: Exception handling!
            e.printStackTrace();
        }
    }
}
