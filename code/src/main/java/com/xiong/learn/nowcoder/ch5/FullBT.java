package com.xiong.learn.nowcoder.ch5;

import java.util.LinkedList;

public class FullBT {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private static int count = 0;
    private static int maxHeight = 0;

    public static boolean isFull(Node head) {
        calculate(head, 1);
        if ((int) Math.pow(2, maxHeight) - 1 == count) {
            return true;
        }
        return false;
    }

    public static boolean isFull2(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(head);
        boolean isMeet = false;

        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (node.left == null && node.right != null) {
                return false;
            } else if (node.left != null && node.right == null) {
                return false;
            } else if (node.left == null && node.right == null) {
                isMeet = true;
            } else {
                if (isMeet) {
                    return false;
                }
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return true;
    }

    private static void calculate(Node head, int i) {
        if (head == null) {
            return;
        }
        if (i > maxHeight) {
            maxHeight = i;
        }
        count++;
        calculate(head.left, i + 1);
        calculate(head.right, i + 1);
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(9);
        node.right.right = new Node(10);

        System.out.println(isFull(node));
        System.out.println(isFull2(node));
    }
}
