package com.xiong.learn.nowcoder.ch5;

import java.util.LinkedList;

public class SpecialBT {
    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static class SearchRes {
        public boolean isSearch;
        public int min;
        public int max;
    }

    /**
     * 判断一颗二叉树是否为搜索二叉树
     *
     * @param node
     * @return
     */
    public static boolean isSearchBT(Node node) {
        return processSearchBT(node).isSearch;
    }

    public static SearchRes processSearchBT(Node node) {
        if (node == null) {
            SearchRes searchRes = new SearchRes();
            searchRes.isSearch = true;
            searchRes.max = Integer.MIN_VALUE;
            searchRes.min = Integer.MAX_VALUE;
            return searchRes;
        } else {
            SearchRes leftSearchRes = processSearchBT(node.left);
            SearchRes rightSearchRes1 = processSearchBT(node.right);
            int max = Math.max(leftSearchRes.max, Math.max(rightSearchRes1.max, node.val));
            int min = Math.min(leftSearchRes.min, Math.min(rightSearchRes1.min, node.val));
            boolean isSearch = leftSearchRes.isSearch
                    && rightSearchRes1.isSearch
                    && node.val >= leftSearchRes.max
                    && node.val <= rightSearchRes1.min;
            SearchRes searchRes = new SearchRes();
            searchRes.min = min;
            searchRes.max = max;
            searchRes.isSearch = isSearch;
            return searchRes;
        }
    }

    public static boolean isSearchBT2(Node node) {
        if (node == null) {
            return true;
        }

        LinkedList<Node> stack = new LinkedList<>();

        int pre = Integer.MIN_VALUE;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.addLast(node);
                node = node.left;
            } else {
                Node a = stack.pollLast();
                if (a.val < pre) {
                    return false;
                }
                pre = a.val;
                node = a.right;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        Node node = new Node(2);
        node.left = new Node(1);
        node.right = new Node(9);

        System.out.println(isSearchBT(node));

        System.out.println(isSearchBT2(node));
    }
}
