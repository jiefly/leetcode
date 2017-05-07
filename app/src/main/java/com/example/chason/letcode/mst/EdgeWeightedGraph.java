package com.example.chason.letcode.mst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chason on 17-4-27.
 */

public class EdgeWeightedGraph {
    private int mEdgesCount;
    private int mPointsCount;
    private Bag<Edge>[] adj;

    public EdgeWeightedGraph(int pointsCount) {
        this.mPointsCount = pointsCount;
        this.mEdgesCount = 0;
        adj = (Bag<Edge>[]) new Bag[pointsCount];
        for (int i = 0; i < pointsCount; i++) adj[i] = new Bag<>();
    }

    public int getmEdgesCount() {
        return mEdgesCount;
    }

    public int getmPointsCount() {
        return mPointsCount;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        mEdgesCount++;
    }

    public List<Edge> edges() {
        List<Edge> result = new ArrayList<>();
        for (int i = 0; i < mPointsCount; i++) {
            while (adj[i].hasNext()) {
                Edge e = adj[i].next();
                if (e.other(i) > i) {
                    result.add(e);
                }
            }
        }
        return result;
    }
}
