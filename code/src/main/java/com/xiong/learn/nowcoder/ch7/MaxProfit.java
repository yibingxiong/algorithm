package com.xiong.learn.nowcoder.ch7;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最大利润问题
 */
public class MaxProfit {
    public static int getMax(int[] costs, int[] profits) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o1;
            }
        });
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < costs.length; i++) {
            minQueue.add(costs[i]);
        }

        return 0;
    }
}
