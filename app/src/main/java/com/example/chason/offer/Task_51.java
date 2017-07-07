package com.example.chason.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chgao on 17-7-7.
 * 题目：在一个长度为n的数组中，所有的数字都在0到n-1范围内。数组中某些数字是重复的
 * 但是不知道有几个数字重复也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */

public class Task_51 {
    public static void main(String[] args) {
        System.out.println(solution_2(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    public static int solution_2(int[] in) {
        if (in == null || in.length < 2) {
            return -1;
        }
        int index = 0;
        for (int i=0;i<in.length;i++){
            while (in[i] !=i){
                if (in[in[i]] == in[i]){
                    return in[i];
                }
                int t = in[in[i]];
                in[in[i]] = in[i];
                in[i] = t;
            }
        }
        return -1;
    }

    public static int solution_1(int[] in) {
        if (in == null || in.length < 2) {
            return -1;
        }
        int n = in.length;
        int[] bucket = new int[n];
        for (int i : in) {
            if (bucket[i] != 0) {
                return i;
            } else {
                bucket[i]++;
            }
        }
        return -1;
    }

    public static int solution(int[] in) {
        if (in == null || in.length < 2) {
            return -1;
        }
        Set<Integer> coll = new HashSet<>();
        for (int i : in) {
            if (!coll.add(i)) {
                return i;
            }
        }
        return -1;
    }
}
