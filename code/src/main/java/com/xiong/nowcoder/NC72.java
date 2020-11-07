package com.xiong.nowcoder;

import java.util.Stack;

public class NC72 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public class Solution {
        public void Mirror2(TreeNode root) {
            process2(root);
        }

        private void process2(TreeNode root) {
            if (root!=null) {
                TreeNode tmp = root.left;
                root.left = root.right;
                root.right = tmp;
                process2(root.left);
                process2(root.right);
            }
        }

        public void Mirror(TreeNode root) {
            if (root==null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode n = stack.pop();
                TreeNode tmp = n.left;
                n.left = n.right;
                n.right = tmp;

                if (n.left!=null) {
                    stack.push(n.left);
                }
                if (n.right !=null) {
                    stack.push(n.right);
                }
            }
        }
    }
}
