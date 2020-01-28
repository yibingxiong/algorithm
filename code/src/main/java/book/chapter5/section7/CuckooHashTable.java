package book.chapter5.section7;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Random;

public class CuckooHashTable<T> {
    private static final double MAX_LOAD = 0.4;
    private static final int ALLOWED_REHASHES = 1;
    private static final int DEFAULT_TABLE_SIZE = 101;
    private final HashFamily<? super T> hashFamily;
    private final int numHashFunctions;
    private T[] array;
    private int currentSize;

    public CuckooHashTable(HashFamily<? super T> hf) {
        this(hf, DEFAULT_TABLE_SIZE);
    }

    public CuckooHashTable(HashFamily<? super T> hf, int size) {
        allocateArray(nextPrime(size));
        doClear();
        hashFamily = hf;
        numHashFunctions = hashFamily.getNumberOfFunctions();
    }

    public boolean contains(T x) {
        return findPos(x) != -1;
    }

    public boolean remove(T x) {
        int pos = findPos(x);
        if (pos != -1) {
            array[pos] = null;
            currentSize--;
        }
        return pos != -1;
    }

    public boolean insert(T x) {
        if (contains(x)) {
            return false;
        }
        if (currentSize >= array.length * MAX_LOAD) {
            expand();
        }

        return insertHelper(x);
    }

    private void doClear() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    private int myhash(T x, int which) {
        int hash = hashFamily.hash(x, which);
        hash %= array.length;
        if (hash < 0) {
            hash += array.length;
        }
        return hash;
    }

    private int findPos(T x) {
        for (int i = 0; i < numHashFunctions; i++) {
            int pos = myhash(x, i);
            if (array[pos] != null && array[pos].equals(x)) {
                return pos;
            }
        }
        return -1;
    }

    private void expand() {
        rehash((int) (array.length / MAX_LOAD));
    }

    private void rehash() {
        hashFamily.generateNewFunctions();
        rehash(array.length);
    }

    private void rehash(int newLength) {
        T[] oldArray = array;
        allocateArray(nextPrime(newLength));
        currentSize = 0;
        for (T str : oldArray) {
            if (str != null) {
                insert(str);
            }
        }
    }

    private void allocateArray(int arraySize) {
        array = (T[]) new Object[arraySize];
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

    private Random r = new Random();
    private int rehashes = 0;

    private boolean insertHelper(T x) {
        final int COUNT_LIMIT = 100;
        while (true) {
            int lastPos = -1;
            int pos;

            for (int count = 0; count < COUNT_LIMIT; count++) {
                for (int i = 0; i < numHashFunctions; i++) {
                    pos = myhash(x, i);
                    if (array[pos] == null) {
                        array[pos] = x;
                        currentSize++;
                        return true;
                    }
                }

                int i = 0;
                do {
                    pos = myhash(x, r.nextInt(numHashFunctions)); // 换hash函数
                } while (pos == lastPos && i++ < 5);  // 只找5个

                T temp = array[lastPos = pos];
                array[pos] = x;
                x = temp;
            }
            if (++rehashes > ALLOWED_REHASHES) {
                expand();
                rehashes = 0;
            } else {
                rehash();
            }
        }
    }

}
