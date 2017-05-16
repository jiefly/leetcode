package com.example.chason.letcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by chgao on 17-5-16.
 * index:71
 * url:https://leetcode.com/problems/simplify-path/#/description
 */

public class SimplifyPath {
    public static void main(String[] args) {

    }

    public String simplifyPath(String path) {
        Stack<String> result = new Stack<>();
        List<String> segments = new ArrayList<>();
        char[] chars = path.toCharArray();
        for (int i = 0, j = 0; i < chars.length; i++) {
            while (j < chars.length && chars[j] != '/') {
                j++;
            }
            String s = new String(chars, i, j - i);
            //j == char.length || char[j]='/'


            i = j;
        }
        return "";
    }
}
