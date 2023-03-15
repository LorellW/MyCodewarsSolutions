package com.github.lorellw.codewars.math;

import java.math.BigInteger;
import java.util.ArrayList;

public class Factorial {
    public static String calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return "1";
        }
        String result = String.valueOf(n);
        for (int i = 1; i < n; i++) {
            result = multiplication(result,String.valueOf(i));
        }
        return result;
    }

    public static String multiplication(String a, String b) {
        if (a.equals("0") || b.equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder("");
        int dec = 0, temp = 0;

        String[] aArr = a.replaceAll("^0+", "").split("");
        String[] bArr = b.replaceAll("^0+", "").split("");
        ArrayList<String> list = new ArrayList<>();
        for (int i = bArr.length - 1; i >= 0; i--) {
            for (int j = aArr.length - 1; j >= 0; j--) {
                temp = (Integer.parseInt(aArr[j]) * Integer.parseInt(bArr[i]) + dec) % 10;
                dec = (Integer.parseInt(aArr[j]) * Integer.parseInt(bArr[i]) + dec) / 10;
                result.append(temp);
            }
            if (dec != 0) {
                result.append(dec);
                dec = 0;
            }
            list.add(String.valueOf(result.reverse()));
            result.setLength(0);
        }
        return addWithShift(list);
    }

    private static String addWithShift(ArrayList<String> list) {
        StringBuilder result = new StringBuilder(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            StringBuilder temp = new StringBuilder(list.get(i)).append("0".repeat(i));
            result = bigAdd(result, temp);
        }
        return String.valueOf(result);
    }

    public static StringBuilder bigAdd(StringBuilder a, StringBuilder b) {
        StringBuilder result = new StringBuilder("");
        String[] aStrings = String.valueOf(a).split("");
        String[] bStrings = String.valueOf(b).split("");
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
        return result.reverse();
    }

    public static String bigIntFactorial(int n){
        if(n < 0) return null;
        BigInteger a = new BigInteger("1");
        for(int i = 1; i < n + 1; i++) a = a.multiply(new BigInteger("" + i));
        return a.toString();
    }
}
