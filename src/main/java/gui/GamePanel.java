package main.java.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    GameController gameController;
    public GamePanel(GameController gameController) {
        this.gameController = gameController;
        initialize();
    }

    private int panelWidth;
    private int panelHeight;
    private Actions currentAction = Actions.IDLE;
    private JLabel message = new JLabel("");

    private int x, y;
    private BufferedImage image;
    Texture texture = Texture.getInstance();
    private Animation animation;

    private void initialize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();
        Dimension panelDimension = new Dimension(screen.width/4*2,screen.height/4*2);
        setPreferredSize(panelDimension);
        panelWidth = panelDimension.width;
        panelHeight = panelDimension.height;

        message.setFont(new Font("Serif",Font.PLAIN,32));
        add(message);

        x = panelWidth/2-264/2;
        y = panelHeight-264;

        setVisible(true);
    }
    void setAction(Actions action) {
        currentAction = action;
        switch (currentAction) {
            case PLAY:
                play();
                break;
            case EAT:
                eat();
                break;
            case MOVE:
                move();
                break;
        }
    }
    void resetAction() {
        currentAction = Actions.IDLE;
    }
    private void renewPetModel() {
        if (gameController.isPetNull()) return;
        if (currentAction == Actions.IDLE) {
            setIdleImage();
        } else {
            setImage();
        }
    }
    private void setImage() {
        BufferedImage result = animation.nextFrameOrNullIfFinished();
        if (result == null) {
            resetAction();
        } else {
            image = result;
        }
    }
    @Override
    public void paint(Graphics g) {
        renewPetModel();
        super.paint(g);
        g.drawImage(image,x,y,null);
    }
    void setIdleImage() {
        int index = 0;
        index += gameController.getPetType().getTextureValue();
        index += gameController.getPetAge().getTextureValue();
        if (gameController.isPetAlive()) {
            index += gameController.getPetMood().getTextureValue();
        } else {
            index += 15;
        }
        image = texture.getPetImage(index);
    }
    void moveRight() {
        if (x <= panelWidth - 264) {
            x += 10;
        }
    }
    void moveLeft() {
        if (x >= 0) {
            x -= 10;
        }
    }
    void setMessage(String message) {
        this.message.setText(message);
    }
    String getMessage() {
        return message.getText();
    }
    void resetMessage() {
        this.message.setText("");
    }
    private int getAnimationIndexWithTypeAndAge() {
        return gameController.getPetType().getTextureValue() + gameController.getPetAge().getTextureValue();
    }

    public void play() {
        int index = getAnimationIndexWithTypeAndAge();
        BufferedImage[] frames = texture.getPetImage(index+18,index+19);
        animation = new Animation(frames,4);
    }
    public void eat() {
        int index = getAnimationIndexWithTypeAndAge();
        BufferedImage[] frames = texture.getPetImage(index+16,index+17);
        animation = new Animation(frames,3);
    }
    public void move() {
        int index = getAnimationIndexWithTypeAndAge();
        index += gameController.getPetMood().getTextureValue();
        BufferedImage[] frames = texture.getPetImage(index+1,index+2);
        animation = new Animation(frames,1);
    }
}
