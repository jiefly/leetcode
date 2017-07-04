package com.example.chason.offer;

import java.util.Stack;

/**
 * Created by chgao on 17-7-4.
 * 题目：输入两个整数序列，第一个序列表示栈压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 */

public class Task_22 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,3,4,5},new int[]{4,3,5,1,2}));
    }

    public static boolean solution(int[] push, int[] pop) {
        if (push == null || pop == null || push.length != pop.length) {
            return false;
        }
        Stack<Integer> mock = new Stack<>();
        int N = 0;
        int index = 0;
        while (N < pop.length) {
            while (mock.empty() || mock.peek() != pop[N]) {
                if (index > pop.length - 1) {
                    return false;
                }
                mock.push(push[index++]);
            }
            mock.pop();
            N++;
        }

        return true;
    }
}
