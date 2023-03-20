package com.github.lorellw.codewars;

import java.util.Arrays;
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
        Arrays.sort(arr,(o1, o2) -> {
            if (innerSum(o1) < innerSum(o2)){
                return -1;
            } else if (innerSum(o1) > innerSum(o2)){
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
}
