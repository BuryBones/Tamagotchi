package main.java.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlsPanel extends JPanel {

    private JButton exit = new JButton("Exit");
    private JButton goLeft = new JButton("LEFT");
    private JButton goRight = new JButton("RIGHT");
    private JButton play = new JButton("Play");
    private JButton feed = new JButton("Feed");

    private GameController gameController;
    private MainFrame mainFrame;

    public ControlsPanel(MainFrame mainFrame, GameController gameController) {
        this.mainFrame = mainFrame;
        this.gameController = gameController;
        initializeLayout();
        setActions();
    }
    private void initializeLayout() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        setPreferredSize(new Dimension(screen.width/4*2,screen.height/20));
//        Border border = BorderFactory.createBevelBorder(10,Color.BLACK,Color.DARK_GRAY);
//        setBorder(border);
        setBackground(Color.GRAY);
        setVisible(true);

        add(exit);
        add(goLeft);
        add(goRight);
        add(play);
        add(feed);


    }
    private void setActions() {
        exit.addActionListener(e -> {
            gameController.exit();
        });
        goRight.addActionListener(e -> {
            mainFrame.gp.setAction(Actions.MOVE);
            mainFrame.gp.moveRight();
                });

        goLeft.addActionListener(e -> {
            mainFrame.gp.setAction(Actions.MOVE);
            mainFrame.gp.moveLeft();
        });
        play.addActionListener(e -> {
            mainFrame.gp.setAction(Actions.PLAY);
            gameController.play();
        });
        feed.addActionListener(e -> {
            JPopupMenu foodMenu = new FoodMenu(mainFrame, gameController);
            foodMenu.show(feed,0,0);
        });

    }
    public void blockButtons() {
        goLeft.setEnabled(false);
        goRight.setEnabled(false);
        play.setEnabled(false);
        feed.setEnabled(false);
    }
    public void unblockButtons() {
        goLeft.setEnabled(true);
        goRight.setEnabled(true);
        play.setEnabled(true);
        feed.setEnabled(true);
    }
}
