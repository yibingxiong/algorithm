package com.xiong.nowcoder;

import java.util.HashMap;

public class NC61 {
    public class Solution {
        /**
         * @param numbers int整型一维数组
         * @param target  int整型
         * @return int整型一维数组
         */
        public int[] twoSum(int[] numbers, int target) {
            // write code here
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < numbers.length; i++) {
                map.put(numbers[i], i);
            }
            for (int i = 0; i < numbers.length; i++) {
                int n = numbers[i];
                int m = target - n;
                if (map.containsKey(m) && map.get(m) != i) {
                    return new int[]{i + 1, map.get(m) + 1};
                }
            }
            return new int[2];
        }
    }
}
