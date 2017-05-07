package com.example.chason.letcode.easy;

/**
 * Created by chason on 17-4-24.
 */

public class AddStrings {
    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("0", "0"));
    }

    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        int zero = 48;
        int len1 = num1.length();
        int len2 = num2.length();
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int min = len1 < len2 ? len1 : len2;
        int max = len1 > len2 ? len1 : len2;
        char[] maxC = len1 > len2 ? chars1 : chars2;
        char[] minC = len1 > len2 ? chars2 : chars1;
        char[] result = new char[max + 1];
        int add = 0;
        int current;
        int delta = max - min;
        for (int i = max-1; i > -1; i--) {
            if (i >= delta) {
                current = add + maxC[i] + minC[i - delta] - 2 * zero;
            } else {
                current = add + maxC[i] - zero;
            }
            if (current > 9) {
                add = 1;
                result[i+1] = (char) (current % 10 + zero);
            } else {
                result[i+1] = (char) (current + zero);
                add = 0;
            }
        }
        if (add == 1) {
            result[0] = (char) (1 + zero);
            return new String(result);
        } else {
            return new String(result).substring(1);
        }
    }
}
