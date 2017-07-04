package com.example.chason.offer;

/**
 * Created by chgao on 17-7-4.
 * 题目：请完成一个函数，输入一个二叉树，该函数输出他的镜像。
 */

public class Task_19 {
    public static void main(String[] args) {
        Support.BinaryTreeNode head = new Support.BinaryTreeNode(111,new Support.BinaryTreeNode(222,null,null),new Support.BinaryTreeNode(333,null,null));
        head = solution(head);
        System.out.println(head);
    }

    public static Support.BinaryTreeNode solution(Support.BinaryTreeNode src) {
        if (src == null) {
            return null;
        }
        Support.BinaryTreeNode tmp = src.mLeft;
        src.mLeft = solution(src.mRight);
        src.mRight = solution(tmp);
        return src;
    }
}
