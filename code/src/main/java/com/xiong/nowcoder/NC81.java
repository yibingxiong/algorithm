package com.xiong.nowcoder;

public class NC81 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public class Solution {
        private TreeNode t;
        private int k1;

        TreeNode KthNode(TreeNode pRoot, int k) {
            k1=  k;
            getKthNode(pRoot);
            return t;
        }

        void getKthNode(TreeNode proot) {
            if (proot == null) {
                return;
            }

            getKthNode(proot.left);
            k1--;
            if (k1 == 0) {
                t = proot;
                return;
            }
            getKthNode(proot.right);
        }


    }
}
