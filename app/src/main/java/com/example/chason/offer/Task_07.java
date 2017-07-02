package com.example.chason.offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by chgao on 17-7-2.
 * 题目：用两个栈实现一个队列。队列声明如下，请实现他的两个函数appendTail和deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能
 */

public class Task_07 {
    public static void main(String[] args) {
        JQueue<Integer> queue = new JQueue<>();
        JStack<Integer> stack = new JStack<>();
        for (int i = 0; i < 10; i++) {
            queue.appendTail(i);
            stack.push(i);
        }
        stack.pop();
        stack.push(1);
        stack.push(12);
        stack.push(123);
        stack.push(1234);
        while (!stack.empty()){
            System.out.println(stack.pop());
        }

    }

    /*题目：用两个队列实现一个栈。
    * */
    private static class JStack<T> {
        Queue<T> mUpQueue;
        Queue<T> mDownQueue;

        public JStack() {
            mUpQueue = new LinkedList<>();
            mDownQueue = new LinkedList<>();
        }

        public void push(T t) {
            mUpQueue.add(t);
        }

        public boolean empty(){
            return mUpQueue.isEmpty() && mDownQueue.isEmpty();
        }

        public T pop() {
            if (!mUpQueue.isEmpty()) {
                T tmp = mUpQueue.poll();
                if (!mUpQueue.isEmpty()) {
                    mDownQueue.add(tmp);
                } else {
                    return tmp;
                }
            } else {
                if (mDownQueue.isEmpty()) {
                    return null;
                }
                Queue qTmp = mDownQueue;
                mDownQueue = mUpQueue;
                mUpQueue = qTmp;
            }
            return pop();
        }

    }

    private static class JQueue<T> {
        Stack<T> mPopStack;
        Stack<T> mPushStack;

        public JQueue() {
            mPushStack = new Stack<>();
            mPopStack = new Stack<>();
        }

        void appendTail(T node) {
            mPushStack.push(node);
        }

        T deleteHead() {
            if (mPopStack.empty()) {
                while (!mPushStack.empty()) {
                    mPopStack.push(mPushStack.pop());
                }
            }
            return mPopStack.pop();
        }

        boolean empty() {
            return mPopStack.empty() && mPushStack.empty();
        }
    }
}
