package com.xiong.learn.nowcoder.ch6;

import java.util.ArrayList;

public class Node {
    public int val;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int val) {
        this.val = val;
        this.in = 0;
        this.out = 0;
        this.nexts = new ArrayList<>();
        this.edges = new ArrayList<>();
    }
}
