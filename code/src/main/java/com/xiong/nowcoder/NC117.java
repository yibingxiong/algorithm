package com.xiong.nowcoder;

public class NC117 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public class Solution {

        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            // write code here
            merge(t1, t2);
            return t1;
        }

        private TreeNode merge(TreeNode t1, TreeNode t2) {
            if (t1 != null && t2 != null) {
                t1.val = t1.val + t2.val;
            }
            if (t1 == null && t2 == null) {
                return null;
            }
            if (t1 == null) {
                t1 = t2;
                return t1;
            }
            if (t1 != null && t2 != null) {
                t1.left = merge(t1.left, t2.left);
                t1.right = merge(t1.right, t2.right);
            }
            return t1;
        }
    }
}
