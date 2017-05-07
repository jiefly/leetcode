package com.example.chason.letcode.easy;

/**
 * Created by chason on 17-4-22.
 */

public class ReverseList {

    public static void main(String[] args) {
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(1);
        ListNode thr = new ListNode(2);
        ListNode forth = new ListNode(3);
        ListNode fith = new ListNode(4);
        first.next = second;
        second.next = null;
        thr.next = forth;
        forth.next = fith;
        ListNode result = new ReverseList().reverse(first,1,2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverse(ListNode head, int m, int n) {
        if (m == n){
            return head;
        }
        int index = 1;
        ListNode from = null;
        ListNode to = null;
        ListNode pFrom = null;
        ListNode pTo = null;
        m = Math.min(m, n);
        n = Math.max(m, n);
        ListNode start = head;
        while (start != null) {

            if (index == m-1){
                from = start;
            }else if (index == m){
                pFrom = start;
            }else if (index == n){
                pTo = start;
            }else if (index == n+1){
                to = start;
            }
            index++;
            start = start.next;
        }

        pTo.next = null;
        reverse(pFrom);
        pFrom.next = to;
        if (from != null) {
            from.next = pTo;
        }else {
            return pTo;
        }
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next = head.next;
        ListNode lastCurrent;
        while (next != null) {
            current.next = prev;
            lastCurrent = next.next;
            next.next = current;
            if (lastCurrent == null) {
                break;
            }
            prev = next;
            current = lastCurrent;
            next = current.next;
        }
        if (next == null) {
            current.next = prev;
            return current;
        }
        return next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
