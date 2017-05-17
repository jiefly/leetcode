package com.example.chason.letcode.medium;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by chgao on 17-5-16.
 * index:71
 * url:https://leetcode.com/problems/simplify-path/#/description
 */

public class SimplifyPath {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            System.out.println(new SimplifyPath().simplifyPath(s.next()));
        }
    }

    public String simplifyPath(String path) {
        Stack<String> result = new Stack<>();
        char[] chars = path.toCharArray();
        for (int i = 0, j = 0; i < chars.length; ) {
            while (++j < chars.length && chars[j] != '/' && chars[i] == '/') {
            }
            String s = new String(chars, i, j - i);

            //j == char.length || char[j]='/'

                switch (s) {
                    case "/..":
                        if (!result.isEmpty()) {
                            result.pop();
                        }
                        break;
                    case "/":
                    case "/.":
                        break;
                    default:
                        result.push(s);
                        break;
                }


            i = j;
        }
        if (result.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.insert(0, result.pop());
        }
        return sb.toString();
    }
}
