package com.example.chason.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by chgao on 17-7-20.
 */

public class SortTest {
    public static void main(String[] args) {
        int[] in = new int[18];
        System.out.println("raw data:");
        for (int i = 0; i < in.length; i++) {
            in[i] = new Random().nextInt(100);
            System.out.print(in[i] + "_");
        }
        System.out.println("");
        int[] tmp1 = copy(in);
        Sort.shellSort(tmp1);
        System.out.println("shell sort:");
        for (int i : tmp1) {
            System.out.print(i + "_");
        }
        System.out.println("");
        tmp1 = copy(in);
        System.out.println("insertion sort:");
        Sort.insertionSort(tmp1);
        for (int i : tmp1) {
            System.out.print(i + "_");
        }
        System.out.println("");
        tmp1 = copy(in);
        System.out.println("selection sort:");
        Sort.selectionSort(tmp1);
        for (int i : tmp1) {
            System.out.print(i + "_");
        }
        System.out.println("");
        System.out.println("merge sort down:");
        for (int i : Sort.mergeSortDown(copy(in))) {
            System.out.print(i + "_");
        }
        System.out.println("");
        tmp1 = copy(in);
        System.out.println("quick sort:");
        Sort.quickSort(tmp1,0,tmp1.length-1);
        for (int i : tmp1) {
            System.out.print(i + "_");
        }
        System.out.println("");
        tmp1 = copy(in);
        System.out.println("merge sort up:");
        Sort.mergeSortUp(tmp1);
        for (int i : tmp1) {
            System.out.print(i + "_");
        }
        System.out.println("");
        tmp1 = copy(in);
        System.out.println("base sort:");
        Sort.baseSort(tmp1,3);
        for (int i : tmp1) {
            System.out.print(i + "_");
        }
        System.out.println("");
        tmp1 = copy(in);
        System.out.println("heap sort:");
        Sort.heapSort(tmp1);
        for (int i : tmp1) {
            System.out.print(i + "_");
        }
        System.out.println("");
        tmp1 = copy(in);
        System.out.println("quick3way sort:");
        Sort.quick3WaySort(tmp1,0,tmp1.length-1);
        for (int i : tmp1) {
            System.out.print(i + "_");
        }
        System.out.println("");
        tmp1 = copy(in);
        System.out.println("double pivot quick sort:");
        Sort.doublePivotQuickSort(tmp1,0,tmp1.length-1);
        for (int i : tmp1) {
            System.out.print(i + "_");
        }
        System.out.println("\nend");

    }

    private static int[] copy(int[] from) {
        int[] result = new int[from.length];
        System.arraycopy(from, 0, result, 0, result.length);
        return result;
    }
}
