package com.github.lorellw.codewars.morse;

import java.util.HashMap;
import java.util.Map;

public final class MorseCode {
    private static Map<String, String> morseCodeTable = new HashMap<>();

    static {

        morseCodeTable.put(".-", "A");
        morseCodeTable.put("-...", "B");
        morseCodeTable.put("-.-.", "C");
        morseCodeTable.put("-..", "D");
        morseCodeTable.put(".", "E");
        morseCodeTable.put("..-.", "F");
        morseCodeTable.put("--.", "G");
        morseCodeTable.put("....", "H");
        morseCodeTable.put("..", "I");
        morseCodeTable.put(".---", "J");
        morseCodeTable.put("-.-", "K");
        morseCodeTable.put(".-..", "L");
        morseCodeTable.put("--", "M");
        morseCodeTable.put("-.", "N");
        morseCodeTable.put("---", "O");
        morseCodeTable.put(".--.", "P");
        morseCodeTable.put("--.-", "Q");
        morseCodeTable.put(".-.", "R");
        morseCodeTable.put("...", "S");
        morseCodeTable.put("-", "T");
        morseCodeTable.put("..-", "U");
        morseCodeTable.put("...-", "V");
        morseCodeTable.put(".--", "W");
        morseCodeTable.put("-..-", "X");
        morseCodeTable.put("-.--", "Y");
        morseCodeTable.put("--..", "Z");

        morseCodeTable.put("-----", "0");
        morseCodeTable.put(".----", "1");
        morseCodeTable.put("..---", "2");
        morseCodeTable.put("...--", "3");
        morseCodeTable.put("....-", "4");
        morseCodeTable.put(".....", "5");
        morseCodeTable.put("-....", "6");
        morseCodeTable.put("--...", "7");
        morseCodeTable.put("---..", "8");
        morseCodeTable.put("----.", "9");

    }

    public static String get(String morseCode) {
        return morseCodeTable.get(morseCode)/* == null ? " ": morseCodeTable.get(morseCode) */;
    }
}
