package com.example.chason.letcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by chason on 17-4-28.
 */

public class TopKFrequentElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String in = scanner.next();
            String[] s = in.split(",");
            int[] nums = new int[s.length];
            for (int i = 0;i<s.length;i++){
                nums[i] = Integer.valueOf(s[i]);
            }
            List<Integer> result = topKFrequent(nums,scanner.nextInt());
            System.out.print("[");
            for (int i : result){
                System.out.print(i+",");
            }
            System.out.println("]");
        }
    }
    public static List<Integer> topKFrequentII(int[] nums, int k) {
        Map<Integer,Integer> collection = new HashMap<>();
        for (int i = 0;i<nums.length;i++){

        }
        for (int i:nums){
            if (collection.containsKey(i)){
                collection.put(i,collection.get(i)+1);
            }else {
                collection.put(i,1);
            }
        }
        int[] result = new int[collection.size()+1];
        Arrays.fill(result,-1);
        int N = 0;
        Iterator<Integer> integerIterator = collection.keySet().iterator();
        while (integerIterator.hasNext()){
            int n = integerIterator.next();
            result[++N] = n;
            swim(result,N,collection);
        }

        List<Integer> out = new ArrayList<>();
        for (int i=k-1;i>-1;i--){
            out.add(result[1]);
            result[1] = result[N--];
            sign(result,1,N,collection);
        }
        return out;
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> collection = new HashMap<>();
        for (int i:nums){
            if (collection.containsKey(i)){
                collection.put(i,collection.get(i)+1);
            }else {
                collection.put(i,1);
            }
        }
        int[] result = new int[collection.size()+1];
        Arrays.fill(result,-1);
        int N = 0;
        Iterator<Integer> integerIterator = collection.keySet().iterator();
        while (integerIterator.hasNext()){
            int n = integerIterator.next();
            result[++N] = n;
            swim(result,N,collection);
        }

        List<Integer> out = new ArrayList<>();
        for (int i=k-1;i>-1;i--){
            out.add(result[1]);
            result[1] = result[N--];
            sign(result,1,N,collection);
        }
        return out;
    }

    public static void swim(int[] in,int n,Map<Integer,Integer> map){

        while (n>1&&map.get(in[n]) > map.get(in[n/2]) ){
            exchange(in,n,n/2);
            n = n/2;
        }
    }

    public static void sign(int[] in,int n,int N,Map<Integer,Integer> map){
        while (2*n<=N){
            int j = 2*n;
            if (j < N && map.get(in[j]) < map.get(in[j+1])) j++;
            if (map.get(in[n]) < map.get(in[j])){
                exchange(in,n,j);
                n = j;
            }else {
                break;
            }
        }

    }

    public static void exchange(int[] in,int from,int to){
        int tmp = in[from];
        in[from] = in[to];
        in[to] = tmp;
    }


}
