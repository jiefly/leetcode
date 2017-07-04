package com.example.chason.offer;

/**
 * Created by chgao on 17-7-4.
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。
 */

public class Task_18 {
    // TODO: 17-7-4 需要看一下二叉树相关的知识
    public static void main(String[] args) {

    }

    public static boolean solution(Support.BinaryTreeNode A, Support.BinaryTreeNode B) {
        if (A == null && B == null) {
            return true;
        } else if (A == null) {
            return false;
        } else if (B == null) {
            return true;
        }
        int headKey = B.mValue;
        return false;

    }


}
