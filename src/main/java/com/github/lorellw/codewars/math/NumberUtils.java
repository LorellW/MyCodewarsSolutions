package com.github.lorellw.codewars.math;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class NumberUtils {

    /*
        Your code must return true or false (not 'true' and 'false') depending upon whether the given number is
        a Narcissistic number in base 10. This may be True and False in your language, e.g. PHP.
        Error checking for text strings or other invalid inputs is not required,
        only valid positive non-zero integers will be passed into the function.
     */
    public static boolean isNarcissistic(int i) {
        int length = (int) (Math.log10(i) + 1);
        int x = 0;
        int n = i;
        while (n > 0) {
            x = x + (int) Math.pow(n % 10, length);
            n = n / 10;
        }
        return i == x;
    }

    /*
        The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:

        Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
        If the list is made up of only negative numbers, return 0 instead.

        Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
    */

    public static int maxSequence(int[] arr) {
        int localMaxSum = 0, maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                for (int j = i; j < arr.length; j++) {
                    localMaxSum += arr[j];
                    if (localMaxSum > maxSum) {
                        maxSum = localMaxSum;
                    }
                }
                localMaxSum = 0;
            }
        }
        return maxSum;
    }

    /*
        We need to sum big numbers and we require your help.

        Write a function that returns the sum of two numbers.
        The input numbers are strings and the function must return a string.
     */

    public static String bigAdd(String a, String b) {
        StringBuilder result = new StringBuilder("");
        String[] aStrings = a.replaceAll("^0+", "").split("");
        String[] bStrings = b.replaceAll("^0+", "").split("");
        int aInt, bInt, localSum, ten = 0;

        long length = Math.max(aStrings.length, bStrings.length);

        for (int i = 1; i <= length; i++) {
            aInt = aStrings.length - i < 0 ? 0 : Integer.parseInt(aStrings[aStrings.length - i]);
            bInt = bStrings.length - i < 0 ? 0 : Integer.parseInt(bStrings[bStrings.length - i]);
            localSum = aInt + bInt + ten;
            if (localSum > 9) {
                ten = 1;
                result.append(localSum % 10);
            } else {
                ten = 0;
                result.append(localSum);
            }
        }
        if (ten == 1) result.append(1);
        return String.valueOf(result.reverse());
    }


    /*
        Write a function called sumIntervals/sum_intervals that accepts an array of intervals,
        and returns the sum of all the interval lengths.
        Overlapping intervals should only be counted once.
     */

    public static int sumIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int sum = 0;
        Arrays.sort(intervals, Comparator.comparing(value -> value[0]));
        Stack<Integer> stack = new Stack<>();
        stack.push(intervals[0][0]);
        stack.push(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (stack.peek() > intervals[i][0] && stack.peek() < intervals[i][1]) {
                stack.pop();
                stack.push(intervals[i][1]);
            } else if (stack.peek() <= intervals[i][0]) {
                stack.push(intervals[i][0]);
                stack.push(intervals[i][1]);
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pop() - stack.pop();
        }
        return sum;
    }





}
