package com.example.chason.offer;

import java.util.Scanner;

/**
 * Created by chgao on 17-7-3.
 */

public class AlibabaCodeTest {

    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static long AppLaunchTaskOptimize(int[] in) {
        quickSort(in);
        int index = in.length-1;
        int sum = 0;
        int left = in[index--];
        int right = in[index--];
        int min;
        while (index > -1) {
            min = Math.min(left, right);
            sum += min;
            left = left - min;
            right = right - min;
            if (left == 0) {
                left = in[index--];
            }
            if (right == 0&&index>0) {
                right = in[index--];
            }
        }
        return sum + Math.max(left, right);
    }

    public static void quickSort(int[] array) {
        if (array != null) {
            quickSort(array, 0, array.length - 1);
        }
    }

    private static void quickSort(int[] array, int beg, int end) {
        if (beg >= end || array == null)
            return;
        int p = partition(array, beg, end);
        quickSort(array, beg, p - 1);
        quickSort(array, p + 1, end);
    }

    private static int partition(int[] array, int beg, int end) {
        int first = array[beg];
        int i = beg, j = end;
        while (i < j) {
            while (array[i] <= first && i < end) {
                i++;
            }
            while (array[j] > first && j >= beg) {
                j--;
            }
            if (i < j) {
                array[i] = array[i] ^ array[j];
                array[j] = array[i] ^ array[j];
                array[i] = array[i] ^ array[j];
            }
        }
        if (j != beg) {
            array[j] = array[beg] ^ array[j];
            array[beg] = array[beg] ^ array[j];
            array[j] = array[beg] ^ array[j];
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(AppLaunchTaskOptimize(new int[]{1, 10 , 100,  200  ,50 , 90  ,30 , 20 , 10,  27 , 57}));
        Scanner in = new Scanner(System.in);

        int _tasks_temp = Integer.parseInt(in.nextLine().trim());
        int[] intData = new int[_tasks_temp];
        for (int i=0;i<_tasks_temp;i++){
            intData[i] = Integer.parseInt(in.next());
        }
        System.out.println(AppLaunchTaskOptimize(intData));
    }
}
