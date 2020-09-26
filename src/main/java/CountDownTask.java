package main.java;

import java.util.TimerTask;

public class CountDownTask extends TimerTask {

    private GuiController controller;
    private long start;

    public CountDownTask(GuiController controller, long start) {
        this.controller = controller;
        this.start = start;
    }

    @Override
    public void run() {
        controller.displayMessage(start/1000 + " sec left", 1000);
        start -= 1000;
    }
}
