package main.java;

import java.util.Timer;

public class Game {

//    private boolean isSpawnAllowed = true;
    private Pet currentPet = null;
    private Timer witherTimer;
    private WitherTask witherTask;
    private Timer growthTimer;
    private GrowthTask growthTask;
    private Timer spawnTimer;
    private SpawnCooldownTask spawnTask;

    private long witherTaskDelay = Constants.STATS_DECREASE_RATE_IN_MILLIS;
    private long spawnCooldownTaskDelay = Constants.SPAWN_COOLDOWN;
    private long growthTaskDelay = Constants.GROWTH_RATE;

    GuiController guiController;

    Game(GuiController guiController) {
        this.guiController = guiController;
    }

//    public boolean isSpawnAllowed() {
//        return isSpawnAllowed;
//    }
//    public void setSpawnAllowed(boolean birthAllowed) {
//        isSpawnAllowed = birthAllowed;
//    }
    public Pet getPet() {
        return currentPet;
    }

    public void launch() {
        Loader loader = new Loader();
        if (loader.isSavePresent()) {
            setUpLoadedGame(loader);
        } else {
            // no save file
            // TODO: delete sout
            System.out.println("NEED NEW PET");
            spawn();
        }
    }
    private void setUpLoadedGame(Loader loader) {
        SaveObj loadedSave = loader.load();
        Pet loadedPet = loadedSave.getPet();
//        loadedPet.setGame(this);

        // get time passed from save till new game launch
        long dTime = System.currentTimeMillis() - loadedSave.getExitTime();
        System.out.println("DELTA TIME = " + dTime);

        if (loadedPet.isAlive()) {
            // calculate and perform loops
            // how many loops had passed while game was closed
            int loopsPassed = (int) (dTime/Constants.STATS_DECREASE_RATE_IN_MILLIS);
            System.out.println("LOOPS PASSED = " + loopsPassed);
            // time left till the end of a loop in saveFile
            long baseDelay = loadedSave.getWitherDelay();
            System.out.println("BASE DELAY = " + baseDelay);
            // unfinished loop while the game was closed
            long additionalDelay = dTime%Constants.STATS_DECREASE_RATE_IN_MILLIS;
            System.out.println("ADDITIONAL DELAY = " + additionalDelay);
            // result time to subtract from standard delay time
            long resultDelay = baseDelay - additionalDelay;
            System.out.println("RESULT DELAY = " + resultDelay);
            if (resultDelay <= 0) {
                loopsPassed++;
                System.out.println("LOOPS++");
            }
            int deathLoop = performWitherLoops(loopsPassed, loadedPet);
            if (loadedPet.isAlive()) {
                // set delays
                witherTaskDelay -= Math.abs(resultDelay);
                System.out.println("WITHER TASK DELAY = " + witherTaskDelay);
                if (!loadedPet.isMaxAge()) {
                    long growthTimePassed = loadedSave.getGrowthTimePassed();
                    growthTaskDelay -= (growthTimePassed+dTime);
                    if (growthTaskDelay <= 0) {
                        loadedPet.enableGrowing();
                        growthTaskDelay = Constants.GROWTH_RATE;
                    }
                }
                loadedPet.setGame(this);
                currentPet = loadedPet;
                startGame();
            } else {
                // check spawn delay
                long timeAfterDeath = Constants.STATS_DECREASE_RATE_IN_MILLIS * (loopsPassed-deathLoop) + additionalDelay;
                if (spawnCooldownTaskDelay <= timeAfterDeath) {
                    spawn();
                } else {
                    spawnCooldownTaskDelay -= timeAfterDeath;
                    startSpawnCountDown();
                }
            }
        } else {
            // check spawn delay
            long timePassed = loadedSave.getSpawnCooldownDelay() + dTime;
            System.out.println("Time passed: " + timePassed);
            if (spawnCooldownTaskDelay > timePassed) {
                spawnCooldownTaskDelay -= timePassed;
                startSpawnCountDown();
            } else {
                spawn();
            }
        }
    }

//    private void setUpLoadedGame(Loader loader) {
//        SaveObj loadedSave = loader.load();
//
//        currentPet = loadedSave.getPet();
//        currentPet.setGame(this);
//
//        // get time passed from save till new game launch
//        long dTime = System.currentTimeMillis() - loadedSave.getExitTime();
//        System.out.println("DELTA TIME = " + dTime);
//
//        if (!currentPet.isMaxAge()) {
//            long growthTimePassed = loadedSave.getGrowthTimePassed();
////            if ((growthTimePassed + dTime) >= growthTaskDelay) {
////                currentPet.enableGrowing();
////            } else {
////                growthTaskDelay -= (growthTimePassed+dTime);
////            }
//            growthTaskDelay -= (growthTimePassed+dTime);
//            if (growthTaskDelay <= 0) {
//                currentPet.enableGrowing();
//                growthTaskDelay = Constants.GROWTH_RATE;
//            }
//        }
//        setSpawnAllowed(loadedSave.isSpawnCooldownActive());
//        if (isSpawnAllowed()) {
//            // pet is either alive or dead and ready to spawn
//            if (currentPet.isAlive()) {
//                // pet is alive
//
//                // how many loops had passed while game was closed
//                int loopsPassed = (int) (dTime/Constants.STATS_DECREASE_RATE_IN_MILLIS);
//                System.out.println("LOOPS PASSED = " + loopsPassed);
//                // time left till the end of a loop in saveFile
//                long baseDelay = loadedSave.getWitherDelay();
//                System.out.println("BASE DELAY = " + baseDelay);
//                // unfinished loop while the game was closed
//                long additionalDelay = dTime%Constants.STATS_DECREASE_RATE_IN_MILLIS;
//                System.out.println("ADDITIONAL DELAY = " + additionalDelay);
//                // result time to subtract from standard delay time
//                long resultDelay = baseDelay - additionalDelay;
//                System.out.println("RESULT DELAY = " + resultDelay);
//                if (resultDelay <= 0) {
//                    loopsPassed++;
//                    System.out.println("LOOPS++");
//                }
//                witherTaskDelay -= Math.abs(resultDelay);
//                System.out.println("WITHER TASK DELAY = " + witherTaskDelay);
////                growthTaskDelay -= loadedSave.getGrowthTimePassed();
//                performWitherLoops(loopsPassed);
//                if (currentPet.isAlive()) {
//                    setSpawnAllowed(true);
//                    startGame();
//                } else {
//                    // pet died after loops passed
//                    // TODO: check if spawn cooldown passed as well
//                }
//            } else {
//                // pet is dead but ready to spawn
//                spawn();
//            }
//        } else {
//            // spawn was not allowed while saving
//
//            // TODO: DRY!
//            if ((loadedSave.getSpawnCooldownDelay() + dTime) >= spawnCooldownTaskDelay) {
//                spawn();
//            } else {
//                spawnCooldownTaskDelay -= loadedSave.getSpawnCooldownDelay();
//                startSpawnCountDown();
//            }
//        }
//    }


