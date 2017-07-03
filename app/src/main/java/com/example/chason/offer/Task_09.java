package com.example.chason.offer;

/**
 * Created by chgao on 17-7-3.
 * 题目：写一个函数，输入n，求斐波那契数列的第n项。
 */

public class Task_09 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            System.out.println("result_01->" + solution_01(i) + "->cost:" + (System.currentTimeMillis() - start));
            start = System.currentTimeMillis();
            System.out.println("result_02->" + solution_02(i) + "->cost:" + (System.currentTimeMillis() - start));
        }
    }

    /*
    * 题目：写一个函数，输入n，求斐波那契数列的第n项。
    * */
    public static int solution_01(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return solution_01(n - 1) + solution_01(n - 2);
    }

    /*
    * 题目：写一个函数，输入n，求斐波那契数列的第n项。
    * */
    public static int solution_02(int n) {
        int N = 2;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int b = 1;
        int bb = 0;
        int current = b + bb;
        while (N < n) {
            N++;
            bb = b;
            b = current;
            current = b + bb;
        }
        return current;
    }

    /*
    * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级台阶公共有多少种跳法。
    * f(n) = f(n-1)+f(n-2)
    * f(1) = 1
    * f(2) = 2
    * */
    public static int solution_03(int n) {
        int N = 2;
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 2;
        }
        int b = 2;
        int bb = 1;
        int current = b + bb;
        while (N < n) {
            N++;
            bb = b;
            b = current;
            current = b + bb;
        }
        return current;
    }

    /*
    * 题目：在青蛙跳台阶问题中，如果把条件改成：一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。。。也可以跳上n级台阶，
    * 此时青蛙跳上一个n级台阶总共有多少种跳法。
    * f(n) = 1+f(1)+...+f(n-1) = 2f(n-1) = 2
    * */
    public static int solution_04(int n) {
        return (int) Math.pow(2, n - 1);
    }
}
