package com.xiong.learn.nowcoder.c2.self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UnionFind<T> {
    private class Node<T> {
        public T value;

        public Node(T value) {
            this.value = value;
        }
    }

    private HashMap<Node, Node> fatherMap;
    private HashMap<T, Node> valueNodeMap;

    public UnionFind(List<T> nodes) {
        fatherMap = new HashMap<>();
        valueNodeMap = new HashMap<>();
        for (T v :
                nodes) {
            Node node = new Node(v);
            fatherMap.put(node, node);
            valueNodeMap.put(v, node);
        }
    }

    public Node findHead(T v) {
        Node node = valueNodeMap.get(v);
        List<Node> path = new ArrayList<>();
        while (node != null && fatherMap.get(node) != node) {
            node = fatherMap.get(node);
            path.add(node);
        }
        for (int i = 0; i < path.size(); i++) {
            fatherMap.put(path.get(i), node);
        }
        return node;
    }

    public boolean isSameSet(T a, T b) {
        Node head1 = findHead(a);
        Node head2 = findHead(b);
        return head1 == head2;
    }

    public void union(T a, T b) {
        Node head1 = findHead(a);
        Node head2 = findHead(b);
        if (head1 != head2) {
            fatherMap.put(head1, head2);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        UnionFind<String> stringUnionFind = new UnionFind<>(list);
        boolean sameSet = stringUnionFind.isSameSet("a", "b");
        System.out.println(sameSet);
        stringUnionFind.union("a", "b");
        stringUnionFind.union("c", "d");
        System.out.println(stringUnionFind.isSameSet("a", "b"));
        System.out.println(stringUnionFind.isSameSet("c", "d"));
        System.out.println(stringUnionFind.isSameSet("d", "a"));
        stringUnionFind.union("a", "e");
        stringUnionFind.union("a", "c");
        System.out.println(stringUnionFind.isSameSet("a", "d"));
        System.out.println(stringUnionFind.isSameSet("d", "e"));
    }
}
