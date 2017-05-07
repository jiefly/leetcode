package com.example.chason.letcode.easy;

/**
 * Created by chason on 17-4-25.
 */

public class NumberOfSegmentsInString {
    public static void main(String[] args) {
        System.out.println(new NumberOfSegmentsInString().countSegments("Hello, my name is John")+"");
    }

    public int countSegments(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int from = 0;
        int to = chars.length - 1;
        for (char c:chars){
            if (c != ' '){
                break;
            }
            from++;
        }
        if (from > to){
            return 0;
        }
        for (int i = to;i>=from;i--){
            if (chars[i] != ' '){
                break;
            }
            to--;
        }
        int count = 0;
        for (int i = from;i<=to;i++){
            if (chars[i] == ' '){
                count++;
                while (i<to && chars[i+1] == ' '){
                    i++;
                }
            }
        }
        return count+1;

    }
}
