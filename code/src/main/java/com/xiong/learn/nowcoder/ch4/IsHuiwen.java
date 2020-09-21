package com.xiong.learn.nowcoder.ch4;

public class IsHuiwen {
    public static class Node {
        public int val;
        public Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }
    }


    public static boolean isHuiwen(Node head) {
        Node fast = head;
        Node slow = head;
        Node headTmp = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node tmp = slow;
        Node pre = slow;
        slow = slow.next;
        // 反转中点之后的部分
        while (slow != null) {
            Node n = slow.next;
            slow.next = pre;
            pre = slow;
            slow = n;
        }
        slow = pre;
        tmp.next = null;
        boolean res = true;
        // 从左右往中间靠， 判断是不是回文
        while (head != null) {
            if (head.val != slow.val) {
                res = false;
                break;
            }
            head = head.next;
            slow = slow.next;
        }

        slow = pre;
        pre = null;

        // 调整链表为原来的样子
        while (slow != tmp) {
            Node next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        tmp.next = pre;
        return res;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        n1.next = new Node(2);
        n1.next.next = new Node(2);
        n1.next.next.next = new Node(1);

        System.out.println(isHuiwen(n1));

        printList(n1);
    }
}
