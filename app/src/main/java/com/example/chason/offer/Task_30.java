package com.example.chason.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chgao on 17-7-4.
 * 题目：输入n个整数，找出其中最小的k个数。
 */

public class Task_30 {
    public static void main(String[] args) {
        try {
            List<Integer> show = solution_2(new int[]{4, 5, 6, 1, 3, 4}, 2);
            for (int i : show) {
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    * 最大堆思想
    * 建立一个容量为k的最大堆，不断的向堆中填入数字
    * */
    public static List<Integer> solution_2(int[] in, int k) {
        int[] stack = new int[k + 1];
        //建立二大二叉堆
        int index = 0;
        stack[1] = in[index];
        while (++index < k) {
            stack[index + 1] = in[index];
            swim(in, index + 1);
        }
        for (int i = index; i < in.length; i++) {
            if (in[i] >= stack[1]) {
                continue;
            } else {
                stack[1] = in[i];
                sink(stack, 1, k);
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = 1; i < k + 1; i++) {
            result.add(stack[i]);
        }
        return result;
    }

    /*
    * 上浮
    * */
    public static void swim(int[] coll, int k) {
        while (k > 1 && coll[k / 2] < coll[k]) {
            exchange(coll, k, k / 2);
            k = k / 2;
        }
    }

    /*
    * 下沉
    * */
    public static void sink(int[] coll, int k, int hi) {
        while (2 * k <= hi) {
            int j = 2 * k;
            if (j < hi && coll[j] < coll[j + 1]) {
                j++;
            }
            if (coll[k] > coll[j]) {
                break;
            }
            exchange(coll, k, j);
            k = j;
        }
    }

    /*
    * 切分思想
    * */
    public static List<Integer> solution(int[] in, int k) throws Exception {
        if (in == null || k < 1 || in.length < k) {
            throw new Exception("输入非法参数");
        }
        List<Integer> result = new ArrayList<>(k);
        if (in.length == k) {
            for (int i : in) {
                result.add(i);
            }
            return result;
        }
        int lo = 0;
        int hi = in.length - 1;
        while (result.size() < k) {
            int index = partition(in, lo, hi);
            if (index == lo + k - 1) {
                for (int i = lo; i < k; i++) {
                    result.add(in[i]);
                }
            } else if (index > lo + k - 1) {
                hi = index - 1;
            } else {
                for (int i = lo; i < index + 1; i++) {
                    result.add(in[i]);
                }
                lo = index + 1;
            }
        }
        return result;
    }


    public static int partition(int[] in, int lo, int hi) {
        if (in == null || hi < lo || in.length < hi) {
            throw new IllegalArgumentException("参数非法");
        }
        int i = lo;
        int j = hi + 1;
        int tmp = in[lo];
        while (true) {
            while (in[++i] < tmp) {
                if (i == hi) {
                    break;
                }
            }

            while (in[--j] > tmp) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exchange(in, i, j);
        }
        exchange(in, lo, j);
        return j;
    }

    private static void exchange(int[] in, int from, int to) {
        if (in == null || from < 0 || to < 0 || from > in.length || to > in.length) {
            return;
        }
        int tmp = in[from];
        in[from] = in[to];
        in[to] = tmp;
    }
}
