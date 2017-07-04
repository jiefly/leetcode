package com.example.chason.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chgao on 17-7-4.
 * 题目：输入一个矩阵，按照从外向里以逆时针的顺序一次打印出每个数字。
 */

public class Task_20 {
    public static void main(String[] args) throws Exception {
        int[][] in = new int[][]{{1}, {6}, {9}};
        solution(in);
    }

    public static List<Integer> solution(int[][] in) throws Exception {
        if (in == null || in.length == 0 || in[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> result;
        int row = in.length;
        int col = in[0].length;
        if (row == 1) {
            result = new ArrayList<>(col);
            for (int i : in[0]) {
                result.add(i);
            }
            return result;
        }
        if (col == 1) {
            result = new ArrayList<>(row);
            for (int[] i : in) {
                result.add(i[0]);
            }

            return result;
        }
        result = new ArrayList<>(row * 2 + (col - 2) * 2);
        result.add(in[0][0]);
        int x = 0;
        int y = 0;
        while (x != 0 || y != 1) {
            if (x == col - 1 && y == 0) {
                y++;
            } else if (x == col - 1 && y == row - 1) {
                x--;
            } else if (x == 0 && y == row - 1) {
                y--;
            } else if (y == 0) {
                x++;
            } else if (x == col - 1) {
                y++;
            } else if (y == row - 1) {
                x--;
            } else if (x == 0) {
                y--;
            } else {
                throw new Exception("未知错误");
            }
            result.add(in[y][x]);
        }
        int[][] next = new int[row - 2][col - 2];
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                next[i][j] = in[i + 1][j + 1];
            }
        }
        result.addAll(solution(next));
        return result;
    }
}
