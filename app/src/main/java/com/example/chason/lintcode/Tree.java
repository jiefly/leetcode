package com.example.chason.lintcode;

import java.util.Stack;

public class Tree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
//        TreeNode A = new TreeNode()
    }

    /**
     * @param root: The root of the binary search tree.
     * @param A     and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        trackNode(root,A);
        return null;
    }

    private Stack<TreeNode> trackNode(TreeNode root, TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean back =false;
        while (!stack.empty()){
            TreeNode tmp = stack.peek();
            if (back){
                if (tmp.right == null){
                    stack.pop();
                }else {
//                    stack.
                }
            }
            if (tmp.val == node.val){
                return stack;
            }else {
                if (tmp.right == null&& tmp.left == null){
                    stack.pop();
                }else if (tmp.left != null){
                }else {

                }
            }
        }
        return null;
    }


    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

}
