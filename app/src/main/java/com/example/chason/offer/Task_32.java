package com.example.chason.offer;

/**
 * Created by chgao on 17-7-5.
 * 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * example：输入12，从1到12中包含1的数字有1，10,11,12,1出现了5次。
 */

public class Task_32 {
    public static void main(String[] args) {

    }

    // TODO: 17-7-5 incomplete
    public static long solution(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        int digtel = 1;
        return 0L;
    }
}
