package com.xiong.learn.nowcoder.c2.self;

import java.util.HashMap;

public class RandomPool<K> {
    private int size;
    private HashMap<Integer, K> idxKey;
    private HashMap<K, Integer> keyIdx;

    public RandomPool() {
        size = 0;
        idxKey = new HashMap<>();
        keyIdx = new HashMap<>();
    }

    public void insert(K key) {
        if (!keyIdx.containsKey(key)) {
            keyIdx.put(key, size++);
            idxKey.put(size - 1, key);
        }
    }

    public void delete(K key) {
        Integer integer = keyIdx.get(key);
        if (integer != null) {
            K k = idxKey.get(size - 1);
            idxKey.put(integer, k);
            keyIdx.put(k, integer);
            idxKey.remove(size - 1);
            size--;
        }
    }

    public K getRandom() {
        int idx = (int) (Math.random() * size);
        K k = idxKey.get(idx);
        return k;
    }

    public static void main(String[] args) {
        RandomPool<String> stringRandomPool = new RandomPool<>();
        stringRandomPool.insert("aaa");
        stringRandomPool.insert("bbb");
        stringRandomPool.insert("ccc");
        stringRandomPool.insert("ddd");
        stringRandomPool.delete("bbb");
        for (int i = 0; i < 100; i++) {
            System.out.println(stringRandomPool.getRandom());
        }
    }
}
