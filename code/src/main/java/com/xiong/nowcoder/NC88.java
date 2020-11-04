package com.xiong.nowcoder;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NC88 {
    public static class Finder {
        public int findKth(int[] a, int n, int K) {
            // write code here
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(K, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            for (int i = 0; i < n; i++) {
                priorityQueue.add(a[i]);
            }
            if (priorityQueue.size() == K) {
                return priorityQueue.poll();
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Finder finder = new Finder();
        int kth = finder.findKth(new int[]{1, 3, 5, 2, 2}, 5, 3);
        System.out.println(kth);
    }
}
