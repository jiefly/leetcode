package com.example.chason.offer;

import java.util.Arrays;

/**
 * Created by chgao on 17-7-2.
 * 题目：输入某二叉树前序遍历和中序遍历的结果，请输出该二叉树。假设输入的前序遍历和中序遍历都不含重复数字。
 */

public class Task_06 {
    public static void main(String[] args) {
        int[] before = new int[]{1};
        int[] mid = new int[]{1};
        BinaryTreeNode head = solution(before,mid);
        System.out.println(head);
    }

    public static BinaryTreeNode solution(int[] before, int[] mid) {
        //mid
        if (before == null || mid == null || before.length == 0 || mid.length == 0) {
            return null;
        }
        int head = before[0];
        int length = -1;
        for (int i = 0; i < mid.length; i++) {
            if (head == mid[i]) {
                length = i;
            }
        }
        if (head == -1){
            try {
                throw new Exception("输入的前序遍历与中序遍历不匹配");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        BinaryTreeNode left = solution(Arrays.copyOfRange(before, 1, length + 1), Arrays.copyOfRange(mid, 0, length));
        BinaryTreeNode right = solution(Arrays.copyOfRange(before, length + 1, before.length), Arrays.copyOfRange(mid, length + 1, before.length));
        return new BinaryTreeNode(before[0], left, right);
    }

    static class BinaryTreeNode {
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
