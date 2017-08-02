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
        List<List<String>> u = new N_Queens().solveNQueens(4);
        List<int[]> results ;
        for (int i = 1; i < 16; i++) {
            long start = System.currentTimeMillis();
            results = solution(i);
            System.out.println("=========================================================");
            System.out.println("n="+i+"spend:"+(System.currentTimeMillis() - start) +"ms");
            System.out.println("size:"+results.size());
            for (int[] x :results) {
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

    public List<List<String>> solveNQueens(int n){
        if (n<1){
            return new ArrayList<>();
        }
        List<List<String>> outer = new ArrayList<>();
        char[] chars = new char[n];
        Arrays.fill(chars,'.');
        for (int[] x :solution(n)) {
            List<String> strings = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                chars[x[j]] = 'Q';
                strings.add(new String(chars));
                chars[x[j]] = '.';
            }
            outer.add(strings);

        }
        return outer;
    }


    public static List<int[]> solution(int n) {
        List<int[]> result = new ArrayList<>();
        int progress = 0;
        int[] queens = new int[n];
        boolean back = false;
        Arrays.fill(queens, -1);
        while (queens[0] < n) {
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
