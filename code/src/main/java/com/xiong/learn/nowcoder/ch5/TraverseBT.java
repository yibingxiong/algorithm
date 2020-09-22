package com.xiong.learn.nowcoder.ch5;

import java.util.LinkedList;
import java.util.Stack;

public class TraverseBT {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void preOrderTraverse(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + "  ");
        preOrderTraverse(head.left);
        preOrderTraverse(head.right);
    }

    public static void inOrderTraverse(Node head) {
        if (head == null) {
            return;
        }
        inOrderTraverse(head.left);
        System.out.print(head.val + "  ");
        inOrderTraverse(head.right);
    }

    public static void postOrderTraverse(Node head) {
        if (head == null) {
            return;
        }
        postOrderTraverse(head.left);
        postOrderTraverse(head.right);
        System.out.print(head.val + "  ");
    }

    public static void preOrderTraverse2(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print(n.val + "  ");
            if (n.right != null) {
                stack.push(n.right);
            }
            if (n.left != null) {
                stack.push(n.left);
            }
        }
    }

    public static void postOrderTraverse2(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(head);

        while (!stack1.isEmpty()) {
            Node n = stack1.pop();
            stack2.push(n);
            if (n.left != null) {
                stack1.push(n.left);
            }
            if (n.right != null) {
                stack1.push(n.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }


    // 这个比较难以理解
    public static void inOrderTraverse2(Node head) {
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.val + " ");
                    head = head.right;
                }
            }
        }
    }

    /**
     * bfs
     *
     * @param node
     */
    public static void bfs(Node node) {
        if (node == null) {
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(node);
        while (!queue.isEmpty()) {
            Node node1 = queue.pollFirst();
            System.out.print(node1.val + " ");

            if (node1.left != null) {
                queue.addLast(node1.left);
            }
            if (node1.right != null) {
                queue.addLast(node1.right);
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);

        System.out.println("先序遍历");
        System.out.println("递归");
        preOrderTraverse(head);
        System.out.println("\n非递归");
        preOrderTraverse2(head);
        System.out.println("\n----------------");

        System.out.println("后序遍历");
        System.out.println("递归");
        postOrderTraverse(head);
        System.out.println("\n非递归");
        postOrderTraverse2(head);
        System.out.println("\n----------------");

        System.out.println("中序遍历");
        System.out.println("递归");
        inOrderTraverse(head);
        System.out.println("\n非递归");
        inOrderTraverse2(head);
        System.out.println("\n----------------");

        System.out.println("bfs");
        System.out.println("递归");
        bfs(head);
    }
}
