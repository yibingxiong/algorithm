package book.chapter3.section3;

public class MyStack<T> {
    private T[] data;
    private final int DEFAULT_CAPATICITY = 10;
    private int topPos = -1;

    public MyStack() {
        clear();
    }


    // 清空
    public void clear() {
        data = (T[]) new Object[DEFAULT_CAPATICITY];
        topPos = -1;
    }

    // 个数
    public int size() {
        return topPos + 1;
    }

    public boolean isEmpty() {
        return topPos < 0;
    }

    public T pop() {
        T t = data[topPos];
        topPos--;
        return t;
    }

    public void push(T v) {
        if (++topPos >= data.length) {
            T[] newData = (T[]) new Object[data.length * 2 + 1];
            for (int i = 0; i < topPos; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        data[topPos] = v;
    }

    public T peek() {
        return data[topPos];
    }

}
