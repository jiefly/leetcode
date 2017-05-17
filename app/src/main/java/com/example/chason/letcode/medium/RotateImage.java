package com.example.chason.letcode.medium;

import java.util.Scanner;

/**
 * Created by chgao on 17-5-17.
 * index:48
 * url:https://leetcode.com/problems/rotate-image/#/description
 */

public class RotateImage {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        while (s.hasNext()){
            int N = s.nextInt();
            int[][] in = new int[N][N];
            for (int i=0;i<N;i++){
                String[] a = s.next().split(",");
                int x = 0;
                for (String s1:a){
                    in[i][x++] = Integer.valueOf(s1);
                }

            }
            new RotateImage().rotate(in);
        }
    }


    public void rotate(int[][] matrix){
        int N = matrix.length;
        System.out.println("before------>");
        for (int[] x:matrix){
            for (int i:x){
                System.out.print(i+",");
            }
            System.out.println("");
        }
        for (int j=0;j<N/2;j++){
            for (int i=j;i<N-j-1;i++){
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[N-i-1][j];
                matrix[N-i-1][j] = matrix[N-j-1][N-i-1];
                matrix[N-j-1][N-i-1] = matrix[i][N-j-1];
                matrix[i][N-j-1] = tmp;
            }
        }
        System.out.println("after----->:");
        for (int[] x:matrix){
            for (int i:x){
                System.out.print(i+",");
            }
            System.out.println("");
        }
    }
}
