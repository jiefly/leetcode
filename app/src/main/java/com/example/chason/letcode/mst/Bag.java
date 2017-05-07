package com.example.chason.letcode.mst;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chason on 17-4-27.
 */

public class Bag<D> implements Iterator<D> {
    Queue<D> mDatas = new LinkedList<>();
    public void add(D data){
        mDatas.add(data);
    }

    @Override
    public boolean hasNext() {
        return mDatas.isEmpty();
    }

    @Override
    public D next() {
        return mDatas.poll();
    }
}
