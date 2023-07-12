package com.bilal.game;

public class Data {
    public String[] letters;
    public String[] root;
    public String[] grass;
    public String[] sky;

    public Data() {
        letters = new String[]{"a", "b", "c", "d", "f", "g", "h", "i", "j", "k", "l",
                "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        root = new String[]{"a", "c", "i",
                "m", "n", "o", "r", "s", "u", "v", "w", "x", "z"};

        grass = new String[]{"g", "j",
                "p", "q", "y"};

        sky = new String[]{"d", "f", "h", "k", "l",
                "t"};
    }

    public boolean isGrassLetter(String letter) {
        for (String grassLetter : grass) {
            if (grassLetter.equals(letter)) {
                return true;
            }
        }
        return false;
    }

    public boolean isSkyLetter(String letter) {
        for (String skyLetter : sky) {
            if (skyLetter.equals(letter)) {
                return true;
            }
        }
        return false;
    }

    public boolean isRootLetter(String letter) {
        for (String rootLetter : root) {
            if (rootLetter.equals(letter)) {
                return true;
            }
        }
        return false;
    }
}
