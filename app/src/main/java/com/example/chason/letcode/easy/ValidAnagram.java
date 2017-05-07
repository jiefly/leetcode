package com.example.chason.letcode.easy;

/**
 * Created by chason on 17-4-25.
 * index:242
 * https://leetcode.com/problems/valid-anagram/#/description
 */

public class ValidAnagram {
    public static void main(String[] args){
        System.out.println(new ValidAnagram().isAnagram("anagram","nagaram"));
        System.out.println(new ValidAnagram().isAnagram("rat","car"));
    }
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()){
            return false;
        }
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        int[] alphaS = new int[26];
        for (char c:charS){
            alphaS[c-'a']++;
        }

        for (char c:charT){

            if (alphaS[c - 'a'] <= 0){
                return false;
            }
            alphaS[c - 'a']--;
        }

        return true;

    }
}
