package main.java;

import main.java.gui.GameController;
import main.java.gui.MainFrame;

public class Main {

    public static void main(String[] args) {

        GameController gameController = new GameController();
        MainFrame mainFrame = new MainFrame(gameController);
        GuiController guiController = new GuiController(mainFrame);
        Game game = new Game(guiController);
        gameController.setGame(game);
        game.launch();
    }
}
