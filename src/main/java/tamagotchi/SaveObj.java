package tamagotchi;

import java.io.Serializable;

public class SaveObj implements Serializable {

  // an object which contains all data to be saved while exiting the game

  private static final long serialVersionUID = 5193789457848049755L;

  private final Pet pet;
  private final long exitTime;
  private final long witherPassed;
  private final long spawnPassed;
  private final boolean canGrow;
  private final long growthPassed;

  public Pet getPet() {
    return pet;
  }

  public long getExitTime() {
    return exitTime;
  }

  public long getWitherPassed() {
    return witherPassed;
  }

  public long getSpawnPassed() {
    return spawnPassed;
  }

  public long getGrowthPassed() {
    return growthPassed;
  }

  public SaveObj(Pet pet, long exitTime, long witherPassed,
      long spawnPassed, boolean canGrow, long growthPassed) {
    this.pet = pet;
    this.exitTime = exitTime;
    this.spawnPassed = spawnPassed;
    this.witherPassed = witherPassed;
    this.canGrow = canGrow;
    this.growthPassed = growthPassed;
  }

}