    // does what should have happened while the game was closed
    private int performWitherLoops(int loopsNumber) {
        for (int i = 0; i < loopsNumber; i++) {
            currentPet.getBored();
            currentPet.starve();
            // if pet dies during these loops returns when (on which loop pet had died)
            if (!currentPet.isAlive()) return i;
        }
        return -1;
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
        witherTimer.scheduleAtFixedRate(witherTask,witherTaskDelay,Constants.STATS_DECREASE_RATE_IN_MILLIS);
    }
    public void startGrowthTimer() {
        growthTimer = new Timer(false);
        growthTask = new GrowthTask(currentPet);
        growthTimer.schedule(growthTask, growthTaskDelay);
    }
    public void gameOver() {

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

        System.out.println("GAME OVER");

//        setSpawnAllowed(false);
        startSpawnCountDown();
    }
    private void startSpawnCountDown() {

        // timer allows birth after certain delay
        spawnTimer = new Timer(false);
        spawnTask = new SpawnCooldownTask(this);
        spawnTimer.schedule(spawnTask,spawnCooldownTaskDelay);

        // TODO: UI countdown possible?
    }
    public void spawn() {
        PetType type = guiController.askForPetType();
        String name = guiController.askForName();
        currentPet = new Pet(type,name);
        currentPet.setGame(this);
        System.out.println("SPAWN!");
        startGame();
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
    private void saveGame() {
        Saver saver = new Saver();
        long witherTaskStartTime = witherTask.getPeriodStart();
        long spawnCooldownTaskStartTime = spawnTask != null ? spawnTask.getStartTime() : 0;
        long growthTaskStartTime = growthTask != null ? growthTask.getStartTime() : 0;
        saver.prepareSaveFile(currentPet, witherTaskStartTime, spawnCooldownTaskStartTime, currentPet.canGrow(),growthTaskStartTime);
        saver.save();
    }
}
