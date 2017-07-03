package com.example.chason.offer;

/**
 * Created by chgao on 17-7-3.
 * 题目：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序数组的一个旋转
 * 输出这个数组的最小元素。
 */

public class Task_08 {
    public static void main(String[] args) {
        System.out.println(solution_2(new int[]{1,1,1,0,1}));
    }

    public static int solution(int[] in) {
        int start = 0;
        int end = in.length - 1;
        while (end > start) {
            if (in[start] > in[start + 1]) {
                return in[start + 1];
            }
            start++;
            if (in[end] < in[end - 1]) {
                return in[end];
            }
            end--;
        }
        return in[0];
    }

    public static int solution_2(int[] in) {
        int start = 0;
        int end = in.length - 1;
        int mid = (int) Math.ceil(start + (end - start) / 2);
        while (end > start) {

            if (in[mid] > in[end]) {
                if (mid == start) {
                    return in[end];
                }
                start = mid;
            } else if (in[mid] < in[start]) {
                end = mid;
            } else if (in[mid] == in[start] && in[mid] == in[end]) {
                return solution(in);
            } else {
                return in[mid];
            }
            mid = (int) Math.ceil(start + (end - start) / 2);
        }
        return in[mid];
    }
}
