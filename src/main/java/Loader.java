package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Loader {

    private GuiController guiController;

    Loader (GuiController guiController) {
        this.guiController = guiController;
    }

    public boolean isSavePresent() {
        File saveFile = new File("tam.save");
        if (!saveFile.exists()) {
            return false;
        } else if (!saveFile.isFile()) {
            return false;
        } else return saveFile.canRead();
    }
    public SaveObj load() {
        SaveObj result = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tam.save"))) {
            result = (SaveObj) ois.readObject();
            System.out.println("Loading complete!");
        } catch (Exception e) {
            guiController.displayError("Problem has occurred while loading save file!\n" +
                    "Game will be started from the beginning.",false);
            e.printStackTrace();
        }
        return result;
    }
}
