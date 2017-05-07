package com.example.chason.letcode.easy;

/**
 * Created by chason on 17-4-23.
 */

public class RemoverElements {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
        new RemoverElements().removeELements(one, 5);

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeELements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }
        ListNode prev = head;
        ListNode current = head.next;
        while (current != null) {
            while (current != null && current.val == val) {
                current = current.next;
                prev.next = current;
            }
            prev = prev.next;
            if (prev == null || prev.next == null) {
                break;
            }
            current = prev.next;
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
