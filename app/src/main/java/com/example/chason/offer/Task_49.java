package com.example.chason.offer;

/**
 * Created by chgao on 17-7-7.
 * 题目：把字符串转换为整数。
 */

public class Task_49 {
    public static void main(String[] args) throws Exception {
        System.out.println(soulution("-"));
    }

    public static int soulution(String num) throws Exception {
        if (num == null || num.length() == 0) {
            throw new IllegalArgumentException("输入参数不合法");
        }

        if (num.length() == 1) {
            if (!isNum(num.charAt(0))) {
                throw new IllegalArgumentException("输入参数不合法");
            } else {
                return num.charAt(0) - '0';
            }
        }
        //负数
        boolean positive = false;
        int start = 0;
        if (num.charAt(0) == '-') {
            positive = true;
            start++;
        } else if (num.charAt(0) == '+') {
            start++;
        }
        long result = 0;
        int dig = positive?-1:1;
        char[] chars = num.substring(start).toCharArray();
        for (int i = chars.length - 1; i > -1; i--) {
            if (isNum(chars[i])) {
                result += (chars[i]- '0') * dig;
                if ((!positive && result >Integer.MAX_VALUE)|| (positive && result < Integer.MIN_VALUE)){
                    throw new Exception("字符串超出int范围");
                }
            } else {
                throw new IllegalArgumentException("输入字符转中包含不是数字的字符。");
            }
            dig *= 10;
        }

        return (int) result;

    }

    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }
}
