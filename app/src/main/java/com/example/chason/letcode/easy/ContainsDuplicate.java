package com.example.chason.letcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chason on 17-4-23.
 */

public class ContainsDuplicate {
    private static List<Integer> sDatas = new ArrayList<>();
    private static int[] data;
    static {
        data = new int[30000 + 245000];
        for (int i=0;i<30000+24500;i++){
            data[i] = i-24500;
        }

    }
    public static void main(String[] args){

        long current = System.currentTimeMillis();
        new ContainsDuplicate().containsNearbyDuplicate(data,35000);
        System.out.println("spand time:"+(System.currentTimeMillis() - current));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
            if (k < 1){
                return false;
            }
            int N = nums.length;
            Set<Integer> nearbyKeys = new HashSet<>();
            for (int i=0;i<N;i++){
                if (i > k){
                    nearbyKeys.remove(nums[i-k-1]);
                }
                if (!nearbyKeys.add(nums[i])){
                    return true;
                }
            }
            return false;
    }
}
