package com.example.chason.offer;

/**
 * Created by chgao on 17-7-3.
 */

public class Task_10 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            System.out.println("result_01->" + solution_01(i) + "->cost:" + (System.currentTimeMillis() - start));
            start = System.currentTimeMillis();
            System.out.println("result_02->" + solution_02(i) + "->cost:" + (System.currentTimeMillis() - start));
        }
        System.out.println(solution_03(0,8));
    }

    public static int solution_01(int in) {
        int N = 0;
        int result = 0;
        while (N < 32) {
            if ((1 << N & in) >= 1) {
                result++;
            }
            N++;
        }
        return result;
    }

    public static int solution_02(int in) {
        int result = 0;
        while ((in) != 0) {
            result++;
            in = in & (in - 1);
        }
        return result;
    }

    /*
    * 题目：输入两个数m和n，计算需要改变m多少位才能变为n;
    * step1:求两个数之间差异，亦或；
    * step2：求亦或得到的结果中的1的个数
    * */
    public static int solution_03(int from, int to) {
        return solution_02(from ^ to);
    }
}
