package com.xiong.learn.nowcoder.ch4;

import java.util.Stack;

public class ReverseLink {
    public static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static Node reverse1(Node head) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        if (stack.isEmpty()) {
            return null;
        }

        head = stack.pop();
        Node cur = head;
        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static Node reverse2(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = null;
        Node cur = head;

        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void printLinedList(Node head) {
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        Node newNode = reverse1(head);
        printLinedList(newNode);

        Node node = reverse2(newNode);
        printLinedList(node);
    }
}
