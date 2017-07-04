package com.example.chason.offer;

/**
 * Created by chgao on 17-7-4.
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，是的所有奇数的位于数组的前半部分
 * 所有的偶数位于后半部分。
 */

public class Task_14 {
    public static void main(String[] args) {
        int[] in = new int[]{8,8,8,8,8};
        solution(in);
        for (int i:in){
            System.out.print(i+"_");
        }
    }

    public static void solution(int[] in) {
        if (in == null || in.length < 2) {
            return;
        }
        int len = in.length;
        int start = 0;
        int end = len - 1;
        while (start < end) {
            while (start < len&&(in[start] % 2 == 1)) {
                start++;
            }
            while (end > -1&&(in[end] % 2 == 0)) {
                end--;
            }
            if (start <= end) {
                int tmp = in[start];
                in[start] = in[end];
                in[end] = tmp;
                start++;
                end--;
            }
        }
    }
}
