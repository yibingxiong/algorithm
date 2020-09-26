package com.xiong.learn.nowcoder.ch5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class SerializeBT {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }


    public static String serialize(Node head) {
        StringBuilder stringBuilder = new StringBuilder();
        doSerialize(head, stringBuilder);
        return stringBuilder.toString();
    }

    public static void doSerialize(Node head, StringBuilder sb) {
        if (head == null) {
            sb.append("#_");
            return;
        } else {
            sb.append(head.val + "_");
        }
        doSerialize(head.left, sb);
        doSerialize(head.right, sb);
    }


    public static Node deSerialize(String string) {
        String[] arr = string.split("_");
        LinkedList<String> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            queue.addLast(arr[i]);
        }
        return doDeSerialize(queue);
    }

    public static Node doDeSerialize(LinkedList<String> queue) {
        String v = queue.pollFirst();
        if (v.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(v));
        head.left = doDeSerialize(queue);
        head.right = doDeSerialize(queue);
        return head;
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.left.left = new Node(5);
        node.right = new Node(9);
        String btStr = serialize(node);
        System.out.println(btStr);
        Node node1 = deSerialize(btStr);
        String btStr2 = serialize(node1);
        System.out.println(btStr2);
    }
}
