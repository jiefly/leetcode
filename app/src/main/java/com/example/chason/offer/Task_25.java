package com.example.chason.offer;

import com.example.chason.lintcode.Tree;

import java.util.Stack;

public class Task_25 {
    public static void main(String[] args){

    }

    public static void solution(Tree.TreeNode root,int currentSum,int exceptedSum,Stack<Tree.TreeNode> stack){
        currentSum+=exceptedSum+root.val;
        boolean isLeft = root.left == null && root.right == null;
        
    }
}
