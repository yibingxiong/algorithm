package com.xiong.nowcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class NC93_LRU_3 {

    static class LRUCache<K, V> {
        private static class Entry<K, V> {
            public Entry pre;
            public Entry next;
            public K key;
            public V value;

            public Entry(Entry pre, Entry next, K key, V value) {
                this.pre = pre;
                this.next = next;
                this.key = key;
                this.value = value;
            }
        }

        LinkedList<Entry> linkedList;
        private HashMap<K, Entry<K, V>> table;
        private final int MAX_SIZE;


        public LRUCache(int size) {
            this.MAX_SIZE = size;
            this.linkedList = new LinkedList<>();
            table = new HashMap<>((int)(size / 0.75)+1, 0.75f);
        }

        public void set(K key, V value) {
            Entry<K, V> entry = getEntry(key);
            if (entry == null) {
                entry = new Entry<>(null, null, key, value);
                if (table.size() >= MAX_SIZE) {
                    removeLast();
                }
                linkedList.add(entry);
            } else {
                entry.value = value;
                moveToFirst(entry);
            }
        }

        public V get(K key) {
            Entry<K, V> entry = getEntry(key);
            if (entry == null) {
                return null;
            }
            moveToFirst(entry);
            return entry.value;
        }

        private Entry<K, V> getEntry(K key) {
            return table.get(key);
        }

        private void moveToFirst(Entry entry) {
            boolean remove = linkedList.remove(entry);
            linkedList.addFirst(entry);
        }

        private void removeLast() {
            Entry entry = linkedList.removeLast();
            table.remove(entry.key);
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
        LRUCache<Integer, Integer> solution = new LRUCache(k);
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
