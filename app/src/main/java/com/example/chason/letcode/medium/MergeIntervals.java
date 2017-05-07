package com.example.chason.letcode.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by chason on 17-4-25.
 * index:56
 * https://leetcode.com/problems/merge-intervals/#/description
 */

public class MergeIntervals {
    public static void main(String[] args) {
        List<Interval> in = new ArrayList<>();
        in.add(new Interval(1, 3));
        //in.add(new Interval(1, 3));
        in.add(new Interval(2, 6));
        in.add(new Interval(8, 10));
        in.add(new Interval(15, 18));
        new MergeIntervals().mergeII(in);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }
        //init data size is 16,will add it if needed
        List<Integer> collection = new ArrayList<>();
        int N = 0;
        for (Interval i : intervals) {
            while (N < i.start) {
                N++;
                collection.add(0);
            }

            for (int j = i.start; j < i.end + 1; j++) {
                if (collection.size() - 1 < j) {
                    collection.add(1);
                } else {
                    collection.set(j, 1);
                }
            }
        }
        List<Interval> result = new ArrayList<>();
        N = collection.size();
        collection.add(0);
        int start = -1;
        int end;
        for (int i = 0; i < N; i++) {
            while (collection.get(++start) == 0 && start < N);
            if (start == N)
                return result;
            end = start - 1;
            while (collection.get(++end) != 0 && collection.get(end + 1) != 0 && end < N) ;
            result.add(new Interval(start, end));
            i = end + 1;
            start = end + 1;
        }
        return result;

    }

    public List<Interval> mergeII(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) {
            return intervals;
        }

        int[] bradge = new int[1024];
        List<Interval> result = new ArrayList<>();
        int start=intervals.get(0).start;
        int end = start;
        for (Interval interval : intervals){
            if (interval.end>end){
                end = interval.end;
            }
            if (interval.start < start){
                start = interval.start;
            }

            for (int i = interval.start;i < interval.end;i++){
                bradge[i*2] = 1;
                bradge[i*2 + 1] = 1;
            }
            //最后一个节点通向下一个节点的路是断的
            bradge[interval.end*2] = 1;

        }

        for (int i = start*2;i<end*2+1;){
            int j = i;
            while (bradge[j] == 0){
                j+=2;
            }
            int from = j;
            while (bradge[j+1] == 1){
                j+=2;
            }
            result.add(new Interval(from/2,j/2));
            i = j+2;
        }
        return result;

    }

    private int[] upperArray(int[] src) {
        int[] newArray = new int[src.length * 2];
        System.arraycopy(src, 0, newArray, 0, src.length);
        return newArray;
    }

    private static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
