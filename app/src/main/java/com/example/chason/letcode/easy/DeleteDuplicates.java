package com.example.chason.letcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chason on 17-4-23.
 */

public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(1);
        ListNode thr = new ListNode(2);
        ListNode forth = new ListNode(3);
        ListNode fith = new ListNode(3);
        first.next = second;
        second.next = thr;
        thr.next = forth;
        forth.next = fith;
        new DeleteDuplicates().deleteDuplicatesIII(first);
    }

    public ListNode deleteDuplicatesII(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        int key;
        ListNode prev = head;
        ListNode current = head.next;
        key = prev.val;
        while (current != null){
            if (key == current.val){
                current = current.next;
                prev.next = current;
            }else {
                key = current.val;
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicatesIII(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        int key;
        ListNode prev = head;
        ListNode current = head.next;
        key = prev.val;
        while (current != null){
            while (key == current.val){
                current = current.next;
                if (current == null){
                    prev.next = current;
                    return head;
                }
            }
            prev.next = current;
            prev = current;
            current = current.next;
            key = prev.val;
        }
        return head;
    }
    /**
     * 使得链表中的元素唯一
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        List<Integer> keys = new ArrayList<>();
        ListNode prev = head;
        ListNode current = head.next;
        keys.add(prev.val);
        while (current != null){
            if (keys.contains(current.val)){
                current = current.next;
                prev.next = current;
            }else {
                keys.add(current.val);
                prev = current;
                current = current.next;
            }
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
