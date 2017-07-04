package com.example.chason.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by chgao on 17-7-4.
 * 题目：输入一个字符串，打印该字符串中字符的所有排列。
 */

public class Task_28 {
    public static void main(String[] args) {
//        List<String> res = solution("abc");
//        for (String s : res) {
//            System.out.println(s);
//        }
        List<char[]> out = solution_02(new char[]{'a', 'b','c','d'});
//        System.out.println(out);
        for (char[] c : out) {
            System.out.println(new String(c));
        }
    }

    public static List<String> solution(String in) {
        if (in == null || in.length() == 0) {
            return new ArrayList<>();
        }
        if (in.length() == 1) {
            return Collections.singletonList(in);
        }
        char[] chars = in.toCharArray();
        List<String> sub = solution(in.substring(1));
        List<String> result = new ArrayList<>();
        for (String s : sub) {
            for (int i = 0; i < s.length() + 1; i++) {
                if (i == 0) {
                    result.add(chars[0] + s);
                } else if (i == s.length()) {
                    result.add(s + chars[0]);
                } else {
                    result.add(s.substring(0, i) + chars[0] + s.substring(i));
                }
            }
        }
        return result;
    }

    /*
    * 扩展：求字符的所有组合 （a,b,c->a,b,c,ab,ac,bc,abc）
    * */
    public static List<char[]> solution_02(char[] in) {
        if (in == null || in.length == 0) {
            return new ArrayList<>();
        }
        if (in.length == 1) {
            return Arrays.asList(in, new char[]{' '});
        }
        List<char[]> sub = solution_02(Arrays.copyOfRange(in, 1, in.length));
        List<char[]> result = new ArrayList<>((int) factorialRecursive(in.length));
        result.addAll(sub);
        for (char[] c : sub) {
            if (c.length == 1 && c[0] == ' ') {
                result.add(new char[]{in[0]});
                continue;
            }
            char[] chars = new char[c.length + 1];
            chars[0] = in[0];
            System.arraycopy(c, 0, chars, 1, c.length);
            result.add(chars);
        }

        return result;
    }

    public static long factorialRecursive(int n) {
        // 阶乘对整数才有意义
        if (n < 0) {
            return -1;
        }

        // 0！=1，（0 的阶乘是存在的）
        if (n == 0) {
            return 1;
        }

        if (n < 2)
            return n * 1;
        return n * factorialRecursive(n - 1);
    }

}
