package com.example.chason.letcode.easy;

/**
 * Created by chason on 17-4-22.
 */

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */
public class NumberComplement {
    public static void main(String[] args) {
        new NumberComplement().findComplement(5);
    }

    public int findComplement(int num) {
        int N = 31;
        int flag = Integer.MAX_VALUE;
        while (N >= 0) {
            if ((num & (1 << N)) > 0) {
                break;
            }
            flag = flag & ~(1<< N);
            N--;

        }
        return ~num & flag;
    }
}
