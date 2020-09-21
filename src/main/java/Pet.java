package main.java;

import java.io.Serializable;

public class Pet implements Serializable {

    private static final long serialVersionUID = 5193789457848049755L;
    private transient Game game;

    private final PetType type;
    private final String name;
    private Age age;
    private int health;
    private int fun;
    private Mood mood;
    private boolean canGrow;
    private boolean isAlive;

    // TODO: move out of here?
    // [health][fun]
    private static Mood[][] moodMatrix = new Mood[5][5];
    static
    {
        moodMatrix[0][0] = Mood.UNHAPPY;
        moodMatrix[0][1] = Mood.UNHAPPY;
        moodMatrix[0][2] = Mood.UNHAPPY;
        moodMatrix[0][3] = Mood.UNHAPPY;
        moodMatrix[0][4] = Mood.UNHAPPY;

        moodMatrix[1][0] = Mood.UNHAPPY;
        moodMatrix[1][1] = Mood.UNHAPPY;
        moodMatrix[1][2] = Mood.UNHAPPY;
        moodMatrix[1][3] = Mood.UPSET;
        moodMatrix[1][4] = Mood.UPSET;

        moodMatrix[2][0] = Mood.UNHAPPY;
        moodMatrix[2][1] = Mood.UNHAPPY;
        moodMatrix[2][2] = Mood.UPSET;
        moodMatrix[2][3] = Mood.NEUTRAL;
        moodMatrix[2][4] = Mood.NEUTRAL;

        moodMatrix[3][0] = Mood.UNHAPPY;
        moodMatrix[3][1] = Mood.UPSET;
        moodMatrix[3][2] = Mood.NEUTRAL;
        moodMatrix[3][3] = Mood.GLAD;
        moodMatrix[3][4] = Mood.GLAD;

        moodMatrix[4][0] = Mood.UPSET;
        moodMatrix[4][1] = Mood.NEUTRAL;
        moodMatrix[4][2] = Mood.GLAD;
        moodMatrix[4][3] = Mood.HAPPY;
        moodMatrix[4][4] = Mood.HAPPY;
    }

    public Pet(PetType type,String name) {
        this.type = type;
        this.name = name;
        age = Age.getMin();
        health = Constants.BASE_HEALTH;
        fun = Constants.BASE_FUN;
        canGrow = false;
        isAlive = true;
        check();
    }

    public boolean isAlive() {
        return isAlive;
    }
    public PetType getType() {
        return type;
    }
    public Age getAge() {
        return age;
    }
    public Mood getMood() {
        return mood;
    }
    public boolean canGrow() {
        return canGrow;
    }
    public boolean isMaxAge() {
        return age.isMaxAge();
    }
    public int getFun() {
        return fun;
    }
    public int getHealth() {
        return health;
    }
    public String getName() {
        return name;
    }
    public void enableGrowing() {
        // can grow if maximum age is not reached
        canGrow = age != Age.getMax();
    }
    public void setGame(Game game) {
        this.game = game;
    }

    public void eat(Food food) {
        if (food.getBestFor().equals(type)) {
            System.out.println("Good food!");
            changeHealth(food.getValue());

            // pet only grows when fed (and fed with appropriate food!)
            if (canGrow && health >= Constants.MAX_HEALTH * Constants.GROWTH_THRESHOLD_MULTIPLIER) {
                grow();
            }
        } else {
            System.out.println("I don' like this...");
            changeHealth(food.getValue()/2);
        }
    }
    public void play() {
        System.out.println("Wheeeeeee!");
        changeFun(20);
    }
    public void starve() {
        changeHealth(Constants.STARVATION_VALUE);
    }
    public void getBored() {
        changeFun(Constants.BOREDOM_VALUE);
    }

    private void grow() {
        System.out.print("Grows up from " + age);
        age = age.next();
        System.out.println(" to " + age);
        canGrow = false;
        if (!isMaxAge()) game.startGrowthTimer();
    }
    private void changeHealth(int value) {
        int newValue = health + value;
        if (newValue > Constants.MAX_HEALTH) {
            health = Constants.MAX_HEALTH;
        } else if (newValue < 0) {
            health = 0;
        } else {
            health = newValue;
        }
        check();
    }
    private void changeFun(int value) {
        int newValue = fun + value;
        if (newValue > Constants.MAX_FUN) {
            fun = Constants.MAX_FUN;
        } else if (newValue < 0) {
            fun = 0;
        } else {
            fun = newValue;
        }
        check();
    }
    private void check() {
        if (health <= 0) {
            die();
        } else {
            int healthLevel = valueToLevel(health, Constants.MAX_HEALTH);
            int funLevel = valueToLevel(fun, Constants.MAX_FUN);
            setMood(moodMatrix[healthLevel][funLevel]);
        }
        System.out.println(this);
    }
    private void setMood(Mood mood) {
        this.mood = mood;
    }
    private int valueToLevel(int value, int max) {
        // more than 75% or equal
        if (value >= max/4*3) return 4;
        // more than 50% or equal
        if (value >= max/2) return 3;
        // more than 25% or equal
        if (value >= max/4) return 2;
        // more than 10% or equal
        if (value >= max/10) return 1;
        // less than 10%
        return 0;
    }
    private void die() {
        isAlive = false;
        game.gameOver();
    }

    public String toString() {
        String result = age + " " + type + " called " + name + " is " + mood +
                        "\nhealth: " + health + ", fun: " + fun;
        return result;
    }
}
