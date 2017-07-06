package com.example.chason.offer;

/**
 * Created by chgao on 17-7-6.
 * 题目：把n个骰子扔在地上，所有骰子朝上的一面点数之和为s。
 * 输入n打印出s的所有可能的值出现的概率。
 */

public class Task_43 {
    public static void main(String[] args) {
        float[] result = solution(2);
        for (int i = 0; i < result.length; i++) {
            System.out.println("value=" + (i + 1) + "<-->p=" + result[i]);
        }
    }

    public static float[] solution(int n) {
        if (n < 1) {
            return null;
        }
        if (n == 1) {
            return new float[]{1 / 6f, 1 / 6f, 1 / 6f, 1 / 6f, 1 / 6f, 1 / 6f};
        }
        float[] result = new float[6 * n];
        float[] last = solution(n - 1);
        assert last != null;
        for (int i = n - 1; i < 6 * n; i++) {
            int x = Math.max(i - 6, 0);
            for (int j = x; j < i && j < last.length; j++) {
                result[i] += 1 / 6f * last[j];
            }
        }
        return result;
    }
}
