package com.example.chason.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chgao on 17-7-6.
 * 题目：输入一个递增排序的数组和一个数字ｓ，在数组中查找两个数，使得他们之和正好是ｓ。
 * 如果有多对数字的和是ｓ，输入任意一对即可。
 */

public class Task_41 {
    public static void main(String[] args) {
        int[] result = solution_1(new int[]{1, 2}, 3);
        System.out.println(result[0]);
        System.out.println(result[1]);
        for (String s : solution_2(1000)) {
            System.out.println(s);
        }
    }

    public static int[] solution_1(int[] in, int sum) {
        if (in == null || in.length < 2) {
            throw new IllegalArgumentException("输入非法参数");
        }

        int left = 0;
        int right = in.length - 1;
        while (left < right) {
            int task = in[left] + in[right];
            if (task == sum) {
                return new int[]{in[left], in[right]};
            } else if (task < sum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    /*
    * 题目二：输入一个正数ｓ，打印出所有和为ｓ的连续正数序列（至少含有两个数）。
    * */
    public static List<String> solution_2(int n) {
        if (n < 3) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        int start = 1;
        int end = 2;
        int sum = 3;
        while (end <= n / 2 + 1) {
            if (sum == n) {
                result.add(start + "~" + end);
                sum -= start;
                start++;
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                end++;
                sum += end;
            }
        }
        return result;
    }

    public static int[] solution(int[] in, int sum) {
        if (in == null || in.length < 3) {
            return in;
        }
        int start = 0;
        while (start < in.length - 1 && in[start] <= sum / 2) {
            int task = sum - in[start];
            int index = binarySearch(in, start + 1, in.length - 1, task);
            if (index != -1) {
                return new int[]{in[start], in[index]};
            }
            start++;
        }
        return new int[]{-1, -1};

    }

    private static int binarySearch(int[] in, int from, int to, int n) {
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
