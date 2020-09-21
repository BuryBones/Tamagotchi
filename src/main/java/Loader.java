package main.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Loader {

    // TODO: shall be stated somewhere that 'isSavePresent' method has to be called before 'loadPet'
    //  to ensure correct loading!

    public boolean isSavePresent() {
        // TODO: do something
        File saveFile = new File("saveFile.tam");
        if (!saveFile.exists()) {
            System.out.println("FILE NOT FOUND");
            return false;
        } else if (!saveFile.isFile()) {
            System.out.println("NOT A FILE");
            return false;
        } else if (!saveFile.canRead()) {
            System.out.println("CANNOT READ A FILE");
            return false;
        } else {
            return true;
        }
    }
    public SaveObj load() {
        // TODO: make method to throw SOME exceptions
        SaveObj result = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("saveFile.tam"))) {
            result = (SaveObj) ois.readObject();
            System.out.println("Loading complete!");
        } catch (IOException e) {
            // TODO: Exception handling!
            e.printStackTrace();
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        }
        return result;
    }
}
