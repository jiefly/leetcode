package com.example.chason.letcode.easy;

/**
 * Created by chason on 17-4-24.
 */

public class ArrangingCoins {
    public static void main(String[] args){
        System.out.println(new ArrangingCoins().arrangeCoins(2147483647));
    }

    public int arrangeCoins(int n) {
        if (n<1){
            return 0;
        }
        if (n >((65535+1)*65535/2)){
            return 65535;
        }
        long left = 1;
        long right = (int) Math.floor(Math.pow(2L*Integer.MAX_VALUE - 0.25,0.5) - 0.5);
        long mid = (left + right)/2;
        long needed = (mid + 1)*mid/2;
        while (left != right){
            if (needed > n){
                right = left + (right - left)/2;
            }else if (needed < n){
                left = left + (right - left)/2;
            }else {
                return (int) mid;
            }
            if (mid != (right + left)/2) {
                mid = (right + left) / 2;
            }else {
                return (int) mid;
            }
            needed = (mid + 1)*mid/2;
        }
        return (int) mid;
    }
}
