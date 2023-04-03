package com.github.lorellw.codewars;

import java.util.ArrayList;

public class Solution {
    /*
        Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid.
        The function should return true if the string is valid, and false if it's invalid.
     */

    public static boolean validParentheses(String parens) {
        StringBuilder input = new StringBuilder(parens);

        while (true) {
            int indexOpen = input.indexOf("(");
            int indexClose = input.indexOf(")");
            if (indexOpen == -1 && indexClose == -1) {
                return true;
            }
            if (indexOpen > indexClose || indexOpen == -1 || indexClose == -1) {
                return false;
            } else {
                input.deleteCharAt(indexOpen);
                input.deleteCharAt(indexClose - 1);
            }
        }
    }

    /*
        The rgb function is incomplete.
        Complete it so that passing in RGB decimal values will result in a hexadecimal representation being returned.
        Valid decimal values for RGB are 0 - 255.
        Any values that fall out of that range must be rounded to the closest valid value.
     */

    public static String hexToRgb(int r, int g, int b) {
        return String.format("%02X%02X%02X",
                Math.max(Math.min(r, 255), 0),
                Math.max(Math.min(g, 255), 0),
                Math.max(Math.min(b, 255), 0));
    }

    /*
        A format for expressing an ordered list of integers is to use a comma separated list of either

            *individual integers

            *or a range of integers denoted by the starting integer separated from the end integer in the range by a dash, '-'.
            The range includes all integers in the interval including both endpoints. It is not considered a range unless it spans at least 3 numbers.
            For example "12,13,15-17"

            Complete the solution so that it takes a list of integers in increasing order and returns a correctly formatted string in the range format.

            -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20
            -6,-3-1,3-5,7-11,14,15,17-20
     */
    public static String rangeExtraction(int[] arr) {
        StringBuilder result = new StringBuilder("");
        Integer begin = null;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 == arr[i + 1]) {
                if (begin == null) {
                    begin = arr[i];
                }
            } else {
                result.append(add(begin, arr[i]));
                begin = null;
            }
        }
        result.append(add(begin, arr[arr.length - 1])).setLength(result.length() - 1);
        return String.valueOf(result);
    }

    private static String add(Integer begin, int arrElem) {
        if (begin == null) {
            return arrElem + ",";
        } else if (arrElem - begin == 1) {
            return begin + "," + arrElem + ",";
        } else {
            return begin + "-" + arrElem + ",";
        }
    }
}
