package tamagotchi;

import java.util.TimerTask;

public class SpawnCooldownTask extends TimerTask {

  private final Game game;
  private long startTime = 0;

  public long getStartTime() {
    return startTime;
  }

  public SpawnCooldownTask(Game game) {
    this.game = game;
    startTime = System.currentTimeMillis();
  }

  @Override
  public void run() {
    game.spawn();
  }
}
