package main.java;

import java.io.Serializable;

public class SaveObj implements Serializable {

    private static final long serialVersionUID = 5193789457848049755L;

    // TODO: rename variables!
    private Pet pet;
    private long exitTime;
    private long witherDelay;
    private long spawnCooldownDelay;
    private boolean canGrow;
    private long growthTimePassed;

    public Pet getPet() {
        return pet;
    }
    public long getExitTime() {
        return exitTime;
    }
    public long getWitherDelay() {
        return witherDelay;
    }
    public long getSpawnCooldownDelay() {
        return spawnCooldownDelay;
    }
    public boolean isCanGrow() {
        return canGrow;
    }
    public long getGrowthTimePassed() {
        return growthTimePassed;
    }

    public SaveObj(Pet pet, long exitTime, long witherDelay,
                   long spawnCooldownDelay, boolean canGrow, long growthTimePassed) {
        this.pet = pet;
        this.exitTime = exitTime;
        this.spawnCooldownDelay = spawnCooldownDelay;
        this.witherDelay = witherDelay;
        this.canGrow = canGrow;
        this.growthTimePassed = growthTimePassed;
    }

}
