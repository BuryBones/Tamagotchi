package tamagotchi.gui;

import tamagotchi.Age;
import tamagotchi.Food;
import tamagotchi.Game;
import tamagotchi.Mood;
import tamagotchi.PetType;

public class GameController {
  // transfers commands from GUI

  private Game game;

  public GameController() {
  }

  public void setGame(Game game) {
    this.game = game;
  }

  int getHealth() {
    return game.getPet().getHealth();
  }

  int getFun() {
    return game.getPet().getFun();
  }

  boolean isPetNull() {
    return game.getPet() == null;
  }

  boolean isPetAlive() {
    return game.getPet().isAlive();
  }

  PetType getPetType() {
    return game.getPet().getType();
  }

  Age getPetAge() {
    return game.getPet().getAge();
  }

  Mood getPetMood() {
    return game.getPet().getMood();
  }

  void feed(Food food) {
    game.getPet().eat(food);
  }

  void play() {
    game.getPet().play();
  }

  void exit() {
    game.exitGame();
  }

  void exitWithoutSave() {
    game.exitWithoutSave();
  }
}
