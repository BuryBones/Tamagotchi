package tamagotchi;

public enum PetType {
  SQUARE("Square", 0),
  ROUND("Round", 60),
  TRIANGLE("Triangle", 120);

  private final int textureValue;
  private final String name;
  private static PetType[] values = values();

  PetType(String name, int textureValue) {
    this.name = name;
    this.textureValue = textureValue;
  }

  public int getTextureValue() {
    return textureValue;
  }

  public static PetType[] getValues() {
    return values;
  }
}
