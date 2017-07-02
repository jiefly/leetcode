package com.example.chason.offer;

import java.util.Stack;

/**
 * Created by chgao on 17-7-2.
 * 题目：输入一个链表的头结点，从尾到头反过来打印出每个节点的值。
 */

public class Task_05 {
    public static void main(String[] args) {

        ListNode three = new ListNode(3, null);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        ListNode head = new ListNode(0, one);
        solution_1(head);
        System.out.println("");
        three = new ListNode(3, null);
        two = new ListNode(2, three);
        one = new ListNode(1, two);
        head = new ListNode(0, one);
        solution_2(head);
    }

    public static void solution_1(ListNode in) {
        if (in == null) {
            return;
        }
        if (in.mNext == null) {
            System.out.print(in.mKey + "_");
            return;
        }
        solution_1(in.mNext);
        System.out.print(in.mKey + "_");
    }

    public static void solution_2(ListNode in) {
        if (in == null) {
            return;
        }
        Stack<Integer> result = new Stack<>();
        while (in != null) {
            result.push(in.mKey);
            in = in.mNext;
        }
        while (!result.empty()) {
            System.out.print(result.pop() + "_");
        }
    }

    private static class ListNode {
        int mKey;
        ListNode mNext;

        public ListNode(int key, ListNode next) {
            this.mKey = key;
            this.mNext = next;
        }
    }
}
