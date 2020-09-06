package com.xiong.nowcoder;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class NC45 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }


    public class Solution {
        /**
         * @param root TreeNode类 the root of binary tree
         * @return int整型二维数组
         */
        public int[][] threeOrders(TreeNode root) {
            // write code here
            List<Integer> pre = new ArrayList<>();
            List<Integer> mid = new ArrayList<>();
            List<Integer> post = new ArrayList<>();
            traverse(root, pre, mid, post);
            int[][] res = {toArray(pre), toArray(mid), toArray(post)};
            return res;
        }

        private int[] toArray(List<Integer> list) {
            int[] arr = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }
            return arr;
        }

        public void traverse(TreeNode root, List<Integer> pre, List<Integer> mid, List<Integer> post) {
            if (root != null) {
                pre.add(root.val);
                traverse(root.left, pre, mid, post);
                mid.add(root.val);
                traverse(root.right, pre, mid, post);
                post.add(root.val);
            }
        }
    }

}
