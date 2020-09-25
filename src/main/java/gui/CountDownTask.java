package main.java.gui;

import java.util.TimerTask;

public class CountDownTask extends TimerTask {

    private GamePanel gp;
    private long timeLeft;

    CountDownTask(GamePanel gp, long timeLeft) {
        this.gp = gp;
        this.timeLeft = timeLeft;
    }

    @Override
    public void run() {
        gp.setMessage("Time left until new spawn: " + timeLeft/1000);
        timeLeft -= 1000;
    }
}
