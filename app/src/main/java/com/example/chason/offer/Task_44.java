package com.example.chason.offer;

/**
 * Created by chgao on 17-7-6.
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2~10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看做任意数字。(大小王定义为0)
 */

public class Task_44 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 5, 6, 1, 0}));
    }

    public static boolean solution(int[] cards) {
        if (cards == null || cards.length != 5) {
            return false;
        }
        int[] col = new int[14];
        for (int card : cards) {
            col[card]++;
        }
        boolean start = false;
        int ok = 0;
        for (int i = 1; i < 14 && ok != 5; i++) {
            if (col[i] == 0) {
                if (!start) {
                    continue;
                } else {
                    if (col[0] < 1) {
                        return false;
                    } else {
                        ok++;
                        col[0]--;
                    }
                }
            } else if (col[i] == 1) {
                if (!start) {
                    start = true;
                }
                ok++;

            } else {
                return false;
            }
        }
        return true;
    }
}
