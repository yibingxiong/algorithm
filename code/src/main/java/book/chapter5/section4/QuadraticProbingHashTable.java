package book.chapter5.section4;

import java.security.cert.X509Certificate;

public class QuadraticProbingHashTable<T> {
    private HashEntry<T>[] array;
    private int currentSize;
    private static final int DEFAULT_size = 11;

    private static class HashEntry<T> {
        public T element;
        public boolean isActive;

        public HashEntry(T element) {
            this(element, true);
        }

        private HashEntry(T element, boolean isActive) {
            this.element = element;
            this.isActive = isActive;
        }
    }


    public QuadraticProbingHashTable() {
        this(DEFAULT_size);
    }

    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    public boolean contains(T x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    public void insert(T x) {
        int currentPos = findPos(x);
        if (isActive(currentPos)) {
            return;
        }

        array[currentPos] = new HashEntry<T>(x);

        if (currentSize > array.length / 2) {
            rehash();
        }
    }

    public void remove(T x) {
        int currentPos = findPos(x);
        if (isActive(currentPos)) {
            array[currentPos].isActive = false;
        }
    }

    private void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
    }

    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    private boolean isActive(int pos) {
        return array[pos] != null && array[pos].isActive;
    }

    private int findPos(T x) {
        int offset = 1;
        int currentPos = myHash(x);

        while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

    private void rehash() {
        HashEntry<T>[] oldArray = array;
        allocateArray(nextPrime(2 * oldArray.length + 1));
        currentSize = 0;
        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[i] != null && oldArray[i].isActive) {
                insert(oldArray[i].element);
            }
        }
    }

    private int myHash(T x) {
        return x.hashCode();
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
