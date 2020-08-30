package com.xiong.tanxin;


import java.util.PriorityQueue;

public class HafmanTree {
    static class HafMan implements Comparable<HafMan> {
        private int weight;
        private HafMan left;
        private HafMan right;

        public HafMan(int weight, HafMan left, HafMan right) {
            this.weight = weight;
            this.left = left;
            this.right = right;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public HafMan getLeft() {
            return left;
        }

        public void setLeft(HafMan left) {
            this.left = left;
        }

        public HafMan getRight() {
            return right;
        }

        public void setRight(HafMan right) {
            this.right = right;
        }


        public int compareTo(HafMan o) {
            return this.weight - o.weight;
        }
    }

    public static HafMan makeTree(int[] weights) {
        PriorityQueue<HafMan> priorityQueue = new PriorityQueue<HafMan>();
        for (int i = 0; i < weights.length; i++) {
            priorityQueue.add(new HafMan(weights[i], null, null));
        }

        while (priorityQueue.size() > 1) {
            HafMan one = priorityQueue.poll();
            HafMan two = priorityQueue.poll();
            HafMan newTree = new HafMan(one.weight + two.weight, one, two);
            priorityQueue.add(newTree);
        }
        return priorityQueue.poll();
    }

    public static void traverse(HafMan root) {
        if (root != null) {
            System.out.println(root.weight);
            traverse(root.left);
            traverse(root.right);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4};
        HafMan root = makeTree(a);

        traverse(root);
    }
}
