package tamagotchi.gui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatusPanel extends JPanel {

  private final JLabel healthLabel = new JLabel("Health: ");
  private final JLabel funLabel = new JLabel("Fun: ");
  private JTextField health = new JTextField();
  private JTextField fun = new JTextField();
  private JLabel petName = new JLabel("");

  public StatusPanel() {
    initializeLayout();
  }

  private void initializeLayout() {
    health.setEditable(false);
    health.setColumns(3);
    fun.setEditable(false);
    fun.setColumns(3);

    add(petName);
    add(healthLabel);
    add(health);
    add(funLabel);
    add(fun);

    setBackground(Color.GRAY);
    resetStats();
  }

  public void resetStats() {
    health.setText("0");
    fun.setText("0");
    petName.setText("");
  }

  public void setHealth(int health) {
    this.health.setText(String.valueOf(health));
  }

  public void setFun(int fun) {
    this.fun.setText(String.valueOf(fun));
  }

  public void setPetName(String name) {
    petName.setText("Name: " + name);
  }
}
