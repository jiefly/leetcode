package com.example.chason.offer;

/**
 * Created by chgao on 17-7-4.
 * 题目：定义一个函数，输入一个链表的头结点，反转该链表并输出反转后的链表头节点。
 */

public class Task_16 {
    public static void main(String[] args) {
Support.ListNode three = new Support.ListNode(3, null);
        Support.ListNode two = new Support.ListNode(2, three);
        Support.ListNode one = new Support.ListNode(1, two);
        Support.ListNode head = new Support.ListNode(0, one);
        Support.ListNode n = solution(head);
        System.out.println(n);
    }

    public static Support.ListNode solution(Support.ListNode header) {
        if (header == null || header.mNext == null) {
            return header;
        }
        Support.ListNode start = header;
        Support.ListNode current = header.mNext;
        Support.ListNode end = header.mNext.mNext;
        start.mNext = null;
        while (current != null) {
            current.mNext = start;
            start = current;
            current = end;
            if (end != null) {
                end = end.mNext;
            }
        }

        return start;

    }
}
