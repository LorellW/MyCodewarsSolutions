package com.github.lorellw.codewars.math;

import java.util.Arrays;
import java.util.Stack;

    /*
        Create a function that takes a positive integer and
        returns the next bigger number that can be formed by rearranging its digits.
     */

public class NextBiggerNumberSol {

    public static long nextBiggerNumber(long n) {
        if (n < 10) {
            return -1;
        }
        int[] numerals = toIntArray(n);
        int i;
        for (i = numerals.length - 1; i > 0; i--) {
            if (numerals[i] > numerals[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            return -1;
        }
        int x = numerals[i - 1], min = i;
        for (int j = i + 1; j <numerals.length; j++) {
            if (numerals[j] > x && numerals[j] < numerals[min]) {
                min = j;
            }
        }
        swap(numerals, i - 1, min);
        Arrays.sort(numerals, i, numerals.length);

        return toLong(numerals);
    }

    private static int[] toIntArray(long n) {
        int[] numerals = new int[(int) (Math.log10(n) + 1)];
        for (int i = numerals.length - 1; i >= 0; i--) {
            numerals[i] = (int) (n % 10);
            n = n / 10;
        }
        return numerals;
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static long toLong(int[] arr) {
        StringBuilder builder = new StringBuilder("");
        Arrays.stream(arr).forEach(builder::append);
        return Long.parseLong(String.valueOf(builder));
    }
}
