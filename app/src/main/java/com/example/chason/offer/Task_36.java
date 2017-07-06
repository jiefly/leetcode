package com.example.chason.offer;

/**
 * Created by chgao on 17-7-5.
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */

public class Task_36 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,7}, 0, 1));
    }

    public static int solution(int[] in, int from, int to) {
        if (in == null || in.length == 0 || in.length <= to || in.length <= from || to < 0 || from < 0 || from > to) {
            throw new IllegalArgumentException("非法参数");
        }
        if (to - from < 1) {
            return 0;
        }
        int mid = (int) (from + Math.ceil((to - from) / 2.0f));
        int left = solution(in, from, mid - 1);
        int right = solution(in, mid, to);
        int current = 0;
        int[] support = new int[to - from + 1];
        int index = to - from;
        int i = mid - 1;
        int j = to;
        while (i >= from && j >= mid) {
            if (in[i] > in[j]) {
                current += (j - mid) + 1;
                support[index--] = in[i--];
            } else {
                support[index--] = in[j--];
            }
        }

        for (int x = i; x >= from; x--) {
            support[index--] = in[x];
        }

        for (int x = j; x >= mid; x--) {
            support[index--] = in[x];
        }

        for (int x = from; x <= to; x++) {
            in[x] = support[x - from];
        }
        return current + left + right;
    }
}
