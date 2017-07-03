package com.example.chason.offer;

/**
 * Created by chgao on 17-7-3.
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数
 */

public class Task_12 {
    public static void main(String[] args) {
        solution(3);
    }

    public static void solution(int in) {
        int[] res = new int[in];
        int index = 0;
        StringBuilder sb;
        while (true) {
            sb = new StringBuilder();
            for (int i = 0; i < in; i++) {
                if (sb.length() == 0 && res[i] == 0) {
                    continue;
                }
                sb.append(i);
            }
            if (sb.length() == 0) {
                sb.append(0);
            }
            res[index] = res[index] + 1;
            if (res[index] == 10) {
                res[index] = 0;
                index++;
            }
            System.out.println(sb.toString());
        }
    }
}
