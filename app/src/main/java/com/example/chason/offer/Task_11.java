package com.example.chason.offer;

/**
 * Created by chgao on 17-7-3.
 * 题目：实现函数double Power(double base,int exponent),求base的exponent次方。不得使用函数库
 * 不需要考虑大数问题。
 */

public class Task_11 {
    public static void main(String[] args) {
        try {
            System.out.println(solution(-0.5, 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static double solution(double base, int exponent) throws Exception {
        if (exponent == 0) {
            if (base == 0) {
                throw new IllegalArgumentException("错误输入，不能计算0的0次方。");
            }
            return 1;
        }
        //处理base
        boolean negative = false;
        boolean reserve = false;
        if (exponent < 0) {
            exponent = -exponent;
            base = 1 / base;
        }
        if (base < 0) {
            negative = true;
            base = -base;
        }
        if (Math.abs(base) < 1) {
            reserve = true;
            base = 1 / base;
        }
        double result = 1;
        double current = base;
        for (int i = 0; i < 32; i++) {
            if (i != 0) {
                current *= current;
            }
            if ((exponent & (1 << i)) != 0) {
                result *= current;
            }
        }

        if (negative && exponent % 2 != 0) {
            result = -result;
        }
        if (reserve) {
            result = 1 / result;
        }
        return result;
    }
}
