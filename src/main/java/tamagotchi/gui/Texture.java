package tamagotchi.gui;

import java.awt.image.BufferedImage;

public class Texture {

  // singleton
  private static Texture instance = new Texture();

  public static Texture getInstance() {
    if (instance == null) {
      instance = new Texture();
    }
    return instance;
  }

  private Texture() {
    BufferedImageLoader loader = new BufferedImageLoader();
    petSheet = loader.loadImage("images/pets/petSheet.png");

    ps = new SpriteSheet(petSheet);

    getTextures();
  }

  private final int IMAGE_SIDE = 264;

  private SpriteSheet ps;
  private BufferedImage petSheet;

  private void getTextures() {

    // SQUARE
    // square baby
    pet[0] = ps.grabImage(1, 1, IMAGE_SIDE, IMAGE_SIDE); // square baby unhappy stay
    pet[1] = ps.grabImage(1, 2, IMAGE_SIDE, IMAGE_SIDE); // square baby unhappy move1
    pet[2] = ps.grabImage(1, 3, IMAGE_SIDE, IMAGE_SIDE); // square baby unhappy move2

    pet[3] = ps.grabImage(2, 1, IMAGE_SIDE, IMAGE_SIDE); // square baby upset stay
    pet[4] = ps.grabImage(2, 2, IMAGE_SIDE, IMAGE_SIDE); // square baby upset move1
    pet[5] = ps.grabImage(2, 3, IMAGE_SIDE, IMAGE_SIDE); // square baby upset move2

    pet[6] = ps.grabImage(3, 1, IMAGE_SIDE, IMAGE_SIDE); // square baby neutral stay
    pet[7] = ps.grabImage(3, 2, IMAGE_SIDE, IMAGE_SIDE); // square baby neutral move1
    pet[8] = ps.grabImage(3, 3, IMAGE_SIDE, IMAGE_SIDE); // square baby neutral move2

    pet[9] = ps.grabImage(4, 1, IMAGE_SIDE, IMAGE_SIDE); // square baby glad stay
    pet[10] = ps.grabImage(4, 2, IMAGE_SIDE, IMAGE_SIDE); // square baby glad move1
    pet[11] = ps.grabImage(4, 3, IMAGE_SIDE, IMAGE_SIDE); // square baby glad move2

    pet[12] = ps.grabImage(5, 1, IMAGE_SIDE, IMAGE_SIDE); // square baby happy stay
    pet[13] = ps.grabImage(5, 2, IMAGE_SIDE, IMAGE_SIDE); // square baby happy move1
    pet[14] = ps.grabImage(5, 3, IMAGE_SIDE, IMAGE_SIDE); // square baby happy move2

    pet[15] = ps.grabImage(1, 4, IMAGE_SIDE, IMAGE_SIDE); // square baby dead
    pet[16] = ps.grabImage(2, 4, IMAGE_SIDE, IMAGE_SIDE); // square baby eat1
    pet[17] = ps.grabImage(3, 4, IMAGE_SIDE, IMAGE_SIDE); // square baby eat2
    pet[18] = ps.grabImage(4, 4, IMAGE_SIDE, IMAGE_SIDE); // square baby play1
    pet[19] = ps.grabImage(5, 4, IMAGE_SIDE, IMAGE_SIDE); // square baby play2

    // square child
    pet[20] = ps.grabImage(1, 5, IMAGE_SIDE, IMAGE_SIDE); // square child unhappy stay
    pet[21] = ps.grabImage(1, 6, IMAGE_SIDE, IMAGE_SIDE); // square child unhappy move1
    pet[22] = ps.grabImage(1, 7, IMAGE_SIDE, IMAGE_SIDE); // square child unhappy move2

    pet[23] = ps.grabImage(2, 5, IMAGE_SIDE, IMAGE_SIDE); // square child upset stay
    pet[24] = ps.grabImage(2, 6, IMAGE_SIDE, IMAGE_SIDE); // square child upset move1
    pet[25] = ps.grabImage(2, 7, IMAGE_SIDE, IMAGE_SIDE); // square child upset move2

    pet[26] = ps.grabImage(3, 5, IMAGE_SIDE, IMAGE_SIDE); // square child neutral stay
    pet[27] = ps.grabImage(3, 6, IMAGE_SIDE, IMAGE_SIDE); // square child neutral move1
    pet[28] = ps.grabImage(3, 7, IMAGE_SIDE, IMAGE_SIDE); // square child neutral move2

    pet[29] = ps.grabImage(4, 5, IMAGE_SIDE, IMAGE_SIDE); // square child glad stay
    pet[30] = ps.grabImage(4, 6, IMAGE_SIDE, IMAGE_SIDE); // square child glad move1
    pet[31] = ps.grabImage(4, 7, IMAGE_SIDE, IMAGE_SIDE); // square child glad move2

    pet[32] = ps.grabImage(5, 5, IMAGE_SIDE, IMAGE_SIDE); // square child happy stay
    pet[33] = ps.grabImage(5, 6, IMAGE_SIDE, IMAGE_SIDE); // square child happy move1
    pet[34] = ps.grabImage(5, 7, IMAGE_SIDE, IMAGE_SIDE); // square child happy move2

    pet[35] = ps.grabImage(1, 8, IMAGE_SIDE, IMAGE_SIDE); // square child dead
    pet[36] = ps.grabImage(2, 8, IMAGE_SIDE, IMAGE_SIDE); // square child eat1
    pet[37] = ps.grabImage(3, 8, IMAGE_SIDE, IMAGE_SIDE); // square child eat2
    pet[38] = ps.grabImage(4, 8, IMAGE_SIDE, IMAGE_SIDE); // square child play1
    pet[39] = ps.grabImage(5, 8, IMAGE_SIDE, IMAGE_SIDE); // square child play2

    // square adult
    pet[40] = ps.grabImage(1, 9, IMAGE_SIDE, IMAGE_SIDE); // square adult unhappy stay
    pet[41] = ps.grabImage(1, 10, IMAGE_SIDE, IMAGE_SIDE); // square adult unhappy move1
    pet[42] = ps.grabImage(1, 11, IMAGE_SIDE, IMAGE_SIDE); // square adult unhappy move2

    pet[43] = ps.grabImage(2, 9, IMAGE_SIDE, IMAGE_SIDE); // square adult upset stay
    pet[44] = ps.grabImage(2, 10, IMAGE_SIDE, IMAGE_SIDE); // square adult upset move1
    pet[45] = ps.grabImage(2, 11, IMAGE_SIDE, IMAGE_SIDE); // square adult upset move2

    pet[46] = ps.grabImage(3, 9, IMAGE_SIDE, IMAGE_SIDE); // square adult neutral stay
    pet[47] = ps.grabImage(3, 10, IMAGE_SIDE, IMAGE_SIDE); // square adult neutral move1
    pet[48] = ps.grabImage(3, 11, IMAGE_SIDE, IMAGE_SIDE); // square adult neutral move2

    pet[49] = ps.grabImage(4, 9, IMAGE_SIDE, IMAGE_SIDE); // square adult glad stay
    pet[50] = ps.grabImage(4, 10, IMAGE_SIDE, IMAGE_SIDE); // square adult glad move1
    pet[51] = ps.grabImage(4, 11, IMAGE_SIDE, IMAGE_SIDE); // square adult glad move2

    pet[52] = ps.grabImage(5, 9, IMAGE_SIDE, IMAGE_SIDE); // square adult happy stay
    pet[53] = ps.grabImage(5, 10, IMAGE_SIDE, IMAGE_SIDE); // square adult happy move1
    pet[54] = ps.grabImage(5, 11, IMAGE_SIDE, IMAGE_SIDE); // square adult happy move2

    pet[55] = ps.grabImage(1, 12, IMAGE_SIDE, IMAGE_SIDE); // square adult dead
    pet[56] = ps.grabImage(2, 12, IMAGE_SIDE, IMAGE_SIDE); // square adult eat1
    pet[57] = ps.grabImage(3, 12, IMAGE_SIDE, IMAGE_SIDE); // square adult eat2
    pet[58] = ps.grabImage(4, 12, IMAGE_SIDE, IMAGE_SIDE); // square adult play1
    pet[59] = ps.grabImage(5, 12, IMAGE_SIDE, IMAGE_SIDE); // square adult play2

    // ROUND
    // round baby
    pet[60] = ps.grabImage(1, 13, IMAGE_SIDE, IMAGE_SIDE); // round baby unhappy stay
    pet[61] = ps.grabImage(1, 14, IMAGE_SIDE, IMAGE_SIDE); // round baby unhappy move1
    pet[62] = ps.grabImage(1, 15, IMAGE_SIDE, IMAGE_SIDE); // round baby unhappy move2

    pet[63] = ps.grabImage(2, 13, IMAGE_SIDE, IMAGE_SIDE); // round baby upset stay
    pet[64] = ps.grabImage(2, 14, IMAGE_SIDE, IMAGE_SIDE); // round baby upset move1
    pet[65] = ps.grabImage(2, 15, IMAGE_SIDE, IMAGE_SIDE); // round baby upset move2

    pet[66] = ps.grabImage(3, 13, IMAGE_SIDE, IMAGE_SIDE); // round baby neutral stay
    pet[67] = ps.grabImage(3, 14, IMAGE_SIDE, IMAGE_SIDE); // round baby neutral move1
    pet[68] = ps.grabImage(3, 15, IMAGE_SIDE, IMAGE_SIDE); // round baby neutral move2

    pet[69] = ps.grabImage(4, 13, IMAGE_SIDE, IMAGE_SIDE); // round baby glad stay
    pet[70] = ps.grabImage(4, 14, IMAGE_SIDE, IMAGE_SIDE); // round baby glad move1
    pet[71] = ps.grabImage(4, 15, IMAGE_SIDE, IMAGE_SIDE); // round baby glad move2

    pet[72] = ps.grabImage(5, 13, IMAGE_SIDE, IMAGE_SIDE); // round baby happy stay
    pet[73] = ps.grabImage(5, 14, IMAGE_SIDE, IMAGE_SIDE); // round baby happy move1
    pet[74] = ps.grabImage(5, 15, IMAGE_SIDE, IMAGE_SIDE); // round baby happy move2

    pet[75] = ps.grabImage(1, 16, IMAGE_SIDE, IMAGE_SIDE); // round baby dead
    pet[76] = ps.grabImage(2, 16, IMAGE_SIDE, IMAGE_SIDE); // round baby eat1
    pet[77] = ps.grabImage(3, 16, IMAGE_SIDE, IMAGE_SIDE); // round baby eat2
    pet[78] = ps.grabImage(4, 16, IMAGE_SIDE, IMAGE_SIDE); // round baby play1
    pet[79] = ps.grabImage(5, 16, IMAGE_SIDE, IMAGE_SIDE); // round baby play2

    // round child
    pet[80] = ps.grabImage(1, 17, IMAGE_SIDE, IMAGE_SIDE); // round child unhappy stay
    pet[81] = ps.grabImage(1, 18, IMAGE_SIDE, IMAGE_SIDE); // round child unhappy move1
    pet[82] = ps.grabImage(1, 19, IMAGE_SIDE, IMAGE_SIDE); // round child unhappy move2

    pet[83] = ps.grabImage(2, 17, IMAGE_SIDE, IMAGE_SIDE); // round child upset stay
    pet[84] = ps.grabImage(2, 18, IMAGE_SIDE, IMAGE_SIDE); // round child upset move1
    pet[85] = ps.grabImage(2, 19, IMAGE_SIDE, IMAGE_SIDE); // round child upset move2

    pet[86] = ps.grabImage(3, 17, IMAGE_SIDE, IMAGE_SIDE); // round child neutral stay
    pet[87] = ps.grabImage(3, 18, IMAGE_SIDE, IMAGE_SIDE); // round child neutral move1
    pet[88] = ps.grabImage(3, 19, IMAGE_SIDE, IMAGE_SIDE); // round child neutral move2

    pet[89] = ps.grabImage(4, 17, IMAGE_SIDE, IMAGE_SIDE); // round child glad stay
    pet[90] = ps.grabImage(4, 18, IMAGE_SIDE, IMAGE_SIDE); // round child glad move1
    pet[91] = ps.grabImage(4, 19, IMAGE_SIDE, IMAGE_SIDE); // round child glad move2

    pet[92] = ps.grabImage(5, 17, IMAGE_SIDE, IMAGE_SIDE); // round child happy stay
    pet[93] = ps.grabImage(5, 18, IMAGE_SIDE, IMAGE_SIDE); // round child happy move1
    pet[94] = ps.grabImage(5, 19, IMAGE_SIDE, IMAGE_SIDE); // round child happy move2

    pet[95] = ps.grabImage(1, 20, IMAGE_SIDE, IMAGE_SIDE); // round child dead
    pet[96] = ps.grabImage(2, 20, IMAGE_SIDE, IMAGE_SIDE); // round child eat1
    pet[97] = ps.grabImage(3, 20, IMAGE_SIDE, IMAGE_SIDE); // round child eat2
    pet[98] = ps.grabImage(4, 20, IMAGE_SIDE, IMAGE_SIDE); // round child play1
    pet[99] = ps.grabImage(5, 20, IMAGE_SIDE, IMAGE_SIDE); // round child play2

    // round adult
    pet[100] = ps.grabImage(1, 21, IMAGE_SIDE, IMAGE_SIDE); // round adult unhappy stay
    pet[101] = ps.grabImage(1, 22, IMAGE_SIDE, IMAGE_SIDE); // round adult unhappy move1
    pet[102] = ps.grabImage(1, 23, IMAGE_SIDE, IMAGE_SIDE); // round adult unhappy move2

    pet[103] = ps.grabImage(2, 21, IMAGE_SIDE, IMAGE_SIDE); // round adult upset stay
    pet[104] = ps.grabImage(2, 22, IMAGE_SIDE, IMAGE_SIDE); // round adult upset move1
    pet[105] = ps.grabImage(2, 23, IMAGE_SIDE, IMAGE_SIDE); // round adult upset move2

    pet[106] = ps.grabImage(3, 21, IMAGE_SIDE, IMAGE_SIDE); // round adult neutral stay
    pet[107] = ps.grabImage(3, 22, IMAGE_SIDE, IMAGE_SIDE); // round adult neutral move1
    pet[108] = ps.grabImage(3, 23, IMAGE_SIDE, IMAGE_SIDE); // round adult neutral move2

    pet[109] = ps.grabImage(4, 21, IMAGE_SIDE, IMAGE_SIDE); // round adult glad stay
    pet[110] = ps.grabImage(4, 22, IMAGE_SIDE, IMAGE_SIDE); // round adult glad move1
    pet[111] = ps.grabImage(4, 23, IMAGE_SIDE, IMAGE_SIDE); // round adult glad move2

    pet[112] = ps.grabImage(5, 21, IMAGE_SIDE, IMAGE_SIDE); // round adult happy stay
    pet[113] = ps.grabImage(5, 22, IMAGE_SIDE, IMAGE_SIDE); // round adult happy move1
    pet[114] = ps.grabImage(5, 23, IMAGE_SIDE, IMAGE_SIDE); // round adult happy move2

    pet[115] = ps.grabImage(1, 24, IMAGE_SIDE, IMAGE_SIDE); // round adult dead
    pet[116] = ps.grabImage(2, 24, IMAGE_SIDE, IMAGE_SIDE); // round adult eat1
    pet[117] = ps.grabImage(3, 24, IMAGE_SIDE, IMAGE_SIDE); // round adult eat2
    pet[118] = ps.grabImage(4, 24, IMAGE_SIDE, IMAGE_SIDE); // round adult play1
    pet[119] = ps.grabImage(5, 24, IMAGE_SIDE, IMAGE_SIDE); // round adult play2

    // TRIANGLE
    // triangle baby
    pet[120] = ps.grabImage(1, 25, IMAGE_SIDE, IMAGE_SIDE); // triangle baby unhappy stay
    pet[121] = ps.grabImage(1, 26, IMAGE_SIDE, IMAGE_SIDE); // triangle baby unhappy move1
    pet[122] = ps.grabImage(1, 27, IMAGE_SIDE, IMAGE_SIDE); // triangle baby unhappy move2

    pet[123] = ps.grabImage(2, 25, IMAGE_SIDE, IMAGE_SIDE); // triangle baby upset stay
    pet[124] = ps.grabImage(2, 26, IMAGE_SIDE, IMAGE_SIDE); // triangle baby upset move1
    pet[125] = ps.grabImage(2, 27, IMAGE_SIDE, IMAGE_SIDE); // triangle baby upset move2

    pet[126] = ps.grabImage(3, 25, IMAGE_SIDE, IMAGE_SIDE); // triangle baby neutral stay
    pet[127] = ps.grabImage(3, 26, IMAGE_SIDE, IMAGE_SIDE); // triangle baby neutral move1
    pet[128] = ps.grabImage(3, 27, IMAGE_SIDE, IMAGE_SIDE); // triangle baby neutral move2

    pet[129] = ps.grabImage(4, 25, IMAGE_SIDE, IMAGE_SIDE); // triangle baby glad stay
    pet[130] = ps.grabImage(4, 26, IMAGE_SIDE, IMAGE_SIDE); // triangle baby glad move1
    pet[131] = ps.grabImage(4, 27, IMAGE_SIDE, IMAGE_SIDE); // triangle baby glad move2

    pet[132] = ps.grabImage(5, 25, IMAGE_SIDE, IMAGE_SIDE); // triangle baby happy stay
    pet[133] = ps.grabImage(5, 26, IMAGE_SIDE, IMAGE_SIDE); // triangle baby happy move1
    pet[134] = ps.grabImage(5, 27, IMAGE_SIDE, IMAGE_SIDE); // triangle baby happy move2

    pet[135] = ps.grabImage(1, 28, IMAGE_SIDE, IMAGE_SIDE); // triangle baby dead
    pet[136] = ps.grabImage(2, 28, IMAGE_SIDE, IMAGE_SIDE); // triangle baby eat1
    pet[137] = ps.grabImage(3, 28, IMAGE_SIDE, IMAGE_SIDE); // triangle baby eat2
    pet[138] = ps.grabImage(4, 28, IMAGE_SIDE, IMAGE_SIDE); // triangle baby play1
    pet[139] = ps.grabImage(5, 28, IMAGE_SIDE, IMAGE_SIDE); // triangle baby play2

    // round child
    pet[140] = ps.grabImage(1, 29, IMAGE_SIDE, IMAGE_SIDE); // triangle child unhappy stay
    pet[141] = ps.grabImage(1, 30, IMAGE_SIDE, IMAGE_SIDE); // triangle child unhappy move1
    pet[142] = ps.grabImage(1, 31, IMAGE_SIDE, IMAGE_SIDE); // triangle child unhappy move2

    pet[143] = ps.grabImage(2, 29, IMAGE_SIDE, IMAGE_SIDE); // triangle child upset stay
    pet[144] = ps.grabImage(2, 30, IMAGE_SIDE, IMAGE_SIDE); // triangle child upset move1
    pet[145] = ps.grabImage(2, 31, IMAGE_SIDE, IMAGE_SIDE); // triangle child upset move2

    pet[146] = ps.grabImage(3, 29, IMAGE_SIDE, IMAGE_SIDE); // triangle child neutral stay
    pet[147] = ps.grabImage(3, 30, IMAGE_SIDE, IMAGE_SIDE); // triangle child neutral move1
    pet[148] = ps.grabImage(3, 31, IMAGE_SIDE, IMAGE_SIDE); // triangle child neutral move2

    pet[149] = ps.grabImage(4, 29, IMAGE_SIDE, IMAGE_SIDE); // triangle child glad stay
    pet[150] = ps.grabImage(4, 30, IMAGE_SIDE, IMAGE_SIDE); // triangle child glad move1
    pet[151] = ps.grabImage(4, 31, IMAGE_SIDE, IMAGE_SIDE); // triangle child glad move2

    pet[152] = ps.grabImage(5, 29, IMAGE_SIDE, IMAGE_SIDE); // triangle child happy stay
    pet[153] = ps.grabImage(5, 30, IMAGE_SIDE, IMAGE_SIDE); // triangle child happy move1
    pet[154] = ps.grabImage(5, 31, IMAGE_SIDE, IMAGE_SIDE); // triangle child happy move2

    pet[155] = ps.grabImage(1, 32, IMAGE_SIDE, IMAGE_SIDE); // triangle child dead
    pet[156] = ps.grabImage(2, 32, IMAGE_SIDE, IMAGE_SIDE); // triangle child eat1
    pet[157] = ps.grabImage(3, 32, IMAGE_SIDE, IMAGE_SIDE); // triangle child eat2
    pet[158] = ps.grabImage(4, 32, IMAGE_SIDE, IMAGE_SIDE); // triangle child play1
    pet[159] = ps.grabImage(5, 32, IMAGE_SIDE, IMAGE_SIDE); // triangle child play2

    // round adult
    pet[160] = ps.grabImage(1, 33, IMAGE_SIDE, IMAGE_SIDE); // triangle adult unhappy stay
    pet[161] = ps.grabImage(1, 34, IMAGE_SIDE, IMAGE_SIDE); // triangle adult unhappy move1
    pet[162] = ps.grabImage(1, 35, IMAGE_SIDE, IMAGE_SIDE); // triangle adult unhappy move2

    pet[163] = ps.grabImage(2, 33, IMAGE_SIDE, IMAGE_SIDE); // triangle adult upset stay
    pet[164] = ps.grabImage(2, 34, IMAGE_SIDE, IMAGE_SIDE); // triangle adult upset move1
    pet[165] = ps.grabImage(2, 35, IMAGE_SIDE, IMAGE_SIDE); // triangle adult upset move2

    pet[166] = ps.grabImage(3, 33, IMAGE_SIDE, IMAGE_SIDE); // triangle adult neutral stay
    pet[167] = ps.grabImage(3, 34, IMAGE_SIDE, IMAGE_SIDE); // triangle adult neutral move1
    pet[168] = ps.grabImage(3, 35, IMAGE_SIDE, IMAGE_SIDE); // triangle adult neutral move2

    pet[169] = ps.grabImage(4, 33, IMAGE_SIDE, IMAGE_SIDE); // triangle adult glad stay
    pet[170] = ps.grabImage(4, 34, IMAGE_SIDE, IMAGE_SIDE); // triangle adult glad move1
    pet[171] = ps.grabImage(4, 35, IMAGE_SIDE, IMAGE_SIDE); // triangle adult glad move2

    pet[172] = ps.grabImage(5, 33, IMAGE_SIDE, IMAGE_SIDE); // triangle adult happy stay
    pet[173] = ps.grabImage(5, 34, IMAGE_SIDE, IMAGE_SIDE); // triangle adult happy move1
    pet[174] = ps.grabImage(5, 35, IMAGE_SIDE, IMAGE_SIDE); // triangle adult happy move2

    pet[175] = ps.grabImage(1, 36, IMAGE_SIDE, IMAGE_SIDE); // triangle adult dead
    pet[176] = ps.grabImage(2, 36, IMAGE_SIDE, IMAGE_SIDE); // triangle adult eat1
    pet[177] = ps.grabImage(3, 36, IMAGE_SIDE, IMAGE_SIDE); // triangle adult eat2
    pet[178] = ps.grabImage(4, 36, IMAGE_SIDE, IMAGE_SIDE); // triangle adult play1
    pet[179] = ps.grabImage(5, 36, IMAGE_SIDE, IMAGE_SIDE); // triangle adult play2
  }

  public BufferedImage[] pet = new BufferedImage[180];

  public BufferedImage getPetImage(int index) {
    return pet[index];
  }

  public BufferedImage[] getPetImage(int... indexes) {
    BufferedImage[] result = new BufferedImage[indexes.length];
    for (int i = 0; i < indexes.length; i++) {
      result[i] = pet[indexes[i]];
    }
    return result;
  }
}
