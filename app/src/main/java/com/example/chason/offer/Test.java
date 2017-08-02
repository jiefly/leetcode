package com.example.chason.offer;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by chgao on 17-7-8.
 */

public class Test {
    public static void main(String[] args) {
        /*Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        //true
        //-128 ~ 127 在常量池中 ，所以地址相同
        System.out.println(c == d);
        //false
        // <-128 || > 127 在堆中
        System.out.println(e == f);
        //true
        System.out.println(c == (a + b));
        //true
        // c 和 a+b 的类型相同并且 值相同
        System.out.println(c.equals(a + b));
        //true
        System.out.println(g == (a + b));
        //false
        //g为Long a+b 为 int，类型不相同，返回false
        System.out.println(g.equals(a + b));*/
        Support.BinaryTreeNode head = new Support.BinaryTreeNode(4, new Support.BinaryTreeNode(5,
                new Support.BinaryTreeNode(1, null, null),
                new Support.BinaryTreeNode(2, null, null)), new Support.BinaryTreeNode(3, null, new Support.BinaryTreeNode(6, new Support.BinaryTreeNode(9, null, null), new Support.BinaryTreeNode(7, null, null))));
        new Test().prePrint(head);
        System.out.println("");
        new Test().midPrint(head);
        System.out.println("\nstack");
        new Test().prePrintStack(head);
        System.out.println("");
        new Test().endPrint(head);
        System.out.println("");
        System.out.println(new Test().getDis(new int[]{10, 5}, 2));
        System.out.println(cutRod(7, new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30}));
        System.out.println(maxApple(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {11, 12, 13, 14}, {15, 16, 17, 18}}, 3, 3));
        System.out.println(maxApple(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {11, 12, 13, 14}, {15, 16, 17, 18}}, 3, 3, 1));
