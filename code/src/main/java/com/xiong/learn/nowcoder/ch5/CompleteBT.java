package com.xiong.learn.nowcoder.ch5;

import java.util.LinkedList;

/**
 * 判断一棵树是否为完全二叉树
 * 层序遍历， 如果有右孩子，没有左孩子，不是
 * 否则，遇到第一个有左没有右孩子的节点后，后续遇到的节点必须都是叶子节点
 */
public class CompleteBT {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static boolean isComplete(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(head);
        boolean isMeet = false;
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (node.left != null) {
                if (isMeet) {
                    return false;
                }
                if (node.right == null) {
                    isMeet = true;
                }
            } else {
                if (node.right != null) { // 有右无左
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

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(9);
//        node.right.right = new Node(10);

        System.out.println(isComplete(node));
    }
}
