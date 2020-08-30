package com.xiong.tree;

public class BinarySearchTree {
    private TreeNode root;

    static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int value) {
        this.root = insert(value, this.root);
    }

    private TreeNode insert(int value, TreeNode root) {
        if (root == null) {
            return new TreeNode(value, null, null);
        } else {
            if (value < root.value) {
                root.left = insert(value, root.left);
            } else {
                root.right = insert(value, root.right);
            }
            return root;
        }
    }

    public boolean contains(int value) {
        return contains(value, this.root);
    }


    private boolean contains(int value, TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        if (treeNode.value == value) {
            return true;
        } else if (treeNode.value < value) {
            return contains(value, treeNode.right);
        } else {
            return contains(value, treeNode.left);
        }
    }

    public static void tranerse(TreeNode root) {
        if (root != null) {
            tranerse(root.left);
            System.out.println(root.value);
            tranerse(root.right);
        }

    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(6);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(1);
        binarySearchTree.insert(4);
        binarySearchTree.insert(3);

        tranerse(binarySearchTree.root);

        System.out.println(binarySearchTree.contains(2));
        System.out.println(binarySearchTree.contains(11));
        System.out.println(binarySearchTree.contains(5));
    }

}
