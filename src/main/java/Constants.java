package main.java;

public abstract class Constants {

    // game animation speed
    public  static final int SPEED = 100;

    // time to pass before new pet can be spawned
    public static final long SPAWN_COOLDOWN = 20000L;

    // how often pet's stats (health & fun) decrease
    public static final long STATS_DECREASE_RATE_IN_MILLIS = 10000L;

    // health change per period
    public static final int STARVATION_VALUE = -10;

    // fun change per period
    public static final int BOREDOM_VALUE = -15;

    // percentage of full health for a pet to be able to grow up
    public static final float GROWTH_THRESHOLD_MULTIPLIER = 0.75f;

    // time needed to enable growing up
    public static final long GROWTH_RATE = 30000L;

    // pet's initial health level
    public static final int BASE_HEALTH = 50;

    // pet's initial fun level
    public static final int BASE_FUN = 50;

    // pet's maximum health level
    public static final int MAX_HEALTH = 100;

    // pet's maximum fun level
    public static final int MAX_FUN = 100;
}
