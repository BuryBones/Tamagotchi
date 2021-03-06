package tamagotchi;

import tamagotchi.gui.MainFrame;

public class GuiController {
  // transfers commands to GUI

  private MainFrame mainFrame;

  public GuiController(MainFrame mainFrame) {
    this.mainFrame = mainFrame;
  }

  public void start() {
    mainFrame.start();
  }

  public void block() {
    mainFrame.block();
  }

  public void unblock() {
    mainFrame.unblock();
  }

  public void setPetName(String name) {
    mainFrame.setPetName(name);
  }

  public void displayMessage(String message, long millis) {
    mainFrame.displayMessage(message, millis);
  }

  public void countDown(long timeLeft) {
    mainFrame.countDown(timeLeft);
  }

  public void stopCountDown() {
    mainFrame.stopCountDown();
  }

  public PetType askForPetType() {
    return mainFrame.askForPetType();
  }

  public String askForName() {
    return mainFrame.askForName();
  }

  public void displayError(String message, boolean exit) {
    mainFrame.displayError(message, exit);
  }
}
