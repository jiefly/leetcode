package com.example.chason.letcode.easy;

/**
 * Created by chason on 17-4-22.
 */

public class ReverseInteger {
    public static void main(String[] args) {
        new ReverseInteger().reverse(1534236469);
    }

    public int reverse(int x) {
        boolean nagivate = (x & (1 << 31)) == 0;
        x = Math.abs(x);
        int result;
        int flag = 1;
        return nagivate ? x : -x;
    }
}
