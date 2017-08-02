package com.example.chason.offer;

public class Task_24 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 7, 6, 9, 11, 10, 8}, 0, 6));
        System.out.println(solution(new int[]{7, 4, 6, 5}, 0, 3));
    }

    public static boolean solution(int[] values, int from, int to) {
        if (from >= to) {
            return true;
        }
        int mid = values[to];
        int i = from;
        for (; i <= to; i++) {
            if (values[i] > mid) {
                break;
            }
        }
        int j = i;
        for (; j <= to; j++) {
            if (values[j] < mid) {
                return false;
            }
        }
        boolean left = true;
        if (i > from) {
            left = solution(values, from, i - 1);
        }
        boolean right = solution(values, i, to - 1);
        return left & right;
    }
}
