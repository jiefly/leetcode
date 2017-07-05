package com.example.chason.offer;

/**
 * Created by chgao on 17-7-5.
 * 题目：输入一个整型数组，数组中有正数也有负数。数组中一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。要求时间复杂度为O（n）。
 */

public class Task_31 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,4,5}));
    }

    public static int solution(int[] in) {
        if (in == null || in.length == 0) {
            throw new IllegalArgumentException("非法参数");
        }
        int max = in[0];
        if (in.length == 1) {
            return max;
        }
        int lastSum = max;
        for (int i = 1; i < in.length; i++) {
            if (in[i] < 0 && lastSum < 0) {
                lastSum = in[i];
                max = Math.max(max, Math.max(lastSum, in[i]));
            } else if (lastSum < 0) {
                lastSum = in[i];
                max = Math.max(in[i], max);
            } else {
                lastSum += in[i];
                max = Math.max(lastSum, max);
            }
        }
        return max;
    }
}
