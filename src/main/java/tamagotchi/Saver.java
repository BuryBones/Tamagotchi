package tamagotchi;

import java.io.*;

public class Saver {

  private SaveObj saveFile;
  private GuiController guiController;

  Saver(GuiController guiController) {
    this.guiController = guiController;
  }

  public void prepareSaveFile(Pet pet, long timerStartTime,
      long spawnCooldownTaskStartTime, boolean canGrow, long growTaskStartTime) {
    long currentTime = System.currentTimeMillis();
    // millis until timer task would be triggered
    long witherPassed = currentTime - timerStartTime;
    // millis until spawn would be allowed
    long spawnPassed = currentTime - spawnCooldownTaskStartTime;
    // millis until growth would be allowed
    long growthPassed = currentTime - growTaskStartTime;
    saveFile = new SaveObj(pet, currentTime, witherPassed, spawnPassed, canGrow, growthPassed);
  }

  public void save() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tam.save"))) {
      oos.writeObject(saveFile);
      System.out.println("Saving complete!");
    } catch (IOException e) {
      guiController.displayError("Failed to save the game!", false);
      e.printStackTrace();
    }
  }
}
