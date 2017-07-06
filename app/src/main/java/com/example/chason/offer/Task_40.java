package com.example.chason.offer;

/**
 * Created by chgao on 17-7-6.
 * 题目：一个整型数组里出了两个数字之外，其他数字都出现了两次。
 * 请写出程序找出这两个只出现一次的数字。要求时间复杂度为Ｏ（n），空间复杂度为Ｏ（１）
 */

public class Task_40 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{2,4,3,6,3,2,5,5});
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] solution(int[] in) {
        if (in == null || in.length < 3) {
            return in;
        }
        int ox = in[0];
        for (int i = 1; i < in.length; i++) {
            ox ^= in[i];
        }
        int dig = 0;
        while ((ox & 1) == 0) {
            ox = ox >> 1;
            dig++;
        }
        int oxTmp = 1 << dig;
        int[] result = new int[2];
        for (int i : in) {
            if ((i & oxTmp) == 0) {
                result[0] = result[0] ^ i;
            } else {
                result[1] = result[1] ^ i;
            }
        }
        return result;
    }
}
