package com.example.chason.sort;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chgao on 17-7-20.
 */

public class Sort {
    //时间复杂度：O(NlgN)
    //空间复杂度：O(N)
    public static int[] mergeSortDown(int[] in) {
        if (in == null) {
            throw new NullPointerException();
        }
        if (in.length == 1) {
            return in;
        }
        int mid = in.length / 2;
        int[] left = new int[mid];
        int[] right = new int[in.length - mid];
        System.arraycopy(in, 0, left, 0, left.length);
        System.arraycopy(in, mid, right, 0, right.length);
        return merge(mergeSortDown(left), mergeSortDown(right));
    }

    //时间复杂度：O(NlgN)
    //空间复杂度：O(N)
    //归并排序在最坏的情况下的时间复杂度都是O(NlgN)
    public static void mergeSortUp(int[] in) {
        if (in == null) {
            throw new NullPointerException();
        }

        int[] aux = new int[in.length];
        for (int sub = 1; sub < in.length; sub = sub + sub) {
            for (int i = 0; i < in.length - sub; i += sub + sub) {
                merge(in, aux, i, i + sub - 1, Math.min(i + 2 * sub - 1, in.length - 1));
            }
        }
    }

    private static void merge(@NotNull int[] in, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = in[i];
        }
        int x = lo, y = mid + 1;
        for (int i = lo; i <= hi; i++) {
            if (x > mid) {
                in[i] = aux[y++];
            } else if (y > hi) {
                in[i] = aux[x++];
            } else if (in[x] < in[y]) {
                in[i] = aux[x++];
            } else {
                in[i] = aux[y++];
            }
        }
    }

    private static int[] merge(@NotNull int[] left, @NotNull int[] right) {
        int[] result = new int[left.length + right.length];
        int lIndex = 0, rIndex = 0;
        int i = 0;
        while (lIndex < left.length && rIndex < right.length) {
            if (right[rIndex] < left[lIndex]) {
                result[i++] = right[rIndex++];
            } else {
                result[i++] = left[lIndex++];
            }
        }
        for (int j = rIndex; j < right.length; j++) {
            result[i++] = right[j];
        }

        for (int j = lIndex; j < left.length; j++) {
            result[i++] = left[j];
        }
        return result;
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

    //时间复杂度：O(n^2)
    //空间复杂度：O(1)
    //对于长度为N的数组，选择排序大约需要N^2/2 次比较和N次交换
    public static void selectionSort(int[] in) {
        if (in == null) {
            throw new NullPointerException();
        }
        int min;
        for (int i = 0, len = in.length; i < len; i++) {
            min = i;
            for (int j = i + 1; j < len; j++) {
                if (in[min] > in[j]) {
                    min = j;
                }
            }
            exchange(in, i, min);
        }

    }

    //时间复杂度O(N^2)
    //空间复杂度：O(1)
    //对于随机排列的长度为N且主键不重复的数组，平均需要N^2/4次交换 和 N^2/4次交换
    //最坏情况下需要N^2/2次比较和N^2/2次交换
    //最好情况下需要N-1次比较和0次交换
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

    //时间复杂度：O(NlgN)  平均
    //时间复杂度：O(0.5 * N^2)  最坏：每次切分都正好将切分出一个空数组
    public static void quickSort(int[] in, int lo, int hi) {
        if (in == null || in.length < 2 || hi <= lo) {
            return;
        }
        int j = partition(in, lo, hi);
        quickSort(in, lo, j - 1);
        quickSort(in, j + 1, hi);
    }

    /**
     * @param in
     * @param n  in中最大数的位数
     *           时间复杂度:O(2*n*N) n:为in中最大数的位数
     *           空间复杂度:O(N)
     */
    public static void baseSort(int[] in, int n) {
        if (in == null || in.length < 2) {
            return;
        }
        int len = in.length;
        List<Integer>[] collection = new List[10];
        for (int i = 0; i < 10; i++) {
            collection[i] = new ArrayList<>(len / 20);
        }
        for (int i = 1; i <= n; i++) {
            int x = (int) Math.pow(10, i - 1);
            for (int j : in) {
                collection[(j / x) % 10].add(j);
            }
            int j = 0;
            for (List<Integer> list : collection) {
                for (int after : list) {
                    in[j++] = after;
                }
                list.clear();
            }
        }

    }

    public static void heapSort(int[] in) {
        if (in == null || in.length < 2) {
            return;
        }
        int len = in.length-1;
        for (int i = len / 2; i >= 1; i--) {
            sink(in, i, len);
        }
        while (len > 1) {
            exchange(in, 1, len--);
            sink(in, 1, len);
        }

    }

    private static void sink(int[] in, int k, int N) {
        if (in == null ) {
            throw new IllegalArgumentException();
        }
        while (2 * k <= N) {
            int j = k * 2;
            if (j < N && in[j] < in[j + 1]) {
                j++;
            }
            if (in[k] < in[j]) {
                exchange(in, k, j);
                k = j;
            } else {
                break;
            }
        }
    }

    private static void swim(int[] in, int k) {
        if (in == null || k >= in.length) {
            throw new IllegalArgumentException();
        }
        while (k > 1 && in[k] > in[k / 2]) {
            exchange(in, k, k / 2);
            k = 2 / k;
        }
    }

    private static void exchange(@NotNull int[] in, int from, int to) {
        if (from < 0 || to < 0 || from >= in.length || to >= in.length) {
            throw new IllegalArgumentException();
        }
        if (from == to) {
            return;
        }
        in[from] = in[from] + in[to];
        in[to] = in[from] - in[to];
        in[from] = in[from] - in[to];
    }

    private static int partition(int[] in, int lo, int hi) {
        if (in == null || lo < 0 || lo > in.length || hi < 0 || hi > in.length || lo > hi) {
            throw new IllegalArgumentException();
        }
        int i = lo;
        int j = hi + 1;
        int tmp = in[lo];
        while (true) {
            while (--j > lo && in[j] > tmp) ;
            while (++i < hi && in[i] < tmp) ;
            if (i < j) {
                exchange(in, i, j);
            } else {
                break;
            }
        }
        exchange(in, lo, j);
        return j;
    }
}
