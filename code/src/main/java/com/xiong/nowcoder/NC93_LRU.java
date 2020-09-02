package com.xiong.nowcoder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NC93_LRU {
    static class LRUCache<T> {
        private LinkedHashMap<Integer, T> cache;
        private int capacity;
        private final float factor = 0.75f;

        public LRUCache(int k) {
            int size = (int) Math.ceil(k / factor) + 1;
            this.cache = new LinkedHashMap<Integer, T>(size, 0.71f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, T> eldest) {
                    return size() > capacity;
                }
            };
            this.capacity = k;
        }

        public int size() {
            return this.cache.size();
        }

        public void set(int key, T value) {
            this.cache.put(key, value);
        }

        public T get(int key) {
            T res = this.cache.get(key);
            return res;
        }
    }


    /**
     * lru design
     *
     * @param operators int整型二维数组 the ops
     * @param k         int整型 the k
     * @return int整型一维数组
     */
    public int[] LRU(int[][] operators, int k) {
        // write code here
        LRUCache<Integer> solution = new LRUCache(k);
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            int[] line = operators[i];
            if (line[0] == 1) {
                solution.set(line[1], line[2]);
            } else {
                Integer i1 = solution.get(line[1]);
                if (i1 == null) {
                    resList.add(-1);
                } else {
                    resList.add(i1);
                }
            }
        }

        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