//        System.out.println(new Test().backPack(90, new int[]{12, 3, 7, 4, 5, 13, 2, 8, 4, 7, 6, 5, 7}, new boolean[13]));
//        System.out.println(new Test().kthLargestElement(2,new int[]{9,3,2,8,4},0,4));
//        int val[] = {10, 40, 30, 50};
//        int wt[] = {5, 4, 6, 3};
//        int W = 10;
//
//        System.out.println(knapsack(val, wt, W));
        new Test().medianSlidingWindow(new int[]{1,2,7,8,5},3);
    }

    public void prePrint(Support.BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.mValue + ">>>");
        prePrint(head.mLeft);
        prePrint(head.mRight);
    }

    public void midPrint(Support.BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        midPrint(head.mLeft);
        System.out.print(head.mValue + ">>>");
        midPrint(head.mRight);
    }

    public void endPrint(Support.BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        endPrint(head.mLeft);
        endPrint(head.mRight);
        System.out.print(head.mValue + ">>>");
    }

    public void prePrintStack(Support.BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        Stack<Support.BinaryTreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.empty()) {
            Support.BinaryTreeNode node = stack.pop();
            System.out.print(node.mValue + "--");

            if (node.mRight != null) {
                stack.push(node.mRight);
            }
            if (node.mLeft != null) {
                stack.push(node.mLeft);
            }
        }
    }

    public void midPrintStack(Support.BinaryTreeNode head) {
        if (head == null) {
            return;
        }
        Stack<Support.BinaryTreeNode> stack = new Stack<>();
        if (head.mRight != null) {
            stack.push(head.mRight);
        }
        stack.push(head);
        if (head.mLeft != null) {
            stack.push(head.mLeft);
        }
        while (!stack.empty()) {
            Support.BinaryTreeNode node = stack.pop();
            System.out.print(node.mValue + "--");

            if (node.mRight != null) {
                stack.push(node.mRight);
            }
            if (node.mLeft != null) {
                stack.push(node.mLeft);
            }
        }
    }

    public char findFirstRepeat(String A, int n) {
        // write code here
        char[] chars = A.toCharArray();
        if (chars.length != n) {
            return ' ';
        }
        boolean[] collection = new boolean[256];
        for (char c : chars) {
            if (!collection[c]) {
                collection[c] = true;
            } else {
                return c;
            }
        }
        return ' ';
    }

    public String[] findCoder(String[] A, int n) {
        // write code here
        if (A.length != n) {
            return null;
        }
        final HashMap<String, Integer> counts = new HashMap<>();
        int N = 0;
        for (int i = 0; i < n; i++) {
            int x = containsKey(A[i], "coder");
            N = x > 0 ? N + 1 : N;
            counts.put(A[i], x);
        }

        //sort
        for (int i = 0; i < n; i++) {

            for (int j = i; j > 0; j--) {
                if (counts.get(A[j]) <= counts.get(A[j - 1])) {
                    exchange(A, j, j - 1);
                } else {
                    break;
                }
            }
        }

        String[] s = new String[N];
        for (int i = 0; i < N; i++) {
            s[i] = A[n - i - 1];
        }
        return s;
    }

    public void exchange(String[] o, int from, int to) {
        String tm = o[from];
        o[from] = o[to];
        o[to] = tm;
    }

    public int containsKey(String s, String key) {
        if (s == null || s.length() < key.length()) {
            return 0;
        }
        int count = 0;
        char[] col = s.toUpperCase().toCharArray();
        char[] target = key.toUpperCase().toCharArray();
        boolean back = false;
        for (int i = 0; i < col.length; i++) {
            int start = 0;
            while (target[start] == col[i]) {
                back = true;
                if (start == target.length - 1) {
                    count++;
                    break;
                }
                if (++i >= col.length) {
                    return count;
                }

                start++;
            }
            if (back) {
                i--;
                back = false;
            }
        }
        return count;
    }

    public int getDis(int[] A, int n) {
        // write code here
        if (n <= 1) {
            return 0;
        }
        JStack stack = new JStack();
        stack.push(A[0]);
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (A[i] - stack.min() > max) {
                max = A[i] - stack.min();
            }
            stack.push(A[i]);
        }
        return max;
    }

    public static class JStack {
        private Stack<Integer> data;
        private Stack<Integer> min;

        public JStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int t) {
            data.push(t);
            if (min.isEmpty()) {
                min.push(t);
            } else {
                if (min.peek() > t) {
                    min.push(t);
                } else {
                    min.push(min.peek());
                }
            }
        }

        public int pop() {
            min.pop();
            return data.pop();
        }

        public int min() {
            return min.peek();
        }
    }

    public static Map<Integer, Integer> solutions = new HashMap<>();

    public static int cutRod(int n, int[] price) {
        if (n == 0)
            return 0;
        if (solutions.containsKey(n)) {
            return solutions.get(n);
        }
        int result = -1;
        for (int i = 1; i <= n; i++) {
            int max = price[i - 1] + cutRod(n - i, price);
            result = Math.max(result, max);
        }
        System.out.println("n=" + n + "price:" + result);
        solutions.put(n, result);

        return result;
    }

    public int backPack(int m, int[] A, int[] B, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

            }
        }
        return Math.max(backPack(m, A, B, n - 1), A[n] + backPack(m - B[n], A, B, n - 1));

    }

    public static int[][] results;

    public static int maxApple(int[][] apples, int x, int y) {
        if (results == null) {
            results = new int[apples.length][apples[0].length];
        }
        if (x < 0 || y < 0) {
            return 0;
        }
        if (results[x][y] != 0) {
            return results[x][y];
        }
        if (x == 0 && y == 0) {
            return apples[0][0];
        }
        int result = apples[x][y] + Math.max(maxApple(apples, x - 1, y), maxApple(apples, x, y - 1));
        results[x][y] = result;
        return result;
    }

    public static int maxApple(int[][] apples, int x, int y, int z) {
        int[][] res = new int[apples.length][apples[0].length];
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                if (i - 1 < 0 && j - 1 < 0) {
                    res[i][j] = apples[0][0];
                } else if (i - 1 < 0) {
                    res[i][j] = apples[i][j] + res[i][j - 1];
                } else if (j - 1 < 0) {
                    res[i][j] = apples[i][j] + res[i - 1][j];
                } else {
                    res[i][j] = apples[i][j] + Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }
        return res[x][y];
    }

    //时间复杂度：O(N^1.5)
    //空间复杂度：O(1)
    public static void shellSort(int[] in) {
        if (in == null) {
            throw new NullPointerException();
        }
        int len = in.length;
        int h = 1;
        while (h < len / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (in[j] < in[j - h]) {
                        exchange(in, j, j - h);
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }
    }

    private static void exchange(int[] in, int j, int to) {
        int x = in[j];
        in[j] = in[to];
        in[to] = x;

    }
    public int backPackII(int m, int[] A) {
        // write your code here
        int N = A.length;
        int[][] result = new int[N+1][m+1];
        for (int i=0;i<=N;i++){
            result[i][0] = 0;
        }
        for (int i=0;i<=m;i++){
            result[0][i] = 0;
        }

        for (int item = 1;item<=N;item++){
            for (int space = 1;space<=m;space++){
                if (A[item-1] <= space){
                    result[item][space] = Math.max(result[item-1][space],A[item-1] + result[item-1][space - A[item-1]]);
                }else {
                    result[item][space] = result[item-1][space];
                }
            }
        }
        return result[N][m];
    }

    /*
     * @param : A list of integers
     * @param : An integer
     * @return: The median of the element inside the window at each moving
     */
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        int index = (int) (Math.ceil(k/2.0f) - 1);
        int[] sort = new int[k];

        System.arraycopy(nums,0,sort,0,k);
        insertionSort(sort);
        List<Integer> result = new ArrayList<>();
        result.add(sort[index]);
        for (int i=k;i<nums.length;i++){
            handle(sort,nums[i - k],nums[i]);
            result.add(sort[index]);
        }
        return result;
    }

    public static void handle(int[] in,int from,int to){
        int index = 0;
        int lo = 0;
        int hi = in.length - 1;
        int mid;
        while (lo <=hi){
            mid = lo +(hi - lo)/2;
            if (from == in[mid]){
                index = mid;
                break;
            }else if (from > in[mid]){
                lo = mid+1;
            }else {
                hi = mid-1;
            }
        }
        in[index] = to;

        while (index != 0 && in[index] < in[index -1]){
            exchange(in,index,index-1);
            index--;
            if (index <0){
                return;
            }
        }

        while (index != in.length - 1 && in[index] > in[index+1]){
            exchange(in,index,index+1);
            index++;
            if (index >= in.length){
                return;
            }
        }
    }

    public static void insertionSort(int[] in) {
        if (in == null) {
            throw new NullPointerException();
        }

        for (int i = 0, len = in.length; i < len; i++) {

            for (int j = i; j > 0; j--) {
                if (in[j] < in[j - 1]) {
                    exchange(in, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static int knapsack(int val[], int wt[], int W) {
        int N = val.length;
        int[][] result = new int[N+1][W+1];
        for (int i=0;i<=N;i++){
            result[i][0] = 0;
        }
        for (int i=0;i<=W;i++){
            result[0][i] = 0;
        }

        for (int item = 1;item<=N;item++){
            for (int space = 1;space<=W;space++){
                if (wt[item-1] <= space){
                    result[item][space] = Math.max(result[item-1][space],val[item-1] + result[item-1][space - wt[item-1]]);
                }else {
                    result[item][space] = result[item-1][space];
                }
            }
        }
        for (int[] rows : result) {
            for (int col : rows) {
                System.out.format("%5d", col);
            }
            System.out.println();
        }
        return result[N][W];
    }

    public int kthLargestElement(int k, int[] nums, int lo, int hi) {
        // write your code here
        if (nums == null || nums.length < 1 || k < 0) {
            return Integer.MIN_VALUE;
        }
        if (lo>=hi){
            return nums[lo];
        }
        int lt = lo;
        int gt = hi;
        int index = lt + 1;
        int v = nums[lo];
        while (index <= gt) {
            if (nums[index] < v) {
                exchange(nums, index++, lt++);
            } else if (nums[index] == v) {
                index++;
            } else {
                exchange(nums, index, gt--);
            }
        }
        if ((k ) >= lt && (k ) <= gt) {
            return v;
        }else if ((k) <lt){
            return kthLargestElement(k,nums,lo,lt-1);
        }else {
            return kthLargestElement(k,nums,gt+1,hi);
        }
    }
}
