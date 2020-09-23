package com.xiong.learn.nowcoder.ch5;

/**
 * 寻找最小公共祖先
 */
public class LeastFather {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node findFather(Node head, Node a, Node b) {
        if (head == null || head == a || head == b) {
            return head;
        }

        Node left = findFather(head.left, a, b);
        Node right = findFather(head.right, a, b);

        if (left != null && right != null) {
            return head;
        }
        return left != null ? left : right;

    }

    public static void main(String[] args) {
        Node node = new Node(2);
        Node node1 = new Node(1);
        Node node2 = new Node(9);
        node.left = node1;
        node.right = node2;
        Node father = findFather(node, node1, node2);
        if (father != null) {
            System.out.println(father.val);
        }
    }
}
