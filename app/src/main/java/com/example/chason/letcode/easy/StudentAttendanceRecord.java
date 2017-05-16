package com.example.chason.letcode.easy;

import java.util.Scanner;

/**
 * Created by chgao on 17-5-16.
 * index:551
 * url:https://leetcode.com/problems/student-attendance-record-i/#/description
 */

public class StudentAttendanceRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            System.out.println(new StudentAttendanceRecord().checkRecord(scanner.next()));
        }
    }

    /**
     * Given a positive integer n, return the number of all possible
     * attendance records with length n, which will be regarded as rewardable.
     * The answer may be very large, return it after mod 109 + 7.
     * @param n
     * @return
     */
    public int checkRecord(int n) {
        //// TODO: 17-5-16 do it later
        return -1;
    }
    public boolean checkRecord(String s) {
        int L = 0;
        int A = 0;
        boolean lastL = false;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                if (!lastL) {
                    L = 1;
                }else {
                    L+=1;
                }
                lastL = true;
            } else if (c == 'A') {
                lastL = false;
                A += 1;
            }else{
                lastL = false;
            }
            if (L > 2 || A > 1) {
                return false;
            }
        }
        return true;
    }
}
