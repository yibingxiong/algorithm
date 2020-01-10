package book.chapter3.section3;

public class MyQueue<T> {
    private T[] data;

    private int size;
    private int front;
    private int back;


    private final int DEFAULT_SIZE = 10;

    public MyQueue() {
        this.data = (T[]) new Object[DEFAULT_SIZE];
        size = 0;
        front = 0;
        back = -1;
    }

    public void enqueue(T v) {
        if (size == data.length) {
            T[] newData = (T[]) new Object[size * 2 + 1];

            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
            front = 0;
            back = size - 1;
        }

        back++;
        if (back == data.length) {
            back = 0;
        }
        size++;
        data[back] = v;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        T t = data[front];

        front++;
        if (front == data.length) {
            front = 0;
        }
        return t;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
