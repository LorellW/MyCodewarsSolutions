package com.github.lorellw.codewars.morse;


import java.util.Arrays;

public class MorseCodeDecoder {

    public static String decode(String morseCode) {
        StringBuilder decodedMessage = new StringBuilder("");
        String[] morseLetters = morseCode.split(" ");
        Arrays.stream(morseLetters).forEach(s -> {
            if (MorseCode.get(s) == null) {
                decodedMessage.append(" ");
            } else {
                decodedMessage.append(MorseCode.get(s));
            }
        });

        return String.valueOf(decodedMessage).replaceAll("\\s+", " ").trim();
    }

    public static String decodeBits(String bits) {
        String clearBits = bits.replaceAll("^0+", "")
                .replaceAll("0+$", "");
        int speed = findSpeed(clearBits);
        StringBuilder morseCodeMessage = new StringBuilder("");
        String[] words = bits.split("0{"+ (speed * 7) +"}");
        Arrays.stream(words).forEach(word -> {
            String[] characters = word.replaceAll("^0+", "")
                    .replaceAll("0+$", "").split("0{" + (speed * 3) + "}");
            Arrays.stream(characters).forEach(character -> {
                morseCodeMessage.append(character
                        .replaceAll("1{" + (speed * 3) + "}", "-")
                        .replaceAll("1{" + speed + "}", ".")
                        .replaceAll("0{" + speed + "}", ""));
                morseCodeMessage.append(" ");
            });
            morseCodeMessage.append("  ");
        });
        return String.valueOf(morseCodeMessage);
    }

    private static int findSpeed(String clearBits) {
        int speed = clearBits.indexOf('0');
        if (speed == -1) {
            return clearBits.length();
        }
        String[] zeros = clearBits.split("1+");
        for (String s : zeros) {
            if (s.length() != 0 && s.length() < speed) {
                return s.length();
            }
        }
        String[] ones = clearBits.split("0+");
        for (String s : ones) {
            if (s.length() != 0 && s.length() < speed) {
                return s.length();
            }
        }
        return speed;
    }
}
