package com.example.chason.offer;

/**
 * Created by chgao on 17-7-4.
 */

public class Support {
    public static ListNode generateNode(int[] datas) {
        if (datas == null || datas.length == 0) {
            return null;
        }
        ListNode result = new ListNode(datas[datas.length - 1], null);
        for (int i = datas.length - 2; i > -1; i--) {
            result = new ListNode(datas[i], result);
        }
        return result;
    }

    public static class ListNode {
        int mKey;
        ListNode mNext;

        public ListNode(int key, ListNode next) {
            this.mKey = key;
            this.mNext = next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof ListNode){
                if (mKey == ((ListNode) obj).mKey){
                    return true;
                }
            }
            return false;
        }
    }

    public static class BinaryTreeNode {
        int mValue;
        BinaryTreeNode mLeft;
        BinaryTreeNode mRight;

        BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
            this.mValue = value;
            this.mLeft = left;
            this.mRight = right;
        }
    }
}
