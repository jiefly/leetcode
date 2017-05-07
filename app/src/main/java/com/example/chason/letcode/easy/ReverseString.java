package com.example.chason.letcode.easy;

/**
 * Created by chason on 17-4-22.
 */

public class ReverseString {
    public static void main(String[] args) {
        new ReverseString().reverseStringII("hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl", 39);
        System.out.println(new ReverseString().reverseStringIII("Let's take LeetCode contest"));
    }

    public String reverseString(String s) {

        char[] res = s.toCharArray();
        int N = res.length;
        char[] dst = new char[N];
        for (int i = N - 1; i >= 0; i--) {
            dst[N - 1 - i] = res[i];
        }
        return new String(dst);
    }

    public String reverseStringII(String s, int k) {
        char[] res = s.toCharArray();
        int N = res.length;
        boolean isLastOne = false;
        int newK = 0;
        char[] dst = new char[N];
        for (int i = 0; i < N; ) {
            if (N - i < k) {
                newK = N - i;
                isLastOne = true;
            }
            for (int j = 0; j < 2 * k && i + j < N; j++) {
                int flag = (i + j + 1) % (2 * k);
                if (flag <= (isLastOne ? newK : k) && flag > 0) {
                    if (isLastOne) {
                        dst[i + j] = res[i + newK - flag];
                    } else {
                        dst[i + j] = res[i + k - flag];
                    }
                } else {
                    dst[i + j] = res[i + j];
                }
            }
            i += 2 * k;

        }
        return new String(dst);
    }

    public String reverseStringIII(String s) {
        char[] src = s.toCharArray();
        int N = src.length;
        char[] dst = new char[N];
        int fromIndex = -1;
        int toIndex = -1;
        for (int i = 0; i < N; i++) {
            if (fromIndex == -1) {
                fromIndex = i;
            }
            if (src[i] == ' ' || i == N - 1) {
                if (i == N-1){
                    toIndex = i;
                }else {
                dst[i] = src[i];
                    toIndex = i - 1;
                }
                reserseCharArray(src, dst, fromIndex, toIndex);
                fromIndex = -1;
            }

        }
        return new String(dst);
    }

    private void reserseCharArray(char[] src, char[] dst, int from, int to) {
        int N = to - from;
        for (int i = 0; i < N + 1; i++) {
            dst[from + i] = src[from + N - i];
        }
    }

}
