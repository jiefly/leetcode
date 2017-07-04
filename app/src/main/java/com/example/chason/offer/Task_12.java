package com.example.chason.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chgao on 17-7-3.
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数
 */

public class Task_12 {
    public static void main(String[] args) {
//        solution(9);
        for (String s : solution_2(6)){
            System.out.println(s);
        }
    }

    public static void solution(int in) {
        if (in < 1) {
            return;
        }
        int[] res = new int[in + 1];
        int index = 0;
        res[0] = 1;
        StringBuilder sb;
        while (true) {
            sb = new StringBuilder();


            for (int i = in - 1; i > -1; i--) {
                if (res[index] == 10) {
                    res[index++] = 0;
                    res[index] += 1;
                } else {
                    break;
                }
            }
            if (res[in] == 1) {
                break;
            }
            for (int i = in - 1; i > -1; i--) {
                if (sb.length() == 0 && res[i] == 0) {
                    continue;
                }
                sb.append(res[i]);
            }
            index = 0;
            res[index] = res[index] + 1;
            System.out.println(sb.toString());
        }
    }

    public static List<String> solution_2(int n) {
        if (n < 1) {
            return null;
        } else if (n == 1) {
            List<String> result = new ArrayList<>(10);
            result.add("0");
            result.add("1");
            result.add("2");
            result.add("3");
            result.add("4");
            result.add("5");
            result.add("6");
            result.add("7");
            result.add("8");
            result.add("9");
            return result;
        }
        List<String> result = new ArrayList<>((int) Math.pow(10, n));
        List<String> lastResult = solution_2(n - 1);
        assert lastResult != null;
        for (int i = 0; i < 10; i++) {
            for (String s : lastResult) {
                result.add(i + s);
            }
        }
        return result;
    }
}
