package com.example.chason.letcode.mst;

import android.support.annotation.NonNull;

/**
 * Created by chason on 17-4-27.
 */

public class Edge implements Comparable<Edge> {
    private final int v;
    private final int w;
    private final double mWeight;
    public Edge(int v,int w,int weight){
        this.v = v;
        this.w = w;
        this.mWeight = weight;
    }


    public double weight(){
        return mWeight;
    }

    public int either(){
        return v;
    }

    public int other(int v){
        if (this.v == v) return this.w;
        else if (this.w == v)return v;
        else throw new RuntimeException("Inconsistent edge!");
    }

    public boolean contains(int v){
        return this.v == v || this.w == v;
    }

    @Override
    public int compareTo(@NonNull Edge o) {
        if (mWeight > o.mWeight) return 1;
        else if (mWeight < o.mWeight) return -1;
        else return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Edge))
            return false;
        Edge other = (Edge) obj;
        int one = other.either();
        int two = other.other(one);
        return (one == v || one == w) && (two == v || two == w);
    }
}
