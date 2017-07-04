package com.example.chason.offer;

/**
 * Created by chgao on 17-7-4.
 * 题目：输入n个整数，找出其中最小的k个数。
 */

public class Task_30 {
    public static void main(String[] args) {
        // TODO: 17-7-4 incomplete
        try {
            int[] show = solution(new int[]{4,5,6},2,0,2);
            for (int i:show){
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int[] solution(int[] in, int k, int lo, int hi) throws Exception {
        if (in == null || k < 1 || in.length < k) {
            throw new Exception("输入非法参数");
        }
        if (in.length == k) {
            return in;
        }
        int tmp = in[lo];
        int start = lo;
        int end = hi + 1;
        while (true) {
            while (in[++start] < tmp) {
                if (start == hi) {
                    break;
                }
            }
            while (in[--end] > tmp) {
                if (end == lo) {
                    break;
                }
            }
            if (start >= end) {
                break;
            }

            int t = in[start];
            in[start] = in[end];
            in[end] = t;
        }
        in[lo] = in[end];
        in[end] = tmp;
        int[] result = new int[k];
        if (end == k - 1) {
            System.arraycopy(in, 0, result, 0, k);
            return result;
        } else if (end > k - 1) {
            return solution(in, k, 0, end - 1);
        } else {
            System.arraycopy(in, 0, result, 0, end + 1);
            System.arraycopy(solution(in, k - end - 1, end + 1, hi), 0, result, end + 1, k - end - 1);
            return result;
        }
    }
}
