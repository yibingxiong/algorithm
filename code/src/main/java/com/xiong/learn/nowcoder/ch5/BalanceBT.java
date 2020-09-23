package com.xiong.learn.nowcoder.ch5;

public class BalanceBT {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static class Res {
        public int height;
        public boolean isBalance;

        public Res(int height, boolean isBalance) {
            this.height = height;
            this.isBalance = isBalance;
        }
    }

    public static boolean isBalance(Node head) {
        if (head == null) {
            return true;
        }
        return process(head).isBalance;
    }

    private static Res process(Node head) {
        if (head == null) {
            return new Res(0, true);
        }
        Res left = process(head.left);
        Res right = process(head.right);

        int height = Math.max(left.height, right.height) + 1;
        boolean isBalance = Math.abs(left.height - right.height) < 2;

        return new Res(height, isBalance);
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(9);
        node.left.left = new Node(10);
        node.left.left.left = new Node(10);

        System.out.println(isBalance(node));
    }
}
