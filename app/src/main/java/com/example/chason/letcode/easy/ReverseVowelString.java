package com.example.chason.letcode.easy;

/**
 * Created by chason on 17-4-25.
 */

public class ReverseVowelString {
    public static void main(String[] args) {
        System.out.println(new ReverseVowelString().reverseVowels("OE"));
        System.out.println(new ReverseVowelString().reverseVowels("leetcode"));
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int prev = 0;
        int next = chars.length - 1;
        while (next > prev) {
            while (!vowels.contains(chars[prev]+"")) {
                prev++;
                if (prev >= next) {
                    return new String(chars);
                }
            }
            while (!vowels.contains(chars[next]+"")) {
                next--;
                if (prev >= next) {
                    return new String(chars);
                }
            }
            exchange(chars, next--, prev++);

        }

        return new String(chars);
    }

    private void exchange(char[] in, int from, int to) {
        char tmp = in[from];
        in[from] = in[to];
        in[to] = tmp;
    }
}
