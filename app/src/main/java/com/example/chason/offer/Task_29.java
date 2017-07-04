package com.example.chason.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chgao on 17-7-4.
 * 题目：数组中有一个数字出现的次数超过数组长度的一 半，请找出这个数字。
 * example：输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一般，因此输出2
 */

public class Task_29 {
    public static void main(String[] args) {
        System.out.println(solution_1(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    public static int solution_1(int[] in) {
        if (in == null) {
            throw new IllegalArgumentException("输入参数非法");
        }
        if (in.length < 3) {
            return in[0];
        }
        int value = in[0];
        int times = 1;
        for (int i = 1; i < in.length; i++) {
            if (value == in[i]) {
                times++;
            } else {
                if (times == 0) {
                    value = in[i];
                } else {
                    times--;
                }
            }
        }
        return value;
    }

    public static int solution(int[] in) throws Exception {
        if (in == null) {
            throw new IllegalArgumentException("输入参数非法");
        }
        if (in.length < 3) {
            return in[0];
        }
        Map<Integer, Integer> coll = new HashMap<>();
        for (int i : in) {
            if (!coll.containsKey(i)) {
                coll.put(i, 1);
            } else {
                int val = coll.get(i);
                coll.put(i, val + 1);
                if (val + 1 > in.length / 2) {
                    return i;
                }
            }
        }
        throw new Exception("不存在出现次数大于数组长度一半的数字");
    }

}
