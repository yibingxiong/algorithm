package book.chapter5.section3;

import java.util.LinkedList;
import java.util.List;

public class SeprateChainingHashTable<T> {
    private List<T>[] theLists;
    private int currentSize;
    private static final int DEFAULT_TABLE_SIZE = 101;

    public SeprateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    public SeprateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<T>();
        }
        currentSize = 0;
    }

    public void insert(T x) {
        List<T> list = theLists[myHash(x)];
        if (!list.contains(x)) {
            list.add(x);
            if (++currentSize > theLists.length) {
                rehash();
            }
        }
    }

    public void remove(T x) {
        List<T> list = theLists[myHash(x)];
        if (list.contains(x)) {
            list.remove(x);
            currentSize--;
        }
    }

    public boolean contains(T x) {
        List<T> list = theLists[myHash(x)];
        return list.contains(x);
    }

    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++) {
            theLists[i].clear();
        }
        currentSize = 0;
    }

    private int myHash(T x) {
        int hash = x.hashCode();
        hash %= theLists.length;
        if (hash < 0) {
            hash += theLists.length;
        }
        return hash;
    }

    private void rehash() {
        List<T>[] oldList = theLists;
        theLists = new List[nextPrime(2 * theLists.length)];
        for (int i = 0; i < theLists.length; i++) {
            theLists[i] = new LinkedList<T>();
        }
        currentSize = 0;
        for (int i = 0; i < oldList.length; i++) {
            for (T item : oldList[i]) {
                insert(item);
            }
        }
    }

    private static int nextPrime(int n) {
        int k = n;
        while (!isPrime(k)) {
            k++;
        }
        return k;
    }

    private static boolean isPrime(int n) {
        boolean prime = true;//是否是质数的标志
        for (int i = n - 1; i > 1; i--) {//n除以每个比n小比1大的自然数
            if (n % i == 0) {//如果有能被整除的，则不是质数
                prime = false;
                break;
            }
        }
        return prime;
    }

}
