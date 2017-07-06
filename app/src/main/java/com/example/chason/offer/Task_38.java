package com.example.chason.offer;

/**
 * Created by chgao on 17-7-6.
 * 题目：统计一个数字在排序数组中出现的次数
 * example：输入排序数组{1,2,3,3,3,3,4,5}和数字3，输出4。
 */

public class Task_38 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 3, 4, 5}, 1));
    }

    /*
    * 利用二分法，找到等于n的数字，同时向两侧寻找其他连续的数字n。
    * */
    public static int solution(int[] in, int n) {
        int index = binarySearch(in, 0, in.length - 1, n);
        if (index == -1) {
            //不存在n
            return -1;
        }

        int left = index;
        int right = index;
        while (--left > 0 && in[left] == n) ;
        while (++right < in.length - 1 && in[right] == n) ;
        return right - left - 1;
    }

    public static int binarySearch(int[] in, int from, int to, int n) {
        if (in == null || in.length == 0 || to < from || from < 0 || to >= in.length) {
            throw new IllegalArgumentException("非法参数");
        }
        if (n > in[to] || n < in[from]) {
            return -1;
        }
        int mid = (to - from) / 2 + from;
        if (in[mid] == n) {
            return mid;
        } else if (in[mid] < n) {
            from = mid + 1;
            if (from > to) {
                return -1;
            }
        } else {
            to = mid - 1;
            if (to < from) {
                return -1;
            }
        }

        return binarySearch(in, from, to, n);
    }
}
