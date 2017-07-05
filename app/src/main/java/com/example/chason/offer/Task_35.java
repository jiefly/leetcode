package com.example.chason.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chgao on 17-7-5.
 * 题目：在字符串中找出第一个只出现一次的字符。
 * example：输入“abaccdwff”，输出：b
 */

public class Task_35 {
    public static void main(String[] args) {
        System.out.println(solution("abaccdwff"));
    }

    public static char solution(String s) {
        if (s == null || s.length() == 0) {
            throw new NullPointerException("输入参数为空");
        }
        if (s.length() < 3) {
            return s.charAt(0);
        }
        Set<Character> repeat = new HashSet<>();
        Set<Character> sigle = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!sigle.add(c)) {
                repeat.add(c);
            }
        }
        for (char c : s.toCharArray()) {
            if (repeat.add(c)) {
                return c;
            }
        }
        return s.charAt(0);
    }


}
