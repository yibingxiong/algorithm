package com.xiong.leetcode;

// 1305. 两棵二叉搜索树中的所有元素
// https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/


import java.util.*;

public class Code1305 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
            traverse(root1, priorityQueue);
            traverse(root2, priorityQueue);
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            while (priorityQueue.size() > 0) {
                arrayList.add(priorityQueue.poll());
            }
            return arrayList;
        }

        private void traverse(TreeNode root1, PriorityQueue<Integer> priorityQueue) {
            if (root1 != null) {
                traverse(root1.left, priorityQueue);
                priorityQueue.add(root1.val);
                traverse(root1.right, priorityQueue);
            }
        }


    }

}
