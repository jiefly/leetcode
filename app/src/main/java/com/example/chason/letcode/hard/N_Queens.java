package com.example.chason.letcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chgao on 17-7-26.
 * index:51
 * url:https://leetcode.com/problems/n-queens/#/description
 */

public class N_Queens {
    public static void main(String[] args) {
        List<int[]> result ;
        for (int i = 1; i < 9; i++) {
            long start = System.currentTimeMillis();
            result = solution(i);
            System.out.println("=========================================================");
            System.out.println("n="+i+"spend:"+(System.currentTimeMillis() - start) +"ms");
            System.out.println("size:"+result.size());
            for (int[] x :result) {
                for (int j = 0; j < i; j++) {
                    for (int p:x){
                        if (p == j){
                            System.out.print("-Q-");
                        }else {
                            System.out.print("-M-");
                        }
                    }
                    System.out.println("");
                }
                System.out.println("========================================================");
            }
        }
    }


    public static List<int[]> solution(int n) {
        List<int[]> result = new ArrayList<>();
        int progress = 0;
        int[] queens = new int[n];
        boolean back = false;
        Arrays.fill(queens, -1);
        while (queens[0] < n) {
            if (progress > n - 1) {
                System.out.println("");
            }
            while (queens[progress] >= n - 1) {
                if (progress == 0) {
                    return result;
                }
                progress--;
                back = true;
            }
            outer:
            for (int i = progress; i < n; i++) {
                for (int j = back ? queens[progress] + 1 : 0; j < n; j++) {
                    if (!conflict(queens, progress, j)) {
                        queens[i] = j;
                        progress++;
                        back = false;
                        break;
                    } else if (j == n - 1) {
                        progress--;
                        back = true;
                        break outer;
                    }
                }
            }
            if (progress == n) {
                int[] tm = new int[n];
                System.arraycopy(queens, 0, tm, 0, n);
                result.add(tm);
                progress--;
                back = true;
            }
        }
        return result;

    }

    private static boolean conflict(int[] queens, int index, int value) {
        for (int i = 0; i < index; i++) {
            if (queens[i] == value || Math.abs(i - index) == Math.abs(queens[i] - value)) {
                return true;
            }
        }
        return false;
    }
public static List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        List<List<String>> result = new ArrayList<>();
        int[] queens = new int[n];
        int index = 0;
        int value = 0;
        boolean back = false;
        while (!over(queens)) {
            if (back) {
                back = false;
                index--;
                value = queens[index] + 1;
            }
            outer:
            for (int j = index; j < n; j++) {
                for (int i = value; i < n; i++) {
                    if (!conflict(queens, index, i)) {
                        queens[index++] = i;
                        break outer;
                    } else if (i == n - 1) {
                        back = true;
                    }
                }
            }


        }
        return result;
    }
    private static boolean over(int[] queens) {
        int n = queens.length - 1;
        for (int i = n; i >= 0; i--) {
            if (queens[i] < n) {
                return false;
            }
        }
        return true;
    }

    private static boolean isConflit(List<Point> queen, Point newLocation) {
        for (Point i : queen) {
            if (newLocation.conflict(i)) {
                return true;
            }
        }
        return false;
    }

    public static class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean conflict(Point p) {
            return p.x == this.x || p.y == this.y;
        }
    }
}
