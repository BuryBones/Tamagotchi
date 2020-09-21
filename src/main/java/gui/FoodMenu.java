package main.java.gui;

import main.java.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodMenu extends JPopupMenu {

    public FoodMenu(MainFrame mainFrame, GameController gameController) {
        this.gameController = gameController;
        this.mainFrame = mainFrame;
        initialize();
    }

    private MainFrame mainFrame;
    private GameController gameController;

    private void initialize() {

        for (Food foodItem : Food.getValues()) {
            JMenuItem mi = new JMenuItem(foodItem.toString());
            // TODO: re-do!
            mi.setIcon(new ImageIcon(foodItem.getImage().getImage().getScaledInstance(48,48,Image.SCALE_SMOOTH)));
            mi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameController.feed(foodItem);
                    mainFrame.gp.setAction(Actions.EAT);
                    mainFrame.gp.eat();
                }
            });
            add(mi);
        }
        setVisible(true);
    }
}
