package tamagotchi;

import java.util.TimerTask;

public class GrowthTask extends TimerTask {

  private final Pet pet;
  private long startTime = 0;

  public long getStartTime() {
    return startTime;
  }

  public GrowthTask(Pet pet) {
    this.pet = pet;
    startTime = System.currentTimeMillis();
  }

  @Override
  public void run() {
    pet.enableGrowing();
  }
}
