package com.example.chason.offer;

/**
 * Created by chgao on 17-7-6.
 * 题目一：输入一个英文句子，翻转句子中单词的顺序，但但是内字符顺序不变，为了简单起见，标点符号和普通字母一样处理。
 * example:"i am a student." 输出："student. a am i"
 */

public class Task_42 {
    public static void main(String[] args) {
        System.out.println(solution("中 华 人 民 共 和 国"));
    }

    public static String solution(String in) {
        if (in == null || in.length() == 0) {
            return in;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = in.toCharArray();
        int start = -1;
        int end = -1;
        for (int i = chars.length - 1; i > -1; i--) {
            if (chars[i] == ' ') {
                if (start == -1 && end == -1) {
                    sb.append(" ");
                } else if (start == -1) {
                    start = end;
                }
                if (start >= 0 && end < chars.length && end >= start) {
                    sb.append(in.substring(start, end + 1));
                    sb.append(" ");
                    start = -1;
                    end = -1;
                }
            } else {
                if (end == -1) {
                    end = i;
                } else {
                    start = i;
                }
            }
        }
        if (end != -1 && start == -1) {
            start = end;
        }

        if (end != -1 && end - start >= 0) {
            sb.append(in.substring(start, end + 1));
        }
        return sb.toString();

    }
}
