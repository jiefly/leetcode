package com.example.chason.offer;

/**
 * Created by chgao on 17-7-6.
 * 题目；求1+2+3...+n,要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 以及条件判断语句（A？B：C）
 */

public class Task_46 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }

    public static int solution(int n) {
        int last = 0;
        boolean b = n == 0 || ((last = solution(n - 1)) != -1);
        return last + n;
    }
}
