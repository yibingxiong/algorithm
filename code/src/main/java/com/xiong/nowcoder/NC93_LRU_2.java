package com.xiong.nowcoder;

import java.util.*;

public class NC93_LRU_2 {

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

        private Entry first;
        private Entry tail;
        private HashMap<K, Entry<K, V>> table;
        private final int MAX_SIZE;


        public LRUCache(int size) {
            this.MAX_SIZE = size;
            table = new HashMap<>();
        }

        public void set(K key, V value) {
            Entry<K, V> entry = getEntry(key);
            if (entry == null) {
                entry = new Entry<K, V>(null, null, key, value);
                if (table.size() >= MAX_SIZE) {
                    removeLast();
                }
                if (first == null) {
                    first = entry;
                    tail = entry;
                } else {
                    entry.next = first;
                    first.pre = entry;
                    first = entry;
                    first.pre = null;
                }
                table.put(key, entry);
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
            if (entry == first) {
                return;
            }
            if (entry == tail) {
                tail = tail.pre;
            }
            if (entry.pre != null) {
                entry.pre.next = entry.next;
            }
            if (entry.next != null) {
                entry.next.pre = entry.pre;
            }
            entry.next = first;
            first.pre = entry;
            first = entry;
            first.pre = null;

        }

        private void removeLast() {

            if (tail != null) {
                table.remove(tail.key);
                tail = tail.pre;
                tail.next = null;
                if (tail == null) {
                    first = null;
                }
            }
        }
        public V remove(K key) {
            Entry<K, V> entry = getEntry(key);
            if (entry == null) {
                return null;
            }
            table.remove(key);
            if (entry.pre != null) {
                entry.pre.next = entry.next;
            } else {
                first = entry.next;
            }
            if (entry.next != null) {
                entry.next.pre = entry.pre;
            } else {
                tail = entry.pre;
            }
            return entry.value;
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
