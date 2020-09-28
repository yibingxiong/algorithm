package com.xiong.learn.nowcoder.ch7;

import java.util.PriorityQueue;

/**
 * 分金条
 */
public class CutGold {
    public static int minCost(int[] input) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            priorityQueue.add(input[i]);
        }
        int sum = 0;
        while (priorityQueue.size() > 1) {
            Integer a = priorityQueue.poll();
            Integer b = priorityQueue.poll();
            priorityQueue.add(a + b);
            sum+=a+b;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println(minCost(arr));
    }
}
