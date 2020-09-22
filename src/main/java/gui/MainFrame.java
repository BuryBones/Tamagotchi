package main.java.gui;

import main.java.PetType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.TimerTask;

public class MainFrame extends JFrame {

    public MainFrame(GameController gameController) {
        this.gameController = gameController;
        initializeLayout();
    }

    GameController gameController;
    StatusPanel sp;
    GamePanel gp;
    ControlsPanel cp;

    // TODO: Delete
    public GamePanel getGp() {
        return gp;
    }

    private void initializeLayout() {

        sp = new StatusPanel();
        gp = new GamePanel(gameController);
        cp = new ControlsPanel(this, gameController);

        Container c = getContentPane();
        c.add(sp,BorderLayout.NORTH);
        c.add(gp,BorderLayout.CENTER);
        c.add(cp,BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                gameController.exit();
            }
        });

        pack();
        setTitle("Tamagotchi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    public void start() {
        startTimer();
    }
    private void startTimer() {
        // TODO: CONSTANT speed
        System.out.println("Main frame timer started");
        Timer timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sp.setHealth(gameController.getHealth());
                sp.setFun(gameController.getFun());
                gp.repaint();
            }
        });
        timer.start();
    }
    public void block() {
        cp.blockButtons();
    }
    public void unblock() {
        cp.unblockButtons();
    }
    public void displayMessage(String message, long millis) {
        gp.setMessage(message);
        // resets message label
        TimerTask resetTask = new MessageResetTask(gp);
        java.util.Timer timer = new java.util.Timer();
        timer.schedule(resetTask,millis);
    }
    public void setPetName(String name) {
        sp.setPetName(name);
    }
    public PetType askForPetType() {
        PetType[] options = PetType.getValues();
        int response = JOptionPane.showOptionDialog(this,"Select a pet","New pet",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,options,options[0]);
        if (response == -1) gameController.exitWithoutSave();
        return options[response];
    }
    public String askForName() {
        boolean validInput = false;
        String input = "";
        while (!validInput) {
            input = JOptionPane.showInputDialog(this,"Give a name");
            if (input != null && !input.isEmpty()) {
                validInput = true;
            }
        }
        return input;
    }
}
