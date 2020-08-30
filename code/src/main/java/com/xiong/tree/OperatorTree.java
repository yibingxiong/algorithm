package com.xiong.tree;

import java.util.ArrayDeque;

/**
 * 表达式树的苟江
 */
public class OperatorTree {

    static class TreeNode {
        public char value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 构造表达式树
     */
    public static TreeNode makeOperatorTree(String str) {
        char[] chars = str.toCharArray();
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            char tmp = chars[i];
            if (tmp == '+' || tmp == '-' || tmp == '*' || tmp == '/') {
                TreeNode treeNode = arrayDeque.pollFirst();
                TreeNode treeNode1 = arrayDeque.pollFirst();
                arrayDeque.addFirst(new TreeNode(tmp, treeNode1, treeNode));
            } else {
                arrayDeque.addFirst(new TreeNode(tmp, null, null));
            }
        }
        return arrayDeque.pollFirst();
    }

    public static void traverse(TreeNode treeNode) {
        if (treeNode != null) {
            traverse(treeNode.left);
            System.out.print(treeNode.value);
            traverse(treeNode.right);
        }
    }

    public static void main(String[] args) {
        String a = "ab+cde+**";
        TreeNode treeNode = makeOperatorTree(a);
        traverse(treeNode);

    }
}
