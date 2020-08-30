package com.xiong.leetcode;

// 1305. 两棵二叉搜索树中的所有元素
// https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/


import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Code1305_2 {
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
            List<Integer> list1 = new ArrayList<Integer>();
            List<Integer> list2 = new ArrayList<Integer>();
            traverse(root1, list1);
            traverse(root2, list2);
            List<Integer> res = new ArrayList<Integer>();
            int p = 0;
            int q = 0;
            while (p < list1.size() && q < list2.size()) {
                if (list1.get(p) < list2.get(q)) {
                    res.add(list1.get(p++));
                } else {
                    res.add(list2.get(q++));
                }
            }

            while (p < list1.size()) {
                res.add(list1.get(p++));
            }
            while (q < list2.size()) {
                res.add(list2.get(q++));
            }
            return res;
        }

        private void traverse(TreeNode root1, List<Integer> list) {
            if (root1 != null) {
                traverse(root1.left, list);
                list.add(root1.val);
                traverse(root1.right, list);
            }
        }


    }

}
