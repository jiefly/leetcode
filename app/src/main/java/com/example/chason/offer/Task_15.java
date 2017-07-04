package com.example.chason.offer;

import com.example.chason.offer.Support.ListNode;

/**
 * Created by chgao on 17-7-4.
 * 题目：输入一个链表，输出该链表的倒数第k个节点。为了符合大多数人的习惯，本题从1开始记数，级链表的尾节点是倒数第一个节点。
 */

public class Task_15 {
    public static void main(String[] args)  {
        ListNode three = new ListNode(3, null);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        ListNode head = new ListNode(0, one);
        ListNode n = null;
        try {
            n = solution(head, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(n.mKey);
    }

    public static ListNode solution(ListNode header, int k) throws Exception {
        if (header == null){
            throw new Exception("头结点不能为空");
        }
        if (k <1){
            throw new Exception("k 输入不合法");
        }
        k = k - 1;
        ListNode before = header;
        ListNode later = header;
        while (k-- != 0) {
            if (before == null) {
                throw new Exception("输入的参数不合法");
            } else {
                before = before.mNext;
            }
        }
        if (before == null ){
            throw new Exception("输入的参数不合法");
        }
        while (before.mNext != null) {
            before = before.mNext;
            later = later.mNext;
        }

        return later;
    }

}
