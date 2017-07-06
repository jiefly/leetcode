package com.example.chason.offer;

import java.util.Stack;

/**
 * Created by chgao on 17-7-6.
 * 题目：输入两个链表，找出他们的第一个公共节点。
 */

public class Task_37 {
    public static void main(String[] args) {
        System.out.println(solution_1(Support.generateNode(new int[]{1, 2, 3, 6, 7}), Support.generateNode(new int[]{4, 5, 6, 7})).mKey);
        System.out.println(solution_2(Support.generateNode(new int[]{17}), Support.generateNode(new int[]{17})).mKey);

    }

    /*
    * 利用栈实现链表倒置，从而从尾部相同的地方开始比较节点是否相同
    * */
    public static Support.ListNode solution_1(Support.ListNode one, Support.ListNode other) {
        if (one == null || other == null) {
            return null;
        }
        Stack<Support.ListNode> stack1 = new Stack<>();
        Stack<Support.ListNode> stack2 = new Stack<>();
        while (one != null) {
            stack1.push(one);
            one = one.mNext;
        }
        while (other != null) {
            stack2.push(other);
            other = other.mNext;
        }
        Support.ListNode lastSame = null;
        while (!stack1.empty() && !stack2.empty()) {
            if (stack1.peek().equals(stack2.peek())) {
                lastSame = stack1.pop();
                stack2.pop();
            } else {
                return lastSame;
            }
        }
        return lastSame;
    }

    public static Support.ListNode solution_2(Support.ListNode one, Support.ListNode other) {
        if (one == null || other == null) {
            return null;
        }

        int lenOne = 0;
        int lenOther = 0;
        Support.ListNode headerOne = one;
        Support.ListNode headerOther = other;
        while (one != null) {
            lenOne++;
            one = one.mNext;
        }
        while (other != null) {
            lenOther++;
            other = other.mNext;
        }

        if (lenOne > lenOther) {
            while (lenOne != lenOther) {
                headerOne = headerOne.mNext;
                lenOne--;
            }
        } else if (lenOne < lenOther) {
            while (lenOne != lenOther) {
                headerOther = headerOther.mNext;
                lenOther--;
            }
        }

        while (!headerOne.equals(headerOther)) {
            headerOne = headerOne.mNext;
            headerOther = headerOther.mNext;
        }

        return headerOne;
    }
}
