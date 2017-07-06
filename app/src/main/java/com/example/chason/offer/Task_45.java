package com.example.chason.offer;

import java.util.Random;

/**
 * Created by chgao on 17-7-6.
 * 题目：0,1 ....，n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除
 * 第m个数字。求这个圆圈里剩下的最后一个数字。
 */

public class Task_45 {
    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            int x = new Random().nextInt(10000);
            x = 4000;
            int y = new Random().nextInt(100);
            y = 997;
            long time1 = System.currentTimeMillis();
            System.out.println(solution_1(x, y));
            time1 = System.currentTimeMillis() - time1;
            long time2 = System.currentTimeMillis();
            System.out.println(solution(x, y));
            System.out.println("time:"+(System.currentTimeMillis() - time2 - time1));
        }
    }

    public static int solution(int n, int m) {
        if (n < 2) {
            return -1;
        }
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            col[i] = 1;
        }
        int len = n;
        int current = 0;
        while (len != 1) {
            int step = m;
            while (step != 0) {
                if (current >= n) {
                    current = current % n;
                }
                if (col[current] != 0) {
                    step--;
                    current++;
                } else {
                    current++;
                }
            }
            len--;
            if (current == 0) {
                col[n] = 0;
            } else {
                col[current - 1] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            if (col[i] != 0) {
                return i;
            }
        }
        return -1;
    }

    public static int solution_1(int n, int m) {
        if (n < 2) {
            return -1;
        }
        Support.ListNode current = new Support.ListNode(n - 1, null);
        Support.ListNode after = current;
        for (int i = n - 2; i >= 0; i--) {
            current = new Support.ListNode(i, current);
        }
        m = m - 1;
        after.mNext = current;
        int step;
        while (n != 1) {
            step = m % n;
            while (step != 0) {
                after = current;
                current = current.mNext;
                step--;
            }
            current = current.mNext;
            after.mNext = current;
            n--;
        }
        return current.mKey;

    }
}
