package tamagotchi;

public enum Mood {

  HAPPY("happy", 12),
  GLAD("glad", 9),
  NEUTRAL("ok", 6),
  UPSET("upset", 3),
  UNHAPPY("unhappy", 0);

  private String text;
  private int textureValue;
  private static Mood[][] moodMatrix = new Mood[5][5];

  static {
    moodMatrix[0][0] = Mood.UNHAPPY;
    moodMatrix[0][1] = Mood.UNHAPPY;
    moodMatrix[0][2] = Mood.UNHAPPY;
    moodMatrix[0][3] = Mood.UNHAPPY;
    moodMatrix[0][4] = Mood.UNHAPPY;

    moodMatrix[1][0] = Mood.UNHAPPY;
    moodMatrix[1][1] = Mood.UNHAPPY;
    moodMatrix[1][2] = Mood.UNHAPPY;
    moodMatrix[1][3] = Mood.UPSET;
    moodMatrix[1][4] = Mood.UPSET;

    moodMatrix[2][0] = Mood.UNHAPPY;
    moodMatrix[2][1] = Mood.UNHAPPY;
    moodMatrix[2][2] = Mood.UPSET;
    moodMatrix[2][3] = Mood.NEUTRAL;
    moodMatrix[2][4] = Mood.NEUTRAL;

    moodMatrix[3][0] = Mood.UNHAPPY;
    moodMatrix[3][1] = Mood.UPSET;
    moodMatrix[3][2] = Mood.NEUTRAL;
    moodMatrix[3][3] = Mood.GLAD;
    moodMatrix[3][4] = Mood.GLAD;

    moodMatrix[4][0] = Mood.UPSET;
    moodMatrix[4][1] = Mood.NEUTRAL;
    moodMatrix[4][2] = Mood.GLAD;
    moodMatrix[4][3] = Mood.HAPPY;
    moodMatrix[4][4] = Mood.HAPPY;
  }

  Mood(String s, int textureValue) {
    text = s;
    this.textureValue = textureValue;
  }

  public String toString() {
    return text;
  }

  public int getTextureValue() {
    return textureValue;
  }

  public static Mood getMoodFromMatrix(int x, int y) {
    return moodMatrix[x][y];
  }
}
