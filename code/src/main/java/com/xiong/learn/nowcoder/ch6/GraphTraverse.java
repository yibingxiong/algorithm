package com.xiong.learn.nowcoder.ch6;

import java.util.*;

public class GraphTraverse {
    public static void traverseBFS(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> visit = new HashSet<>();

        queue.add(node);
        visit.add(node);
        while (!queue.isEmpty()) {
            Node nodeA = queue.poll();
            visit.add(nodeA);
            System.out.println(nodeA.val);
            ArrayList<Node> nexts = nodeA.nexts;
            for (Node n : nexts) {
                if (!visit.contains(n)) {
                    queue.add(n);
                }
            }
        }
    }

    public static void traverseDFS(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        HashSet<Node> visit = new HashSet<>();
        System.out.println(node.val);
        visit.add(node);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            ArrayList<Node> nexts = pop.nexts;
            for (Node n : nexts) {
                if (!visit.contains(n)) {
                    visit.add(n);
                    stack.push(pop);
                    stack.push(n);
                    System.out.println(n.val);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n1.nexts.add(n2);
        n1.nexts.add(n3);
        n3.nexts.add(n2);
        n3.nexts.add(n4);
        n2.nexts.add(n5);
        traverseBFS(n1);
        System.out.println("------bfs");
        traverseDFS(n1);
    }
}
