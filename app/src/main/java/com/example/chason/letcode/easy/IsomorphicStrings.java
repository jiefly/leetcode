package com.example.chason.letcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chason on 17-4-24.
 */

public class IsomorphicStrings {
    public static void main(String[] args){
        System.out.println( new IsomorphicStrings().isIsomorphic("add","egg"));
        System.out.println( new IsomorphicStrings().isIsomorphic("foo","bar"));
        System.out.println( new IsomorphicStrings().isIsomorphic("paper","title"));
        System.out.println( new IsomorphicStrings().isIsomorphic("aa","ab"));
    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        char[] from = s.toCharArray();
        char[] to = t.toCharArray();
        int[] alpha = new int[256];
        Set<Character> used = new HashSet<>();
        int N = from.length;
        for (int i=0;i<N;i++){
            if (alpha[from[i]] == 0){
                if (used.add(to[i])) {
                    alpha[from[i]] = to[i];
                }else {
                    return false;
                }
            }else if (alpha[from[i]] != to[i]){
                return false;
            }
        }
        return true;
    }
}
