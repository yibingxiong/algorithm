package com.xiong.learn.nowcoder.ch6;

import java.util.*;

public class TuopuSort {
    public static List<Node> tuopu(Graph graph) {
        HashMap<Node, Integer> nodeInMap = new HashMap<>();

        Queue<Node> zeroInNode = new LinkedList<>();

        for (Node node : graph.nodes.values()) {
            nodeInMap.put(node, node.in);
            if (node.in == 0) {
                zeroInNode.add(node);
            }
        }
        List<Node> res = new ArrayList<>();
        while (!zeroInNode.isEmpty()) {
            Node node = zeroInNode.poll();
            res.add(node);
            for (Node next : node.nexts) {
                Integer nextNewIn = nodeInMap.get(nodeInMap) - 1;
                nodeInMap.put(next, nodeInMap.get(nodeInMap) - 1);
                if (nextNewIn == 0) {
                    zeroInNode.add(next);
                }
            }
        }
        return res;
    }
}
