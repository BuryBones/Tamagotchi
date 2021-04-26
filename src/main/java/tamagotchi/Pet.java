package tamagotchi;

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

  public Pet(PetType type, String name) {
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
      // if chosen food type is best for this pet
      game.displayMessage("Good food!", 2000);
      changeHealth(food.getValue());

      // pet only grows when fed (and fed with appropriate food!)
      if (canGrow && health >= Constants.MAX_HEALTH * Constants.GROWTH_THRESHOLD_MULTIPLIER) {
        grow();
      }
    } else {
      // if chosen food type is not suitable for this pet
      game.displayMessage("I don't like this...", 2000);
      changeHealth(food.getValue() / 4);
    }
  }

  public void play() {
    game.displayMessage("Wheeeeeee!", 1800);
    changeFun(20);
  }

  public void starve() {
    changeHealth(Constants.STARVATION_VALUE);
  }

  public void getBored() {
    changeFun(Constants.BOREDOM_VALUE);
  }

  private void grow() {
    age = age.next();
    canGrow = false;
      if (!isMaxAge()) {
          game.startGrowthTimer();
      }
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
      setMood(Mood.getMoodFromMatrix(healthLevel, funLevel));
    }
  }

  private void setMood(Mood mood) {
    this.mood = mood;
  }

  private int valueToLevel(int value, int max) {
    // more than 75% or equal
      if (value >= max / 4 * 3) {
          return 4;
      }
    // more than 50% or equal
      if (value >= max / 2) {
          return 3;
      }
    // more than 25% or equal
      if (value >= max / 4) {
          return 2;
      }
    // more than 10% or equal
      if (value >= max / 10) {
          return 1;
      }
    // less than 10%
    return 0;
  }

  private void die() {
    isAlive = false;
    if (game != null) {
      game.gameOver();
    }
  }

  public String toString() {
    String result = age + " " + type + " called " + name + " is " + mood +
        "\nhealth: " + health + ", fun: " + fun;
    return result;
  }
}
