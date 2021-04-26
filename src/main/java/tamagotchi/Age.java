package tamagotchi;

public enum Age {

  BABY("baby", 0),
  CHILD("child", 20),
  ADULT("adult", 40);

  private final String desc;
  private final int textureValue;
  private static final Age[] values = values();

  Age(String s, int textureValue) {
    desc = s;
    this.textureValue = textureValue;
  }

  // returns next age value or current value if maximum reached
  public Age next() {
    if (isMaxAge()) {
      return this;
    } else {
      return values[ordinal() + 1];
    }
  }

  public int getTextureValue() {
    return textureValue;
  }

  public boolean isMaxAge() {
    return this.equals(getMax());
  }

  public static Age getMin() {
    return values[0];
  }

  public static Age getMax() {
    return values[values.length - 1];
  }

  public String toString() {
    return desc;
  }
}
