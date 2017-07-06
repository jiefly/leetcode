package com.example.chason.offer;

/**
 * Created by chgao on 17-7-6.
 * 题目一：输入一颗二叉树的根节点，求该树的深度。
 * 从根结点到也叶子结点依次经过的结点（包括根节点和叶子结点）形成树的一条路径，最长路径的长度为树的深度。
 */

public class Task_39 {
    public static void main(String[] args) {

    }


    public static int solution_1(Support.BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.mRight == null && root.mLeft == null) {
            return 1;
        }
        return 1 + Math.max(solution_1(root.mLeft), solution_1(root.mRight));
    }

    /*
    * 题目二：输入一棵树的根结点，判断该树是不是平衡二叉树。
    * 如果某二叉树中任意结点的左右子树的深度相差不超过１，那么他就是一颗平衡二叉树。
    * */
    public static boolean solution_2(Support.BinaryTreeNode root) {
        // TODO: 17-7-6 incomplete
        return false;
    }
}
