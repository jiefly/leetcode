package com.example.chason.offer;

import java.util.Stack;

/**
 * Created by chgao on 17-7-4.
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push、pop的时间复杂度都是O（1）
 */

public class Task_21 {
    public static void main(String[] args) {
        JStack jStack = new JStack();
        jStack.push(3);
        jStack.push(2);
        jStack.push(3);
        System.out.println(jStack.min());
        jStack.pop();
        System.out.println(jStack.min());
        jStack.pop();
        System.out.println(jStack.min());
    }


    public static class JStack {
        private Stack<Integer> data;
        private Stack<Integer> min;

        public JStack() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int t) {
            data.push(t);
            if (min.isEmpty()) {
                min.push(t);
            } else {
                if (min.peek() > t) {
                    min.push(t);
                } else {
                    min.push(min.peek());
                }
            }
        }

        public int pop() {
            min.pop();
            return data.pop();
        }

        public int min() {
            return min.peek();
        }
    }
}
