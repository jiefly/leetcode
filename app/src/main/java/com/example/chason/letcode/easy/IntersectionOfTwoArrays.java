package com.example.chason.letcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by chason on 17-4-25.
 */

public class IntersectionOfTwoArrays {
    public static void main(String[] args){
        new IntersectionOfTwoArrays().intersect(new int[]{-2147483648,1,2,3},new int[]{1,-2147483648,-2147483648});
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null ||  nums1.length == 0|| nums2.length == 0){
            return new int[0];
        }
        Set<Integer> collection = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        int[] min;
        int[] max;
        if (nums1.length > nums2.length){
            min = nums2;
            max = nums1;
        }else {
            min = nums1;
            max = nums2;
        }

        for (int i:min){
            collection.add(i);

        }
        for (int i=0;i<max.length;i++){
            if (collection.contains(max[i])){
                result.add(max[i]);
            }
        }
        int[] res = new int[result.size()];
        int j = 0;
        Iterator<Integer> i = result.iterator();
        while (i.hasNext()){
            res[j++] = i.next();
        }
        return res;
    }
    public int[] intersectionII(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null ||  nums1.length == 0|| nums2.length == 0){
            return new int[0];
        }
        Set<Integer> collection = new HashSet<>();
        List<Integer> out = new ArrayList<>();
        for ( int i:nums1){
            collection.add(i);
        }

        for (int i:nums2){
            if (collection.contains(i)){
                out.add(i);
                collection.remove(i);
            }
        }
        int[] result = new int[out.size()];
        int i=0;
        for (int j:out){
            result[i++] = j;
        }
        return result;
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null ||  nums1.length == 0|| nums2.length == 0){
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int N1 = nums1.length;
        int N2 = nums2.length;
        int index1 = 0;
        int index2 = 0;
        List<Integer> result = new ArrayList<>();
        while (index1<N1 && index2 < N2){
            if (nums1[index1] == nums2[index2]){
                result.add(nums1[index1]);
                index2++;
                index1++;
            }else if (nums1[index1] > nums2[index2]){
                index2++;
            }else {
                index1++;
            }
        }
        int[] out = new int[result.size()];
        for (int i = 0; i<result.size();i++)
            out[i] = result.get(i);
        return out;
    }
}
