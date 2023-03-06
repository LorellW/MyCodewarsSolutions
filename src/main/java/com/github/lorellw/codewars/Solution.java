package com.github.lorellw.codewars;

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
     */
    public static String rangeExtraction(int[] arr) {
        StringBuilder result = new StringBuilder("");
        StringBuilder temp = new StringBuilder("");
        for (int i = 0; i < arr.length - 1; i++) {
            while (arr[i+1] == arr[i]+1){

            }
        }
        return null;
    }
}
