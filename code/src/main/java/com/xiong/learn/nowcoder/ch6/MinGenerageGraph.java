package com.xiong.learn.nowcoder.ch6;

import java.util.*;

public class MinGenerageGraph {
    /**
     * kruskal
     *
     * @param graph
     * @return
     */
    public static List<Edge> generate1(Graph graph) {
        PriorityQueue<Edge> edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        for (Edge edge : graph.edges) {
            edges.add(edge);
        }

        MySet mySet = new MySet(graph.nodes.values());


        List<Edge> res = new ArrayList<>();
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            Node to = edge.to;
            Node from = edge.from;
            if (!mySet.isSame(to, from)) {
                res.add(edge);
                mySet.union(to, from);
            }
        }

        return res;
    }


    /**
     * prim
     *
     * @param graph
     * @return
     */
    public static List<Edge> generage2(Graph graph) {
        Iterator<Node> iterator = graph.nodes.values().iterator();
        Node node = iterator.next();
        PriorityQueue<Edge> edges = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        HashSet<Node> set = new HashSet<>();
        for (Edge edge1 : node.edges) {
            edges.add(edge1);
        }
        set.add(node);
        List<Edge> res = new ArrayList<>();
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            Node to = edge.to;
            if (!set.contains(to)) {
                set.add(to);
                res.add(edge);
                for (Edge edge1 : to.edges) {
                    edges.add(edge1);
                }
            }
        }

        return res;

    }

    public static class MySet {
        HashMap<Node, HashSet<Node>> map = new HashMap<>();

        public MySet(Collection<Node> nodes) {
            for (Node node : nodes) {
                HashSet<Node> nodes1 = new HashSet<>();
                nodes1.add(node);
                map.put(node, nodes1);
            }
        }

        public boolean isSame(Node node1, Node node2) {
            HashSet<Node> nodes1 = map.get(node1);
            HashSet<Node> nodes2 = map.get(node2);
            return node1 == node2;

        }

        public void union(Node node1, Node node2) {
            HashSet<Node> nodes1 = map.get(node1);
            HashSet<Node> nodes2 = map.get(node2);
            nodes1.addAll(nodes2);
            map.put(node2, nodes1);
        }
    }
}
