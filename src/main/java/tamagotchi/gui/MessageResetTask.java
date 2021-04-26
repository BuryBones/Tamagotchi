package tamagotchi.gui;

import java.util.TimerTask;

public class MessageResetTask extends TimerTask {

  private GamePanel gp;

  MessageResetTask(GamePanel gp) {
    this.gp = gp;
  }

  @Override
  public void run() {
    gp.resetMessage();
  }
}
