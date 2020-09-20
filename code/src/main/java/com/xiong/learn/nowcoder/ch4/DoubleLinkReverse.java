package com.xiong.learn.nowcoder.ch4;

import com.xiong.learn.nowcoder.ch1.HeapTest;

import java.awt.*;

public class DoubleLinkReverse {
    public static class Node {
        public int val;
        public Node next;
        public Node pre;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val, Node next, Node pre) {
            this.val = val;
            this.next = next;
            this.pre = pre;
        }

    }

    public static Node[] reverse(Node head) {
        Node cur = head;
        Node newHead = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = cur.pre;
            cur.pre = next;
            newHead = cur;
            cur = next;
        }
        return new Node[]{newHead, head};
    }

    public static void print(Node[] heads) {
        Node node1 = heads[0];
        Node node2 = heads[1];
        System.out.println("打印双向链表");
        while (node1 != null) {
            System.out.print(node1.val + "  ");
            node1 = node1.next;
        }

        System.out.println();

        while (node2 != null) {
            System.out.print(node2.val + "  ");
            node2 = node2.pre;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node2.pre = node1;
        node3.pre = node2;
        node4.pre = node3;

        print(new Node[]{node1, node4});

        Node[] nodes = reverse(node1);
        print(nodes);
    }
}
