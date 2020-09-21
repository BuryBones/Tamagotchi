package main.java;

public enum Mood {

    HAPPY("happy",12),
    GLAD("glad",9),
    NEUTRAL("ok",6),
    UPSET("upset",3),
    UNHAPPY("unhappy",0);

    private String text;
    private int textureValue;

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
}
