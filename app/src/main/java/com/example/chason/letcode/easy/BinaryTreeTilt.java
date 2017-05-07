package com.example.chason.letcode.easy;

/**
 * Created by chason on 17-4-24.
 */

public class BinaryTreeTilt {
    public static void main(String[] args){

    }

    public int findTilt(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftTilt = findTilt(root.left);
        int rightTilt = findTilt(root.right);
        return Math.abs(leftTilt - rightTilt) + root.val;
    }

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
}
