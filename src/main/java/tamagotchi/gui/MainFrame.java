package tamagotchi.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import tamagotchi.Constants;
import tamagotchi.PetType;

public class MainFrame extends JFrame {

  public MainFrame(GameController gameController) {
    this.gameController = gameController;
    initializeLayout();
  }

  GameController gameController;
  StatusPanel sp;
  GamePanel gp;
  ControlsPanel cp;
  Timer mainTimer;
  java.util.Timer countDownTimer;

  private void initializeLayout() {

    sp = new StatusPanel();
    gp = new GamePanel(gameController);
    cp = new ControlsPanel(this, gameController);

    Container c = getContentPane();
    c.add(sp, BorderLayout.NORTH);
    c.add(gp, BorderLayout.CENTER);
    c.add(cp, BorderLayout.SOUTH);

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
        gameController.exit();
      }
    });

    pack();
    setTitle("Tamagotchi " + Constants.VERSION);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
  }

  public void start() {
    startTimer();
  }

  private void startTimer() {
    // if timer is not started yet (at launch, normally)
    if (mainTimer == null || !mainTimer.isRunning()) {
      mainTimer = new Timer(Constants.SPEED, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          sp.setHealth(gameController.getHealth());
          sp.setFun(gameController.getFun());
          gp.repaint();
        }
      });
      mainTimer.start();
    }
  }

  // blocks control buttons except 'exit'
  public void block() {
    cp.blockButtons();
  }

  // unblocks control buttons
  public void unblock() {
    cp.unblockButtons();
  }

  public void displayMessage(String message, long millis) {
    gp.setMessage(message);
    // resets message label
    MessageResetTask resetTask = new MessageResetTask(gp);
    java.util.Timer timer = new java.util.Timer();
    timer.schedule(resetTask, millis);
  }

  public void countDown(long millis) {
    int delay = gp.getMessage().isEmpty() ? 0 : 5000;
    CountDownTask countDownTask = new CountDownTask(gp, millis - delay);
    countDownTimer = new java.util.Timer();
    countDownTimer.scheduleAtFixedRate(countDownTask, delay, 1000);
  }

  public void stopCountDown() {
    if (countDownTimer != null) {
      countDownTimer.cancel();
      countDownTimer.purge();
    }
    gp.resetMessage();
  }

  public void setPetName(String name) {
    sp.setPetName(name);
  }

  public PetType askForPetType() {
    PetType[] options = PetType.getValues();
    int response = JOptionPane
        .showOptionDialog(this, "Select a pet", "New pet", JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
      if (response == -1) {
          gameController.exitWithoutSave();
      }
    return options[response];
  }

  public String askForName() {
    boolean validInput = false;
    String input = "";
    while (!validInput) {
      input = JOptionPane
          .showInputDialog(this, "Give a name", "New pet", JOptionPane.PLAIN_MESSAGE);
      if (input == null) {
        // if "cancel" button is pressed
        gameController.exitWithoutSave();
      } else if (!input.isEmpty()) {
        // only if some name was given
        validInput = true;
      }
    }
    return input;
  }

  // displays error and exits program
  public void displayError(String message, boolean exit) {
    JOptionPane.showMessageDialog(this, message, "ERROR", JOptionPane.ERROR_MESSAGE);
      if (exit) {
          gameController.exitWithoutSave();
      }
  }
}
