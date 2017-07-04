package com.example.chason.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by chgao on 17-7-4.
 * 题目：从上往下打印出二叉树的每一个节点，同一层的节点按照从左到右的顺序打印。
 */

public class Task_23 {
    public static void main(String[] args) {
        Support.BinaryTreeNode head = new Support.BinaryTreeNode(8,new Support.BinaryTreeNode(6,new Support.BinaryTreeNode(5,null,null),new Support.BinaryTreeNode(7,null,null)),new Support.BinaryTreeNode(10,new Support.BinaryTreeNode(9,null,null),new Support.BinaryTreeNode(11,null,null)));
        List<Integer> result = solution(head);
        for (int i : result){
            System.out.print(i+"_");
        }
    }

    public static List<Integer> solution(Support.BinaryTreeNode src) {
        if (src == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<Support.BinaryTreeNode> collection = new LinkedList<>();
        collection.add(src);
        Support.BinaryTreeNode tmp;
        while (!collection.isEmpty()) {
            tmp = collection.poll();
            if (tmp.mLeft != null) {
                collection.add(tmp.mLeft);
            }
            if (tmp.mRight != null) {
                collection.add(tmp.mRight);
            }
            result.add(tmp.mValue);
        }
        return result;
    }
}
