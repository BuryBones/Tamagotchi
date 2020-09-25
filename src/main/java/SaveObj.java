package main.java;

import java.io.Serializable;

public class SaveObj implements Serializable {

    private static final long serialVersionUID = 5193789457848049755L;

    private Pet pet;
    private long exitTime;
    private long witherPassed;
    private long spawnPassed;
    private boolean canGrow;
    private long growthPassed;

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
    public boolean isCanGrow() {
        return canGrow;
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
