package com.example.chason.offer;

/**
 * Created by chgao on 17-7-5.
 * 题目；我们把只包含因子2,3和5的数称作丑数。求按从小到大的顺序的第1500个丑数。
 * 习惯上我们把1当做第一个丑数。
 */

public class Task_34 {
    public static void main(String[] args) {
        solution_2(7);
        for (int i=1;i<1000;i++){
            long start = System.currentTimeMillis();
            System.out.println(solution(i)+"->time:"+(System.currentTimeMillis() - start));
            start = System.currentTimeMillis();
            System.out.println(solution_2(i)+"->time:"+(System.currentTimeMillis() - start));
            System.out.println("=============");
        }
    }

    public static int solution_2(int n) {
        if (n <1){
            throw new IllegalArgumentException("输入非法参数，n必须大于等于1");
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int current = 0;
        boolean update2;
        boolean update3;
        boolean update5;
        int M2, M3, M5, T2 = 0, T3 = 0, T5 = 0;
        while (n != current + 1) {
            update2 = false;
            update3 = false;
            update5 = false;
            M2 = ugly[T2] * 2;
            M3 = ugly[T3] * 3;
            M5 = ugly[T5] * 5;
            ugly[++current] = Math.min(M2, Math.min(M3, M5));
            for (int i = Math.min(T2,Math.min(T3,T5)); i < current + 1; i++) {
                if (update2 && update3 && update5) {
                    break;
                }
                if (!update2 && ugly[i] * 2 > ugly[current]) {
                    T2 = i;
                    update2 = true;
                }
                if (!update3 && ugly[i] * 3 > ugly[current]) {
                    T3 = i;
                    update3 = true;
                }
                if (!update5 && ugly[i] * 5 > ugly[current]) {
                    T5 = i;
                    update5 = true;
                }
            }
        }
        return ugly[n - 1];
    }

    public static int solution(int n) {
        for (int i = 1; ; i++) {
            if (isUglyNum(i)) {
                n--;
            }
            if (n == 0) {
                return i;
            }
        }
    }

    private static boolean isUglyNum(int n) {
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }

        while (n % 5 == 0) {
            n = n / 5;
        }
        return n == 1;
    }
}
