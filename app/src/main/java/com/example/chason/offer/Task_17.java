package com.example.chason.offer;

/**
 * Created by chgao on 17-7-4.
 * 题目：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是按照递增排序的。
 */

public class Task_17 {
    public static void main(String[] args) {
        Support.ListNode node = solution(Support.generateNode(new int[]{1}), Support.generateNode(new int[]{2}));
        System.out.println(node);
    }

    public static Support.ListNode solution(Support.ListNode one, Support.ListNode other) {
        if (one == null) {
            return other;
        }
        if (other == null) {
            return one;
        }
        Support.ListNode start;
        if (one.mKey < other.mKey) {
            start = one;
            one = one.mNext;
        } else {
            start = other;
            other = other.mNext;
        }
        Support.ListNode current = start;
        while (one != null && other != null) {
            if (one.mKey < other.mKey) {
                current.mNext = one;
                current = one;
                one = one.mNext;
            } else {
                current.mNext = other;
                current = other;
                other = other.mNext;
            }
        }
        if (one != null) {
            current.mNext = one;
        } else {
            current.mNext = other;
        }
        return start;
    }
}
