package main.java;

import java.util.TimerTask;

public class WitherTask extends TimerTask {

    private long periodStart;

    public long getPeriodStart() {
        return periodStart;
    }

    private final Pet pet;

    public WitherTask(Pet pet) {
        this.pet = pet;
        periodStart = System.currentTimeMillis();
    }

    @Override
    public void run() {
        if (pet.isAlive()) {
            pet.getBored();
            pet.starve();

            // sets end of period time (as a time of beginning of a new period)
            periodStart = System.currentTimeMillis();
        }
    }
}
