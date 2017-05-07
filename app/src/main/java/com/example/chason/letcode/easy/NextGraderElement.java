package com.example.chason.letcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by chason on 17-4-23.
 */

public class NextGraderElement {
    public static void main(String[] args) {
        new NextGraderElement().nextGraderElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        new NextGraderElement().nextGraderElementIIAdvance(new int[]{1, 2, 3});
        System.out.println(new NextGraderElement().nextGraderElementIII(2147483647));
    }

    public int[] nextGraderElement(int[] findNums, int[] nums) {
        int M = findNums.length;
        int[] result = new int[M];
        Arrays.fill(result, -1);
        Map<Integer, Integer> collection = new HashMap<>();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            collection.put(nums[i], i);
        }
        for (int i = 0; i < M; i++) {
            int x = collection.get(findNums[i]);
            for (int j = x + 1; j < N; j++) {
                if (nums[j] > findNums[i]) {
                    result[i] = nums[j];
                    break;
                }
            }
        }
        return result;
    }

    public int[] nextGraderElementII(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];
        Arrays.fill(result, -1);
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < i + N; j++) {
                if (nums[j % N] > nums[i]) {
                    result[i] = nums[j % N];
                    break;
                }
            }
        }
        return result;
    }

    public int[] nextGraderElementIIAdvance(int[] nums) {
        int N = nums.length;
        int[] result = new int[N];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * N; i++) {
            if (stack.isEmpty() & i > N) {
                break;
            }
            int tmp = nums[i % N];
            while (!stack.isEmpty() && nums[stack.peek()] < tmp) {
                result[stack.pop()] = tmp;
            }
            if (i < N) {
                stack.push(i);
            }
        }
        return result;
    }
    public int nextGraderElementIII(int n){
        if (n < 12){
            return -1;
        }
        int tmp = n;
        int i=0;
        int[] digit = new int[10];
        while (tmp != 0) {
            digit[i++] = tmp % 10;
            tmp = tmp / 10;
        }
        int[] in;
        if (n <100){
            in = new int[i];
            System.arraycopy(digit,0,in,0,i);
            return nextGrader(n,in);
        }
        int div;
        for (int j = 1;j<i;j++){
            if (j == 9){
                return nextGrader(n,digit);
            }
            in = new int[j+1];
            System.arraycopy(digit,0,in,0,j+1);
            div = (int) Math.pow(10,j+1);
            int x = nextGrader(n %div,in);
            if (x != -1){
                int result = n - (n % div) + x;
                return result < 0 ? -1:result;
            }
        }
        return -1;
    }
    public int nextGrader(int n,int[] digit) {
        int result = 0;
        int[] sort = new int[10];
        for (int j : digit){
            sort[j]++;
        }
        int len = digit.length - 1;

        for (int j = len; j > -1; j--) {
            int x = digit[j] + 1;
            while (x < 10) {
                if (sort[x] > 0) {
                    result += x * Math.pow(10, j);
                    sort[x]--;
                    result += getMinNum(sort);
                    return result < 0 ? -1:result;
                }
                x++;
            }
            sort[digit[j]]--;
            result += digit[j] * Math.pow(10, j);
        }
        return result == n || result < 0 ? -1 : result;
    }

    public int getMinNum(int[] in) {
        if (in == null || in.length == 0) {
            return 0;
        }
        int result = 0;
        int num = 0;
        for (int i : in) {
            num += i;
        }
        for (int i = 0; i < in.length; i++) {
            while (in[i] != 0) {
                result += i * Math.pow(10, --num);
                in[i]--;
            }
        }

        return result;
    }
}
