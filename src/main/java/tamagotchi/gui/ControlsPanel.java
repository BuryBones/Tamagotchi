package tamagotchi.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ControlsPanel extends JPanel {

  private final Dimension BUTTON_SIZE = new Dimension(64, 42);

  private JButton exit = new JButton("Exit");
  private JButton goLeft = new JButton(new ImageIcon(
      new BufferedImageLoader().loadImage("images/icons/left.png")
          .getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
  private JButton goRight = new JButton(new ImageIcon(
      new BufferedImageLoader().loadImage("images/icons/right.png")
          .getScaledInstance(32, 32, Image.SCALE_SMOOTH)));
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
    setPreferredSize(new Dimension(screen.width / 4 * 2, 50));
    setBackground(Color.GRAY);
    setVisible(true);

    exit.setPreferredSize(BUTTON_SIZE);
    goLeft.setPreferredSize(BUTTON_SIZE);
    goRight.setPreferredSize(BUTTON_SIZE);
    play.setPreferredSize(BUTTON_SIZE);
    feed.setPreferredSize(BUTTON_SIZE);

    add(exit);
    add(goLeft);
    add(play);
    add(feed);
    add(goRight);
  }

  private void setActions() {
    exit.addActionListener(e -> {
      gameController.exit();
    });
    exit.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(27, 0), "exit");
    exit.getActionMap().put("exit", new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        exit.doClick();
      }
    });

    goRight.addActionListener(e -> {
      mainFrame.gp.setAction(Actions.MOVE);
      mainFrame.gp.moveRight();
    });
    goRight.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(39, 0), "right");
    goRight.getActionMap().put("right", new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        goRight.doClick();
      }
    });

    goLeft.addActionListener(e -> {
      mainFrame.gp.setAction(Actions.MOVE);
      mainFrame.gp.moveLeft();
    });
    goLeft.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
        .put(KeyStroke.getKeyStroke(37, 0), "left");
    goLeft.getActionMap().put("left", new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        goLeft.doClick();
      }
    });

    play.addActionListener(e -> {
      mainFrame.gp.setAction(Actions.PLAY);
      gameController.play();
    });
    play.setMnemonic('P');
    feed.addActionListener(e -> {
      JPopupMenu foodMenu = new FoodMenu(mainFrame, gameController);
      foodMenu.show(feed, 0, 0);
    });
    feed.setMnemonic('F');

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
