package com.xiong.nowcoder;

public class NC98 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    public class Solution {
        /**
         * @param root1 TreeNode类
         * @param root2 TreeNode类
         * @return bool布尔型
         */
        public boolean isContains(TreeNode root1, TreeNode root2) {
            // write code here
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            serializeTree(root1, sb1);
            serializeTree(root2, sb2);
            return sb1.toString().contains(sb2.toString());
        }

        private void serializeTree(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("#");
                return;
            }
            sb.append(root.val);
            serializeTree(root.left, sb);
            serializeTree(root.right, sb);
        }
    }
}
