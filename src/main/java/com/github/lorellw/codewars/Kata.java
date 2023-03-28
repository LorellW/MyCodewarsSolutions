package com.github.lorellw.codewars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Kata {


    /*
        Complete the function that accepts a string parameter,
        and reverses each word in the string.
        All spaces in the string should be retained.
     */
    public static String reverseWords(final String original) {
        StringBuilder result = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String[] strings = original.split("");
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

    public static String makeTimeReadable(int seconds) {
        if (seconds > 359999 || seconds < 0) {
            return "Out of range";
        }
        return String.format("%02d:%02d:%02d", seconds / 3600, seconds % 3600 / 60, seconds % 60);
    }

    /*
        Given a number, say prod (for product), we search two Fibonacci numbers F(n) and F(n+1) verifying
        F(n) * F(n+1) = prod.
        Your function productFib takes an integer (prod)
     */

    public static long[] productFib(long prod) {
        long temp, n = 0, nPlusOne = 1;
        while (n * nPlusOne < prod) {
            temp = nPlusOne;
            nPlusOne = n + nPlusOne;
            n = temp;
        }
        return new long[]{n, nPlusOne, n * nPlusOne == prod ? 1 : 0};
    }

    public static String[] dirReduction(String[] arr) {
        Stack<String> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.empty()) {
                stack.push(arr[i]);
            } else {
                String temp = stack.peek();
                if ((temp.equals("NORTH") && arr[i].equals("SOUTH"))
                        || (temp.equals("SOUTH") && arr[i].equals("NORTH"))
                        || (temp.equals("WEST") && arr[i].equals("EAST"))
                        || (temp.equals("EAST") && arr[i].equals("WEST"))
                ) {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            }
        }
        return stack.toArray(new String[]{});
    }

    public static String orderWeight(String string) {
        String[] arr = string.split(" ");
        Arrays.sort(arr, (o1, o2) -> {
            if (innerSum(o1) < innerSum(o2)) {
                return -1;
            } else if (innerSum(o1) > innerSum(o2)) {
                return 1;
            } else {
                return o1.compareTo(o2);
            }
        });
        StringBuilder result = new StringBuilder("");
        Arrays.stream(arr).forEach(s -> {
            result.append(s).append(" ");
        });
        return String.valueOf(result).trim();
    }

    private static long innerSum(String strNumber) {
        long a = Long.parseLong(strNumber);
        int sum = 0;
        while (a > 0) {
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }

    /*
         Three 1's => 1000 points
         Three 6's =>  600 points
         Three 5's =>  500 points
         Three 4's =>  400 points
         Three 3's =>  300 points
         Three 2's =>  200 points
         One   1   =>  100 points
         One   5   =>   50 point
     */

    public static int greedy(int[] dice) {
        int result = 0;
        int[] temp = new int[6];
        for (int d : dice) {
            temp[d - 1]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] >= 3) {
                result += (i + 1) * 100;
                if (i == 0) {
                    result *= 10;
                }
                temp[i] -= 3;
            }
        }
        result += temp[0] * 100;
        result += temp[4] * 50;
        return result;
    }

    /*
        Write a program that will calculate the number of trailing zeros in a factorial of a given number.
     */
    public static int zeros(int n) {
        int result = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            result += n / i;
        }
        return result;
    }


    /*
        Complete the function scramble(str1, str2) that returns true if a portion of str1 characters
        can be rearranged to match str2, otherwise returns false.

        Only lower case letters will be used (a-z). No punctuation or digits will be included.

        Performance needs to be considered.
     */

    public static boolean scramble(String str1, String str2) {

        if (str1.length() < str2.length()) {
            return false;
        }

        char[] chars = str1.toCharArray();
        char[] word = str2.toCharArray();

        Map<Character, Integer> countOfChars = new HashMap<>();
        for (char aChar : chars) {
            if (countOfChars.containsKey(aChar)) {
                countOfChars.replace(aChar, countOfChars.get(aChar) + 1);
            } else {
                countOfChars.put(aChar, 1);
            }
        }

        for (char temp : word) {
            if (!countOfChars.containsKey(temp)) {
                return false;
            }
            countOfChars.replace(temp, countOfChars.get(temp) - 1);
            if (countOfChars.get(temp) < 0) {
                return false;
            }
        }

        return true;
    }
}
