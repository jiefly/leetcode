package com.example.chason.letcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chason on 17-4-24.
 */

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacter().firstUniqCharIII("leetcode"));
    }

    public int firstUniqChar(String s) {
        if (s == null || s.length() > 52) {
            return -1;
        }
        int N = s.length();
        char[] chars = s.toCharArray();
        Map<Character, Integer> exist = new HashMap<>();
        for (int i = 0; i < N; i++) {
            if (exist.containsKey(chars[i])) {
                chars[exist.get(chars[i])] = ' ';
                chars[i] = ' ';
            } else {
                exist.put(chars[i], i);
            }
        }
        for (int i = 0; i < N; i++) {
            if (chars[i] != ' ') {
                return i;
            }
        }
        return -1;
    }
    public int firstUniqCharIII(String s) {
        if (s==null || s.length()==0) return -1;
        int len = s.length();
        if (len==1) return 0;
        char[] cc = s.toCharArray();
        int slow =0, fast=1;
        int[] count = new int[256];
        count[cc[slow]]++;
        while (fast < len) {
            count[cc[fast]]++;
            // if slow pointer is not a unique character anymore, move to the next unique one
            while (slow < len && count[cc[slow]] > 1) slow++;
            if (slow >= len) return -1; // no unique character exist
            if (count[cc[slow]]==0) { // not yet visited by the fast pointer
                count[cc[slow]]++;
                fast=slow; // reset the fast pointer
            }
            fast++;
        }
        return slow;
    }
    public int firstUniqCharII(String s) {
        if (s == null) {
            return -1;
        }
        int N = s.length();
        char[] chars = s.toCharArray();
        int[] index = new int[26];
        Arrays.fill(index, -1);
        for (int i = 0; i < N; i++) {
            int j = chars[i] - 'a';
            if (index[j] == -2) {
                continue;
            } else if (index[j] == -1) {
                index[j] = i;
            } else {
                index[j] = -2;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (index[i] != -2 && index[i] != -1) {
                min = index[i]<min?index[i]:min;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
