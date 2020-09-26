package main.java;

import java.util.Timer;

public class Game {

    private Pet currentPet = null;

    // timer to make a pet to starve and get bored
    private Timer witherTimer;
    private WitherTask witherTask;

    // timer to allow a pet to grow
    private Timer growthTimer;
    private GrowthTask growthTask;

    // timer to allow to spawn a new pet
    private Timer spawnTimer;
    private SpawnCooldownTask spawnTask;

    private long witherTaskDelay = Constants.WITHER_PERIOD;
    private long spawnCooldownTaskDelay = Constants.SPAWN_COOLDOWN;
    private long growthTaskDelay = Constants.GROWTH_RATE;

    GuiController guiController;

    Game(GuiController guiController) {
        this.guiController = guiController;
    }

    public Pet getPet() {
        return currentPet;
    }

    public void launch() {
        Loader loader = new Loader(guiController);
        if (loader.isSavePresent()) {
            // save file found
            setUpLoadedGame(loader);
        } else {
            // no save file
            spawn();
        }
    }
    private void setUpLoadedGame(Loader loader) {
        SaveObj loadedSave = loader.load();
        Pet loadedPet = loadedSave.getPet();

        // get time passed from save till new game launch
        long dTime = System.currentTimeMillis() - loadedSave.getExitTime();

        if (loadedPet.isAlive()) {
            // If loaded pet was alive at the moment of saving
            // calculate and perform loops

            // how many loops had passed while game was closed
            int loopsPassed = (int) (dTime/Constants.WITHER_PERIOD);
            // time left till the end of a loop in saveFile
            long baseDelay = loadedSave.getWitherPassed();
            // unfinished loop
            long additionalDelay = dTime%Constants.WITHER_PERIOD;
            // result time to subtract from standard period time
            long resultDelay = baseDelay - additionalDelay;
            if (resultDelay <= 0) {
                loopsPassed++;
            }
            // if pet dies while performing loops, number of loop
            int deathLoop = performWitherLoops(loopsPassed, loadedPet);
            if (loadedPet.isAlive()) {
                // set delays
                witherTaskDelay -= Math.abs(resultDelay);
                if (!loadedPet.isMaxAge()) {
                    long growthTimePassed = loadedSave.getGrowthPassed();
                    growthTaskDelay -= (growthTimePassed+dTime);
                    if (growthTaskDelay <= 0) {
                        loadedPet.enableGrowing();
                        growthTaskDelay = Constants.GROWTH_RATE;
                    }
                }
                // if pet is still alive
                loadedPet.setGame(this);
                currentPet = loadedPet;
                startGame();
            } else {
                // check spawn delay
                long timeAfterDeath = Constants.WITHER_PERIOD * (loopsPassed-deathLoop) + additionalDelay;
                if (spawnCooldownTaskDelay <= timeAfterDeath) {
                    spawn();
                } else {
                    spawnCooldownTaskDelay -= timeAfterDeath;
                    startSpawnCountDown();
                }
            }
        } else {
            // check spawn delay
            long timePassed = loadedSave.getSpawnPassed() + dTime;
            if (spawnCooldownTaskDelay > timePassed) {
                spawnCooldownTaskDelay -= timePassed;
                startSpawnCountDown();
            } else {
                spawn();
            }
        }
    }

    private int performWitherLoops(int loopsNumber, Pet pet) {
        for (int i = 0; i < loopsNumber; i++) {
            pet.getBored();
            pet.starve();
            // if pet dies during these loops returns when (on which loop pet had died)
            if (!pet.isAlive()) return i;
        }
        return -1;
    }
    private void startGame() {

        guiController.start();
        guiController.setPetName(currentPet.getName());

        // start growth timer if max age is not reached yet
        if (!currentPet.isMaxAge()) {
            startGrowthTimer();
        }

        // timer which decreases pet's stats repeatedly
        witherTimer = new Timer(false);
        witherTask = new WitherTask(currentPet);
        witherTimer.scheduleAtFixedRate(witherTask,witherTaskDelay,Constants.WITHER_PERIOD);
    }
    public void displayMessage(String message, long millis) {
        guiController.displayMessage(message,millis);
    }
    public void gameOver() {

        // block buttons (except exit)
        guiController.block();

        // stop tasks if game is over
        if (witherTimer != null) {
            witherTimer.cancel();
            witherTimer.purge();
        }
        if (growthTimer != null) {
            growthTimer.cancel();
            growthTimer.purge();
        }

        displayMessage(currentPet.getName() + " died.",5000);

        startSpawnCountDown();
    }
    public void spawn() {
        guiController.stopCountDown();
        // asks for user input
        PetType type = guiController.askForPetType();
        String name = guiController.askForName();
        currentPet = new Pet(type,name);
        currentPet.setGame(this);
        startGame();
        // unblocking buttons
        guiController.unblock();
    }
    public void exitGame() {
        // forcible game save
        saveGame();
        System.exit(0);
    }
    public void exitWithoutSave() {
        System.exit(0);
    }
    public void startGrowthTimer() {
        growthTimer = new Timer(false);
        growthTask = new GrowthTask(currentPet);
        growthTimer.schedule(growthTask, growthTaskDelay);
    }
    private void startSpawnCountDown() {

        // timer triggers birth after certain delay
        spawnTimer = new Timer(false);
        spawnTask = new SpawnCooldownTask(this);
        spawnTimer.schedule(spawnTask,spawnCooldownTaskDelay);

        guiController.countDown(spawnCooldownTaskDelay);
    }
    private void saveGame() {
        Saver saver = new Saver(guiController);
        long witherTaskStartTime = witherTask.getPeriodStart();
        long spawnCooldownTaskStartTime = spawnTask != null ? spawnTask.getStartTime() : 0;
        long growthTaskStartTime = growthTask != null ? growthTask.getStartTime() : 0;
        saver.prepareSaveFile(currentPet, witherTaskStartTime, spawnCooldownTaskStartTime, currentPet.canGrow(),growthTaskStartTime);
        saver.save();
    }
}
