package tamagotchi.gui;

import java.awt.image.BufferedImage;

public class Animation {

  private BufferedImage[] frames;
  private int limit;

  private int currentIndex = 0;
  private int count = 0;

  public Animation(BufferedImage[] frames, int times) {
    this.frames = frames;
    limit = frames.length * times;
  }

  public BufferedImage nextFrameOrNullIfFinished() {
    BufferedImage result;
    if (count < limit) {
      // give
      result = frames[currentIndex++];
      if (currentIndex >= frames.length) {
        currentIndex = 0;
      }
    } else {
      result = null;
    }
    count++;
    return result;
  }
}
