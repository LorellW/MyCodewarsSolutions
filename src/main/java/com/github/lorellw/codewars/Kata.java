package com.github.lorellw.codewars;

import java.util.Arrays;

public class Kata {


    /*
        Complete the function that accepts a string parameter,
        and reverses each word in the string.
        All spaces in the string should be retained.
     */
    public static String reverseWords(final String original)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String[]strings = original.split("");
        for (String string : strings) {
            if (!string.equals(" ")) {
                temp.append(string);
            } else {
                result.append(temp.reverse()).append(" ");
                temp.setLength(0);
            }
        }
        result.append(temp.reverse());

        return String.valueOf(result);
    }

    /*
        Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)

            HH = hours, padded to 2 digits, range: 00 - 99
            MM = minutes, padded to 2 digits, range: 00 - 59
            SS = seconds, padded to 2 digits, range: 00 - 59

            The maximum time never exceeds 359999 (99:59:59)
     */

    public static String makeTimeReadable(int seconds){
        if (seconds > 359999 || seconds < 0){
            return "Out of range";
        }
        return String.format("%02d:%02d:%02d",seconds / 3600,seconds % 3600 / 60,seconds % 60);
    }

    /*
        Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying
        F(n) * F(n+1) = prod.
        Your function productFib takes an integer (prod)
     */

    public static long[] productFib(long prod){
        long temp, n = 0, nPlusOne = 1;
        while (n * nPlusOne < prod){
            temp = nPlusOne;
            nPlusOne = n + nPlusOne;
            n = temp;
        }
        return new long[]{n,nPlusOne, n * nPlusOne == prod ? 1 : 0};
    }
}
