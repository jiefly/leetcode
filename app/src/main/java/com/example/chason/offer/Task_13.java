package com.example.chason.offer;

/**
 * Created by chgao on 17-7-4.
 * 题目：给定单项链表的头指针和一个节点指针，定义一个函数在O（1）时间内删除该节点。
 */

public class Task_13 {
    public static void main(String[] args) {
        ListNode three = new ListNode(3, null);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        ListNode head = new ListNode(0, one);
        solution(head, three);
        System.out.println(head);
    }

    public static ListNode solution(ListNode header, ListNode deleted) {
        if (header == null || deleted == null) {
            return header;
        }
        if (header == deleted) {
            return header.mNext;
        }
        ListNode next = deleted.mNext;
        if (next != null) {
            deleted.mNext = next.mNext;
            deleted.mKey = next.mKey;
            next = null;
        } else {
            ListNode tmp = header;
            while (tmp.mNext.mNext != null) {
                tmp = tmp.mNext;
            }
            tmp.mNext = null;
        }
        return header;
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
