package book.chapter3.section3;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPATICITY = 10;
    private int size = 0;
    private T[] data;


    public MyArrayList() {
        size = 0;
        data = (T[]) new Object[DEFAULT_CAPATICITY];
    }

    // 清空
    public void clear() {
        size = 0;
        data = (T[]) new Object[DEFAULT_CAPATICITY];
    }

    // 个数
    public int size() {
        return size;
    }

    public void trimSize() {
        T[] newData = (T[]) new Object[size];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public T get(int i) {
        return data[i];
    }

    public T set(int i, T v) {
        data[i] = v;
        return v;
    }

    public void ensureCapacity(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        int newSize = size < newCapacity ? size : newCapacity;
        for (int i = 0; i < newSize; i++) {
            newData[i] = data[i];
        }
        size = newSize;
        data = newData;
    }

    public boolean add(T v) {
        try {
            add(size, v);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void add(int idx, T v) {
        if (size + 1 > data.length) {
            ensureCapacity(size * 2);
        }
        for (int k = size; k > idx; k--) {
            data[k] = data[k - 1];
        }
        size++;
        data[idx] = v;
    }

    public T remove(int i) {
        T v = data[i];
        for (int k = i; k < size - 1; k++) {
            data[k] = data[k + 1];
        }
        size--;
        return v;
    }

    public T remove() {
        return remove(size - 1);
    }

    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T> {

        private int curIndex = 0;

        public boolean hasNext() {
            return curIndex < size();
        }

        public T next() {
            return data[curIndex++];
        }

        public void remove() {
            MyArrayList.this.remove(--curIndex);
        }
    }
}
