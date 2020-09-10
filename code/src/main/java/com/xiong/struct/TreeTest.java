package com.xiong.struct;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTest {
    public static class Tree {
        public int val;
        public Tree left;
        public Tree right;

        public Tree() {
        }

        public Tree(int val) {
            this.val = val;
        }

        public Tree(int val, Tree left, Tree right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void bfs1(Tree root) {
        if (root == null) {
            return;
        }
        Queue<Tree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            root = queue.poll();
            System.out.println(root.val);
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }


    }

    public static void dfs1(Tree root) {
        if (root != null) {
            System.out.println(root.val);
            dfs1(root.left);
            dfs1(root.right);
        }
    }

    public static void dfs2(Tree root) {
        if (root == null) {
            return;
        }
        Stack<Tree> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            System.out.println(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public static void main(String[] args) {
        Tree root = new Tree();
        root.val = 1;
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.right.right = new Tree(5);
        bfs1(root);
        System.out.println("dfs1-------");
        dfs1(root);
        System.out.println("dfs2---------");
        dfs2(root);
    }
}
