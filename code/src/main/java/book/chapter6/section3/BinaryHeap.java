package book.chapter6.section3;

public class BinaryHeap<T extends Comparable<? super T>> {
    private static final int DEFAULT_CAPACITY = 11;
    private int currentSize;
    private T[] array;

    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public BinaryHeap(T[] items) {
        for (int i = 0; i < items.length; i++) {
            insert(items[i]);
        }
    }

    public void insert(T x) {
        if (currentSize == array.length - 1) {
            enlargeArray(2 * array.length + 1);
        }

        int hole = ++currentSize;
        for (array[0] = x; x.compareTo(array[hole / 2]) < 0; hole /= 2) {
            array[hole] = array[hole / 2];
        }
        array[hole] = x;
    }

    public T findMin() {
        return array == null ? null : array[1];
    }

    public T deleteMin() {
        T minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    private void percolateDown(int pos) {
        int child = 1;
        T tmp = array[pos];

        for (; pos * 2 <= currentSize; pos = child) {
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0) { // 找到儿子节点中较小的
                child++;
            }
            if (array[child].compareTo(tmp) < 0) {
                array[pos] = array[child];
            } else {
                break;
            }
        }
        array[pos] = tmp;
    }

    private void buildHeap() {
        for (int i = currentSize; i > 0; i--) {
            percolateDown(i);
        }
    }

    private void enlargeArray(int size) {
        T[] old = array;
        T[] newArr = (T[]) new Object[size];
        for (int i = 0; i < currentSize + 1; i++) {
            newArr[i] = old[i];
        }

        array = newArr;
    }

}
